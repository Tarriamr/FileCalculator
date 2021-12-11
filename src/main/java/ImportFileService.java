import java.util.List;

public interface ImportFileService {

    Row taskCalculations(Integer startRowNumber, Row rowApplyData, String file);

    List<Row> rowApplyData(String file);
}
