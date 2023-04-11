package com.loadero.testui.commands;

public class NetworkConditioner {

    /**
     * Changes network settings for the participant.
     *
     * @param networkMode network mode name to update to
     */
    public static void updateNetwork(String networkMode) {
        if (networkMode == null || networkMode.isEmpty()) {
            throw new Error("[ERROR] Loadero: No network mode provided");
        }

        System.out.println("[INFO] Loadero: Network condition update successful");
    }

    /**
     * Changes network settings for the participant to custom defined values.
     *
     * @param cfg configuration to update network values to
     */
    public static void updateNetwork(Conditioner cfg) {
        System.out.println("[INFO] Loadero: Network condition update successful");
    }
}
