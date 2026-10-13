package com.bptn.course.__Team_Activities.Day11;

public class Tool {
    //Add final static variables for the multipliers
    private static final double RATE_1 = 1.05;
    private static final double RATE_2 = 1.10;
    private static final double RATE_3 = 1.15;

    public static double calc(double amount, int taxType) {
        //Refactor to use switch statement        
        switch (taxType) {
            case 1:
                return amount * RATE_1;
            case 2:
                return amount * RATE_2;
            case 3:
                return amount * RATE_3;
            default:
                return amount;
        }
    }
}
