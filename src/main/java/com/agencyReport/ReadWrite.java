package com.agencyReport;

import com.agencyReport.domain.ADReportType;
import com.agencyReport.dto.ADReaderInputType;

import java.util.List;

/**
 * Created by Shikhar on 01-05-2019.
 */
public abstract class ReadWrite<T extends ADReaderInputType,U extends ADReportType> {

    /**
     * Method to read a specific file.
     */
    public abstract List<T> read();

    /**
     * Method to write into a specific file.
     */
    public abstract boolean write(List<U> dataToWrite, String fileName);
}
