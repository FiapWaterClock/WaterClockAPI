package br.com.waterclock.api.model;

import java.time.LocalDate;

public class ConsumptionModel {
    private int clockId;
    private double litersPerMinute;
    private LocalDate time;

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


    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }
}
