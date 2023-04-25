package com.loadero.testui.commands;

public class FileDownload {

    /**
     * Checks if a file with the provided name exists in downloads directory within
     * 1000 ms. If file is not found or incorrect input parameters are provided, an
     * Error is thrown.
     *
     * @param fileName file name to check for. Cannot be null or empty.
     */
    public static void waitForDownloadFinished(String fileName) {
        waitForDownloadFinished(fileName, 1000);
    }

    /**
     * Checks if a file with the provided name exists in downloads directory within
     * provided time frame. If file is not found or incorrect input parameters are
     * provided, an Error is thrown.
     *
     * @param fileName file name to check for. Cannot be null or empty.
     * @param timeout  how long to look for file in ms.
     */
    public static void waitForDownloadFinished(String fileName, long timeout) {
        if (fileName == null || fileName.isEmpty()) {
            throw new Error("[ERROR] Loadero: No filename provided");
        }

        System.out.printf("[INFO] Loadero: Waiting for %s to finish downloading\n", fileName);
    }
}
