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
        return this.latencyUp;
    }

    public void setLatencyUp(double latencyUp) {
        this.latencyUp = latencyUp;
    }

    public double getLatencyDown() {
        return this.latencyDown;
    }

    public void setLatencyDown(double latencyDown) {
        this.latencyDown = latencyDown;
    }

    public double getJitterUp() {
        return this.jitterUp;
    }

    public void setJitterUp(double jitterUp) {
        this.jitterUp = jitterUp;
    }

    public double getJitterDown() {
        return this.jitterDown;
    }

    public void setJitterDown(double jitterDown) {
        this.jitterDown = jitterDown;
    }

    public double getRateUp() {
        return this.rateUp;
    }

    public void setRateUp(double rateUp) {
        this.rateUp = rateUp;
    }

    public double getRateDown() {
        return this.rateDown;
    }

    public void setRateDown(double rateDown) {
        this.rateDown = rateDown;
    }

    public double getLossUp() {
        return this.lossUp;
    }

    public void setLossUp(double lossUp) {
        this.lossUp = lossUp;
    }

    public double getLossDown() {
        return this.lossDown;
    }

    public void setLossDown(double lossDown) {
        this.lossDown = lossDown;
    }

    @SuppressWarnings("checkstyle:AbbreviationAsWordInName")
    protected String toJSONString() {
        JSONObject obj = new JSONObject();

        obj.put("latency_up", this.latencyUp);
        obj.put("latency_down", this.latencyDown);
        obj.put("jitter_up", this.jitterUp);
        obj.put("jitter_down", this.jitterDown);
        obj.put("rate_up", this.rateUp);
        obj.put("rate_down", this.rateDown);
        obj.put("loss_up", this.lossUp);
        obj.put("loss_down", this.lossDown);

        return obj.toString();
    }
}
