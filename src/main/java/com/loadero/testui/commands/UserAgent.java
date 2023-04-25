package com.loadero.testui.commands;

public class UserAgent {

    /**
     * Executes JavaScript command to set specified User-Agent.
     *
     * @param userAgent custom User-Agent header and navigator value. Pass in null to reset to
     *                  default specific User-Agent value.
     */
    public static void setUserAgent(String userAgent) {
        System.out.println("[INFO] Loadero: User agent set successfully");
    }
}
