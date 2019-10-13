package br.com.waterclock.api.service;

public class Rate {
    private static final double MINIMUNPRICE = 28.98;
    private static final double PRICE1 = 5.38;
    private static final double PRICE2 = 6.94;
    private static final double PRICE3 = 9.48;
    private static final double PRICE4 = 13.06;
    private static final double HIGHESTPRICE = 27.08;

    private static final double MINIMUMCONSUMPTION = 10000;
    private static final double CONSUMPTIONBAND1 = 17000;
    private static final double CONSUMPTIONBAND2 = 25000;
    private static final double CONSUMPTIONBAND3 = 35000;
    private static final double CONSUMPTIONBAND4 = 50000;

    private double consumedWater;
    private String band;
    private double price;


    public Rate(double consumedWater) {
        this.consumedWater = consumedWater;
        this.price = calculatePrice();
        this.band = defineBand();
    }


    public  double calculatePrice() {
        if (consumedWater < MINIMUMCONSUMPTION){
            return MINIMUNPRICE;
        } else if (consumedWater < CONSUMPTIONBAND1) {
            return consumedWater * PRICE1;
        } else if (consumedWater < CONSUMPTIONBAND2) {
            return consumedWater * PRICE2;
        } else if (consumedWater < CONSUMPTIONBAND3) {
            return consumedWater * PRICE3;
        } else if (consumedWater < CONSUMPTIONBAND4) {
            return consumedWater * PRICE4;
        } else {
            return consumedWater * HIGHESTPRICE;
        }
    }

    public  String defineBand(){
        if (consumedWater < MINIMUMCONSUMPTION){
            return "consumo mínimo";
        } else if (consumedWater < CONSUMPTIONBAND1) {
            return "faixa de cunsumo 1";
        } else if (consumedWater < CONSUMPTIONBAND2) {
            return "faixa de consumo 2";
        } else if (consumedWater < CONSUMPTIONBAND3) {
            return "faixa de consumo 3";
        } else if (consumedWater < CONSUMPTIONBAND4) {
            return "faixa de consumo 4";
        } else {
            return "faxa de consumo máximo";
        }
    }

    public double getConsumedWater() {
        return consumedWater;
    }

    public double getPrice() {
        return price;
    }

    public String getBand() {
        return band;
    }

    public static double getMINIMUNPRICE() {
        return MINIMUNPRICE;
    }

    public static double getPRICE1() {
        return PRICE1;
    }

    public static double getPRICE2() {
        return PRICE2;
    }

    public static double getPRICE3() {
        return PRICE3;
    }

    public static double getPRICE4() {
        return PRICE4;
    }

    public static double getHIGHESTPRICE() {
        return HIGHESTPRICE;
    }

    public static double getMINIMUMCONSUMPTION() {
        return MINIMUMCONSUMPTION;
    }

    public static double getCONSUMPTIONBAND1() {
        return CONSUMPTIONBAND1;
    }

    public static double getCONSUMPTIONBAND2() {
        return CONSUMPTIONBAND2;
    }

    public static double getCONSUMPTIONBAND3() {
        return CONSUMPTIONBAND3;
    }

    public static double getCONSUMPTIONBAND4() {
        return CONSUMPTIONBAND4;
    }
}
