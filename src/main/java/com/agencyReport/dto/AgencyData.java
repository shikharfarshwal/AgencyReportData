package com.agencyReport.dto;

/**
 * Created by Shikhar on 01-05-2019.
 */
public class AgencyData implements ADReaderInputType{

    private String city;
    private String country;
    private String Gender;
    private CurrencyEnum currencyEnum;
    private Double Income;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public CurrencyEnum getCurrencyEnum() {
        return currencyEnum;
    }

    public void setCurrencyEnum(CurrencyEnum currencyEnum) {
        this.currencyEnum = currencyEnum;
    }

    public Double getIncome() {
        return Income;
    }

    public void setIncome(Double income) {
        Income = income;
    }

    @Override
    public String toString() {
        return "AgencyData{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", Gender='" + Gender + '\'' +
                ", currencyEnum=" + currencyEnum +
                ", Income=" + Income +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AgencyData that = (AgencyData) o;

        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (Gender != null ? !Gender.equals(that.Gender) : that.Gender != null) return false;
        if (currencyEnum != that.currencyEnum) return false;
        return Income != null ? Income.equals(that.Income) : that.Income == null;
    }

    @Override
    public int hashCode() {
        int result = city != null ? city.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (Gender != null ? Gender.hashCode() : 0);
        result = 31 * result + (currencyEnum != null ? currencyEnum.hashCode() : 0);
        result = 31 * result + (Income != null ? Income.hashCode() : 0);
        return result;
    }
}


