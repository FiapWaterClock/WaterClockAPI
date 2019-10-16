package br.com.waterclock.api.model;

import br.com.waterclock.api.entity.Consumption;

import java.util.List;

public class MonthConsumptionModel {

    private Consumption consumptionMonth;
    private List<Consumption> consumptionDays;
    private Rate rate;

    public MonthConsumptionModel(Consumption consumptionMonth, List<Consumption> consumptionDays, Rate rate) {
        this.consumptionMonth = consumptionMonth;
        this.consumptionDays = consumptionDays;
        this.rate = rate;
    }

    public MonthConsumptionModel() {
    }

    public Consumption getConsumptionMonth() {
        return consumptionMonth;
    }

    public void setConsumptionMonth(Consumption consumptionMonth) {
        this.consumptionMonth = consumptionMonth;
    }

    public List<Consumption> getConsumptionDays() {
        return consumptionDays;
    }

    public void setConsumptionDays(List<Consumption> consumptionDays) {
        this.consumptionDays = consumptionDays;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }
}
