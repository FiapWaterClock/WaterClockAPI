package br.com.waterclock.api.model;

public class ClockModel {

    private int clockId;
    private int userId;

    public ClockModel(int clockId, int userId) {
        this.clockId = clockId;
        this.userId = userId;
    }

    public ClockModel() {
    }

    public int getClockId() {
        return clockId;
    }

    public void setClockId(int clockId) {
        this.clockId = clockId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
