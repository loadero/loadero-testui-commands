package com.loadero.testui.commands;

import static testUI.TestUIDriver.getSelenideDriver;

import org.openqa.selenium.NoAlertPresentException;

public class IgnoreAlert {

    /**
     * Will ignore an alert if there is one present.
     */
    public static void ignoreAlert() {
        try {
            getSelenideDriver().switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
            return;
        }
    }
}
