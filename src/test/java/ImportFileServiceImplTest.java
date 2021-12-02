import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImportFileServiceImplTest {

    private final ImportFileService importFileService = new ImportFileServiceImpl();

    @Test
    public void fileCalculationShouldGivenCorrectResult() {

        //given
        String file = "src/test/resources/example.txt";
        Row calculationResult = new Row(6, "RESULT", 14.0);

        //when
        Row result = importFileService.fileCalculateResult(file);

        //then
        assertEquals(calculationResult.getRowNumber(), result.getRowNumber());
        assertEquals(calculationResult.getFunction(), result.getFunction());
        assertEquals(calculationResult.getValue(), result.getValue());
    }

    @Test
    public void fileCalculationShouldGivenCorrectResultWhenTheFunctionContainsNegativeValue() {

        //given
        String file = "src/test/resources/example2.txt";
        Row calculationResult = new Row(6, "RESULT", -6.0);

        //when
        Row result = importFileService.fileCalculateResult(file);

        //then
        assertEquals(calculationResult.getRowNumber(), result.getRowNumber());
        assertEquals(calculationResult.getFunction(), result.getFunction());
        assertEquals(calculationResult.getValue(), result.getValue());
    }
}
