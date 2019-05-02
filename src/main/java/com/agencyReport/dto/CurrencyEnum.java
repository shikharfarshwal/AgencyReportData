package com.agencyReport.dto;

public enum CurrencyEnum {
    INR("INR"), USD("USD"), HKD("HKD"), SGD("SGD"), GBP("GBP");

    String value;

    CurrencyEnum(String value) {
        this.value = value;
    }

    CurrencyEnum getValue(String value){
        return CurrencyEnum.valueOf(value);
    }
}
