package com.agencyReport.domain;

import com.agencyReport.dto.CurrencyEnum;

/**
 * Created by Shikhar on 02-05-2019.
 */
public class IncomeReport implements ADReportType {

    private String region;
    private String gender;
    private Double averageIncome;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getAverageIncome() {
        return averageIncome;
    }

    public void setAverageIncome(Double averageIncome) {
        this.averageIncome = averageIncome;
    }
}
