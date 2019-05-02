package com.agencyReport.calculationModel;

import com.agencyReport.constants.CurrencyConversionUtil;
import com.agencyReport.domain.IncomeReport;
import com.agencyReport.dto.AgencyData;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This class has all the rules that needs to be performed over agencies which are imported.
 */
public class AgencyCalculation {

    private static ResourceBundle rb;

    {
        rb = ResourceBundle.getBundle("application");
        if (rb.containsKey("filePath")) {
            System.out.println("yes");
        } else System.out.println("no");
    }

    /**
     * Rule 1
     * Calculate average per capita income for each gender grouped by countries/cities.
     */
    public  List<IncomeReport> calculateAveragePerCapitaIncome(List<AgencyData> agencyDataList) {
        agencyDataList = changeToUSD(agencyDataList);
        // Map<countryOrCity,Map<Gender,income>>
        Map<String, Map<String, DoubleSummaryStatistics>> groupedByRegionAndGenderData = agencyDataList.stream()
                .collect(Collectors.groupingBy(
                        agencyData -> !agencyData.getCountry().isEmpty() ? agencyData.getCountry() : agencyData.getCity(),
                        Collectors.groupingBy(AgencyData::getGender, Collectors.summarizingDouble(AgencyData::getIncome))));

        final List<IncomeReport> incomeReports = new ArrayList<>();

        for(String countryOrCity : groupedByRegionAndGenderData.keySet()){
            Map<String, DoubleSummaryStatistics> doubleSummaryStats = groupedByRegionAndGenderData.get(countryOrCity);
            for(String gender :doubleSummaryStats.keySet()){
                IncomeReport incomeReport = new IncomeReport();
                incomeReport.setRegion(countryOrCity);
                incomeReport.setGender(gender);
                DoubleSummaryStatistics currGenderStats = doubleSummaryStats.get(gender);
                double averageIncome = currGenderStats.getAverage();
                incomeReport.setAverageIncome(averageIncome);
                incomeReports.add(incomeReport);
            }
        }
        // sorting on the basis of country/city and gender
        incomeReports.sort(Comparator.comparing(IncomeReport::getRegion).thenComparing(IncomeReport::getGender));

        return incomeReports;

    }

    private  List<AgencyData> changeToUSD(List<AgencyData> agencyDataList) {
        agencyDataList.forEach(a -> {a.setIncome(CurrencyConversionUtil.convertCurrencyToUSD(Double.parseDouble(rb.getString(a.getCurrencyEnum().toString())), a.getIncome()));});
        return agencyDataList;
    }


    /**
     * Rule 2
     * This method sorts the agencies by country.
     */
    public void sortByCountry(List<AgencyData> agencyDataList) {

    }

    /**
     * Rule 3
     * This method sorts the agencies by gender.
     */
    public void sortByGender(List<AgencyData> agencyDataList) {

    }


}
