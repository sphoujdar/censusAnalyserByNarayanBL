package censusanalyser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.fail;

public class CSVStatesAnalyserTest {

    private static final String STATE_CODE_CSV_FILE_PATH = "./src/test/resources/IndiaStateCode.csv";
    private static final String STATE_CODE_WRONG_CSV_FILE_PATH = "./src/main/resources/IndianStateCode.csv";
    private static final String STATE_CODE_WRONG_FILE_EXTENSION = "./src/test/resources/IndianStateCode.txt";
    private static final String STATE_CODE_WRONG_DELIMITER_IN_DATA = "./src/test/resources/IndiaStateCensusDataWrongDelimiter.csv";
    private static final String STATE_CODE_WRONG_HEADER_IN_DATA = "./src/test/resources/IndiaStateCensusDataWrongHeader.csv";

    @Test
    public void givenStateCodeDataCSVFile_ReturnsCorrectRecords() {
        try {
            CSVStatesAnalyser csvStatesAnalyser = new CSVStatesAnalyser();
            int numOfRecords = csvStatesAnalyser.loadStatesCodeData(STATE_CODE_CSV_FILE_PATH);
            Assert.assertEquals(37,numOfRecords);
        } catch (CSVStatesException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void givenStateCodeDataCSVFile_WithWrongFilePath_ShouldThrowException() {
        try {
            CSVStatesAnalyser csvStatesAnalyser = new CSVStatesAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CSVStatesException.class);
            csvStatesAnalyser.loadStatesCodeData(STATE_CODE_WRONG_CSV_FILE_PATH);
        } catch (CSVStatesException e) {
            Assert.assertEquals(CSVStatesException.ExceptionTypeStates.CSV_FILE_PROBLEM,e.type);
        }
    }

    @Test
    public void givenStateCodeDataCSVFile_WithWrongFileType_ShouldThrowException() {
        try {
            CSVStatesAnalyser csvStatesAnalyser = new CSVStatesAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CSVStatesException.class);
            csvStatesAnalyser.loadStatesCodeData(STATE_CODE_WRONG_FILE_EXTENSION);
        } catch (CSVStatesException e) {
            Assert.assertEquals(CSVStatesException.ExceptionTypeStates.CSV_FILE_PROBLEM,e.type);
        }
    }

    @Test
    public void givenStateCodeDataCSVFile_WithWrongDelimiterType_ShouldThrowException() {
        try {
            CSVStatesAnalyser csvStatesAnalyser = new CSVStatesAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CSVStatesException.class);
            csvStatesAnalyser.loadStatesCodeData(STATE_CODE_WRONG_DELIMITER_IN_DATA);
        } catch (CSVStatesException e) {
            Assert.assertEquals(CSVStatesException.ExceptionTypeStates.DATA_FORMAT_PROBLEM,e.type);
        }
    }

    @Test
    public void givenStateCodeDataCSVFile_WithWrongHeader_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(STATE_CODE_WRONG_HEADER_IN_DATA);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
            Assert.assertEquals(CensusAnalyserException.ExceptionType.DATA_FORMAT_PROBLEM,e.type);
        }
    }



}
