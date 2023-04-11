package com.loadero.testui.commands;

import org.json.JSONObject;

public class Conditioner {

    private double latencyUp = 0;
    private double latencyDown = 0;
    private double jitterUp = 0;
    private double jitterDown = 0;
    private double rateUp = 0;
    private double rateDown = 0;
    private double lossUp = 0;
    private double lossDown = 0;

    public Conditioner() {
    }

    public double getLatencyUp() {
        return latencyUp;
    }

    public void setLatencyUp(double latencyUp) {
        this.latencyUp = latencyUp;
    }

    public double getLatencyDown() {
        return latencyDown;
    }

    public void setLatencyDown(double latencyDown) {
        this.latencyDown = latencyDown;
    }

    public double getJitterUp() {
        return jitterUp;
    }

    public void setJitterUp(double jitterUp) {
        this.jitterUp = jitterUp;
    }

    public double getJitterDown() {
        return jitterDown;
    }

    public void setJitterDown(double jitterDown) {
        this.jitterDown = jitterDown;
    }

    public double getRateUp() {
        return rateUp;
    }

    public void setRateUp(double rateUp) {
        this.rateUp = rateUp;
    }

    public double getRateDown() {
        return rateDown;
    }

    public void setRateDown(double rateDown) {
        this.rateDown = rateDown;
    }

    public double getLossUp() {
        return lossUp;
    }

    public void setLossUp(double lossUp) {
        this.lossUp = lossUp;
    }

    public double getLossDown() {
        return lossDown;
    }

    public void setLossDown(double lossDown) {
        this.lossDown = lossDown;
    }

    @SuppressWarnings("checkstyle:AbbreviationAsWordInName")
    protected String toJSONString() {
        JSONObject obj = new JSONObject();

        obj.put("latency_up", latencyUp);
        obj.put("latency_down", latencyDown);
        obj.put("jitter_up", jitterUp);
        obj.put("jitter_down", jitterDown);
        obj.put("rate_up", rateUp);
        obj.put("rate_down", rateDown);
        obj.put("loss_up", lossUp);
        obj.put("loss_down", lossDown);

        return obj.toString();
    }
}
