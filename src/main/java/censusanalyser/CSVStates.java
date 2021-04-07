package censusanalyser;

import com.opencsv.bean.CsvBindByName;

public class CSVStates {

    @CsvBindByName(column = "StateName", required = true)
    public String stateName;

    @CsvBindByName(column = "SrNo", required = true)
    public int serialNumber;

    @CsvBindByName(column = "TIN", required = true)
    public int tin;

    @CsvBindByName(column = "stateCode", required = true)
    public String stateCode;

    @Override
    public String toString() {
        return "CSVStates{" +
                "stateName='" + stateName + '\'' +
                ", serialNumber=" + serialNumber +
                ", tin=" + tin +
                ", stateCode='" + stateCode + '\'' +
                '}';
    }
}
