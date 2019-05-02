package com.agencyReport.constants;

/**
 * This file contains the value of each currency value that is equal to 1 USD.
 * For ex - to convert  1 USD to INR it will be 1* INR(66) =66 INR;
 */
public class CurrencyConversionUtil {

    public static double convertCurrencyToUSD(double rate, double amountToBeConvertedToUSD) {
        return amountToBeConvertedToUSD / rate;
    }

}
