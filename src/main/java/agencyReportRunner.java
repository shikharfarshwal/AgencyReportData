import com.agencyReport.ReadWrite;
import com.agencyReport.calculationModel.AgencyCalculation;
import com.agencyReport.domain.IncomeReport;
import com.agencyReport.dto.AgencyData;
import com.agencyReport.type.CsvImpl;

import java.util.List;
import java.util.Random;

/**
 * Created by Shikhar on 01-05-2019.
 */
public class agencyReportRunner {

    public static void main(String[] args) {
        ReadWrite<AgencyData, com.agencyReport.domain.IncomeReport> csv = new CsvImpl();
        List<AgencyData> read = csv.read();
        AgencyCalculation agencyCalculation = new AgencyCalculation();
        List<IncomeReport> incomeReportList = agencyCalculation.calculateAveragePerCapitaIncome(read);
        Random random = new Random();
        String outputFileName = "E:\\codingTestSapient\\output" + random.nextInt(999) + ".csv";
        csv.write(incomeReportList,outputFileName);

    }
}
