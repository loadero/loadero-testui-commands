package com.loadero.testui.commands;

public class ConditionerBuilder {

    private final Conditioner cfg;

    public ConditionerBuilder() {
        cfg = new Conditioner();
    }

    public Conditioner buildConditioner() {
        return cfg;
    }

    public ConditionerBuilder latency(double up, double down) {
        cfg.setLatencyUp(up);
        cfg.setLatencyDown(down);

        return this;
    }

    public ConditionerBuilder latencyUp(double up) {
        cfg.setLatencyUp(up);
        return this;
    }

    public ConditionerBuilder latencyDown(double down) {
        cfg.setLatencyUp(down);
        return this;
    }

    public ConditionerBuilder jitter(double up, double down) {
        cfg.setJitterUp(up);
        cfg.setJitterDown(down);

        return this;
    }

    public ConditionerBuilder jitterUp(double up) {
        cfg.setJitterUp(up);
        return this;
    }

    public ConditionerBuilder jitterDown(double down) {
        cfg.setJitterDown(down);
        return this;
    }

    public ConditionerBuilder rate(double up, double down) {
        cfg.setRateUp(up);
        cfg.setRateDown(down);

        return this;
    }

    public ConditionerBuilder rateUp(double up) {
        cfg.setRateUp(up);
        return this;
    }

    public ConditionerBuilder rateDown(double down) {
        cfg.setRateDown(down);
        return this;
    }

    public ConditionerBuilder loss(double up, double down) {
        cfg.setLossUp(up);
        cfg.setLossDown(down);

        return this;
    }

    public ConditionerBuilder lossUp(double up) {
        cfg.setLossUp(up);
        return this;
    }

    public ConditionerBuilder lossDown(double down) {
        cfg.setLossDown(down);
        return this;
    }
}
