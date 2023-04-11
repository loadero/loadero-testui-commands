package com.loadero.testui.commands;

import static testUI.TestUIDriver.getSelenideDriver;
import static testUI.TestUIDriver.setDriver;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.openqa.selenium.WebDriver;
import testUI.Utils.Logger;

public class TimeExecution {

    public static void timeExecution(String name, Command command) {
        timeExecution(name, command, 0);
    }

    public static void timeExecution(String name, Command command, int timeout) {
        if (name.isEmpty()) {
            name = "anonymous";
        }

        if (!Pattern.matches("^[\\w-]{1,150}$", name)) {
            throw new Error("[ERROR] Loadero: Invalid name provided, "
                            + "name should not exceed 150 characters in length and "
                            + "can only contain alphanumeric characters, "
                            + "underscores and hyphens");
        }

        if (timeout < 0) {
            throw new Error("[ERROR] Loadero: timeout value cannot be negative");
        }

        boolean successful = false;
        long start = System.currentTimeMillis();

        if (timeout > 0) {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.submit(new CommandTask(command, getSelenideDriver()));
            executor.shutdown();

            try {
                successful = executor.awaitTermination(timeout, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                throw new Error(String.format("[ERROR] Loadero: Command execution was "
                                              + "interrupted: %s",
                    e.getMessage()
                ));
            } finally {
                executor.shutdownNow();
            }
        } else {
            command.execute();
            successful = true;
        }

        long end = System.currentTimeMillis();

        if (!successful) {
            throw new Error(String.format(
                "[ERROR] Loadero: Timeout %dms reached while timing the execution of '%s'",
                timeout * 1000,
                name
            ));
        }

        Logger.putLogInfo("[INFO] Loadero: Execution time for '%s': %dms (start: %d; end: %d).",
            name,
            end - start,
            start,
            end
        );
    }

    public interface Command {
        void execute();
    }

    private static class CommandTask implements Runnable {
        Command command;
        WebDriver driver;

        public CommandTask(Command c, WebDriver d) {
            command = c;
            driver = d;
        }

        public void run() {
            setDriver(driver);
            command.execute();
        }
    }
}
