package com.loadero.testui.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.Scanner;
import org.json.JSONObject;

public class ReceiveEmail {

    /**
     * Receives the email messages sent to provided email address.
     * Email messages are stored in emails.json file in the current directory 
     * where the mvn is run.
     * If the file is not found, empty array is returned.
     *
     * @param address email address to receive email to
     */
    public static EmailMessage[] receiveEmail(String address) {
        if (address == null || address.isEmpty()) {
            throw new Error("[ERROR] Loadero: No email address provided");
        }

        File f = new File("emails.json");

        if (!f.exists()) {
            return new EmailMessage[] {};
        }

        try {
            Scanner sc = new Scanner(f);

            String inline = "";
            while (sc.hasNext()) {
                inline += sc.nextLine();
            }

            sc.close();

            JSONObject json = new JSONObject(inline);

            ArrayList<EmailMessage> emails = new ArrayList<EmailMessage>();

            json.optJSONArray("emails").forEach(
                    email -> {
                        JSONObject e = (JSONObject) email;
                        Map<String, String> headers = checkAndTransform(e.getJSONObject("headers").toMap());

                        emails.add(new EmailMessage(e.getString("from"), e.getString("subject"),
                                headers, e.getString("text/plain"),
                                e.getString("text/html")));
                    });

            if (emails.size() == 0) {
                System.out.println("[INFO] Loadero: No emails received for " + address);
            }

            EmailMessage[] result = new EmailMessage[emails.size()];

            return emails.toArray(result);
        } catch (Exception e) {
            throw new Error("[ERROR] Loadero: Failed to receive email");
        }

    }

    /**
     * Generates an email address with the provided address.
     * If the provided address is already an email address, it will be returned as is.
     * Otherwise, the provided address will be used as a prefix and the domain will
     * be added.
     *
     * @param address email address
     */
    public static String genEmail(String address) {
        if (address.contains("@")) {
            return address;
        }

        return String.join("", address, "@", "mailinator.com");
    }

    private static Map<String, String> checkAndTransform(Map<String, Object> inputMap) {
        Map<String, String> result = new HashMap<>();
        for (Map.Entry<String, Object> entry : inputMap.entrySet()) {
            try {
                result.put(entry.getKey(), (String) entry.getValue());
            } catch (ClassCastException e) {
                throw e;
            }
        }
        return result;
    }
}
