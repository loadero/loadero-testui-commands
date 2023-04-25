package com.loadero.testui.commands;

public class RequestHeader {

    /**
     * Executes javascript command to set custom request header.
     *
     * @param header custom request header to modify.
     * @param value  custom request header new value. Pass in null to reset to default specific
     *               request header value.
     */
    public static void setRequestHeader(String header, String value) {
        if (header == null || header.isEmpty()) {
            throw new Error("[ERROR] Loadero: No request header provided");
        }

        System.out.println("[INFO] Loadero: Request header set sucessfully");
    }
}
