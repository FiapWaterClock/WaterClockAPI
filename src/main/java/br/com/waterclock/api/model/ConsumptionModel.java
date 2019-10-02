package br.com.waterclock.api.model;

public class ConsumptionModel {
    private int clockId;
    private double litersPerMinute;

    public int getClockId() {
        return clockId;
    }

    public void setClockId(int clockId) {
        this.clockId = clockId;
    }

    public double getLitersPerMinute() {
        return litersPerMinute;
    }

    public void setLitersPerMinute(double litersPerMinute) {
        this.litersPerMinute = litersPerMinute;
    }
}
