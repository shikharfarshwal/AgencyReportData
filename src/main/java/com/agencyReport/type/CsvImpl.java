package com.agencyReport.type;

import com.agencyReport.ReadWrite;
import com.agencyReport.domain.IncomeReport;
import com.agencyReport.dto.AgencyData;
import com.agencyReport.dto.CurrencyEnum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static com.agencyReport.constants.ModuleConstants.CsvConfigurations.*;

/**
 * This implementation class has the logic for read & write from and into csv file.
 */
public class CsvImpl extends ReadWrite<AgencyData,IncomeReport> {

    private static ResourceBundle rb;
    /**
     * List<AgencyData>
     */
    protected List<AgencyData> listOfCountryToGenderToIncome;

    {
        rb = ResourceBundle.getBundle("application");
        if (rb.containsKey("filePath")) {
            System.out.println("yes");
        } else System.out.println("no");
    }

    public List<AgencyData> read() {
        String line = "";
        String cvsSplitBy = ",";
        String csvFile = rb.getString("filePath");
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            listOfCountryToGenderToIncome = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] arrayOfAgenciesData = line.split(cvsSplitBy);
                if (arrayOfAgenciesData[0].equalsIgnoreCase("City")) {
                    continue;
                }
                populateAgencies(arrayOfAgenciesData);
                System.out.println("City= " + arrayOfAgenciesData[0] + " country name " + arrayOfAgenciesData[1] + "Gender" + arrayOfAgenciesData[2] + "currency" + arrayOfAgenciesData[3]
                        + "income" + arrayOfAgenciesData[4]);
            }
            return listOfCountryToGenderToIncome;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean write(List<IncomeReport> dataToWrite, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.append(FILE_HEADER);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (IncomeReport report : dataToWrite) {
                fileWriter.append(String.valueOf(report.getRegion()));
                fileWriter.append(DELIMITER);
                fileWriter.append(report.getGender());
                fileWriter.append(DELIMITER);
                fileWriter.append(String.valueOf(report.getAverageIncome()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }


    private void populateAgencies(String[] arrayOfAgenciesData) {
        AgencyData agencyData = new AgencyData();
        agencyData.setCity(arrayOfAgenciesData[0]);
        agencyData.setCountry(arrayOfAgenciesData[1]);
        agencyData.setGender(arrayOfAgenciesData[2]);
        agencyData.setCurrencyEnum(CurrencyEnum.valueOf(arrayOfAgenciesData[3]));
        agencyData.setIncome(Double.parseDouble(arrayOfAgenciesData[4]));
        listOfCountryToGenderToIncome.add(agencyData);
    }

}
