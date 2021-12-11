import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImportFileServiceImplTest {

    private final ImportFileService importFileService = new ImportFileServiceImpl();

    @Test
    public void taskCalculationShouldGivenCorrectResult() {
        //given
        String file = "src/test/resources/example.txt";
        Integer startRowNumber = 1;
        Row rowApplyData = new Row(11, "APPLY", 10);
        Row calculationResult = new Row(11, "RESULT", 14.0);

        //when
        Row result = importFileService.taskCalculations(startRowNumber, rowApplyData, file);

        //then
        assertEquals(calculationResult.getRowNumber(), result.getRowNumber());
        assertEquals(calculationResult.getFunction(), result.getFunction());
        assertEquals(calculationResult.getValue(), result.getValue());
    }

    @Test
    public void taskCalculationShouldGivenCorrectResultWhenTheFunctionContainsNegativeValue() {
        //given
        String file = "src/test/resources/example2.txt";
        Integer startRowNumber = 1;
        Row rowApplyData = new Row(6, "APPLY", 10);
        Row calculationResult = new Row(6, "RESULT", -6.0);

        //when
        Row result = importFileService.taskCalculations(startRowNumber, rowApplyData, file);

        //then
        assertEquals(calculationResult.getRowNumber(), result.getRowNumber());
        assertEquals(calculationResult.getFunction(), result.getFunction());
        assertEquals(calculationResult.getValue(), result.getValue());
    }

    @Test
    public void multiRowApplyData() {
        //given
        String file = "src/test/resources/multi_example.txt";
        List<Row> applyData = new ArrayList<>();
        applyData.add(new Row(6, "APPLY", 10));
        applyData.add(new Row(13, "APPLY", 10));

        //when
        List<Row> result = importFileService.rowApplyData(file);

        //then
        assertEquals(applyData.get(0).getRowNumber(), result.get(0).getRowNumber());
        assertEquals(applyData.get(0).getFunction(), result.get(0).getFunction());
        assertEquals(applyData.get(0).getValue(), result.get(0).getValue());
        assertEquals(applyData.get(1).getRowNumber(), result.get(1).getRowNumber());
        assertEquals(applyData.get(1).getFunction(), result.get(1).getFunction());
        assertEquals(applyData.get(1).getValue(), result.get(1).getValue());
    }
}
