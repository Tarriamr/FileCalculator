import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ImportFileServiceImpl implements ImportFileService {

    @Override
    public Row taskCalculations(Integer startRowNumber, Row rowApplyData, String file) {

        String line;
        Row rowData;
        ReaderFile readerFile = new ReaderFileImpl();

        Row calculationResult = new Row(Objects.requireNonNull(rowApplyData).getRowNumber(), "RESULT", rowApplyData.getValue());
        MathematicalFunctionsService mathematicalFunctionsService = new MathematicalFunctionsServiceImpl();

        try {
            LineNumberReader lineNumberReader = new LineNumberReader(readerFile.readerFile(file));
            while ((line = lineNumberReader.readLine()) != null) {
                if (lineNumberReader.getLineNumber() >= startRowNumber && lineNumberReader.getLineNumber() <= rowApplyData.getRowNumber()) {
                    rowData = rowConvertToFunctionAndNumber(line);

                    switch (rowData.getFunction()) {
                        case "ADD" -> calculationResult.setValue(mathematicalFunctionsService.add(calculationResult.getValue(), rowData.getValue()));
                        case "SUBTRACT" -> calculationResult.setValue(mathematicalFunctionsService.subtract(calculationResult.getValue(), rowData.getValue()));
                        case "MULTIPLY" -> calculationResult.setValue(mathematicalFunctionsService.multiply(calculationResult.getValue(), rowData.getValue()));
                        case "DIVIDE" -> calculationResult.setValue(mathematicalFunctionsService.divide(calculationResult.getValue(), rowData.getValue()));
                        case "APPLY" -> {
                            return calculationResult;
                        }
                        case "" -> {
                            if (!line.isEmpty()) {
                                System.out.printf("""
                                        Line: %d - has been omitted.
                                            The line is incorrect: %s
                                        """, lineNumberReader.getLineNumber(), line);
                            }
                        }
                        case default -> System.out.printf("""
                                Line: %d - has been omitted.
                                    There is an invalid function: %s
                                """, lineNumberReader.getLineNumber(), rowData.getFunction());
                    }
                }
            }
        } catch (IOException e) {
            return null;
        }
        return null;
    }

    public List<Row> rowApplyData(String file) {

        List<Row> result = new ArrayList<>();
        String line;
        Row rowData;
        ReaderFile readerFile = new ReaderFileImpl();

        try {
            LineNumberReader lineNumberReader = new LineNumberReader(readerFile.readerFile(file));
            while ((line = lineNumberReader.readLine()) != null) {
                rowData = rowConvertToFunctionAndNumber(line);
                if (Objects.equals(rowData.getFunction(), "APPLY")) {
                    rowData.setRowNumber(lineNumberReader.getLineNumber());
                    result.add(rowData);
                }
            }
            lineNumberReader.close();
        } catch (IOException e) {
            return null;
        }
        return result;
    }

    private Row rowConvertToFunctionAndNumber(String fileRow) {
        StringBuilder function = new StringBuilder();
        StringBuilder number = new StringBuilder();
        for (char c :
                fileRow.trim().toUpperCase().toCharArray()) {
            function.append(letter(c));
            number.append(digit(c));
            number.append(symbol(c));
        }
        if (number.isEmpty()) {
            number.append("0");
        }
        return new Row(function.toString(), Double.parseDouble(number.toString()));
    }

    private String letter(char c) {
        if (Character.isLetter(c)) {
            return Character.toString(c);
        } else {
            return "";
        }
    }

    private String digit(char c) {
        if (Character.isDigit(c)) {
            return Character.toString(c);
        } else {
            return "";
        }
    }

    private String symbol(char c) {
        if (c == ',' || c == '.') {
            return ".";
        } else if (c == '-') {
            return "-";
        } else {
            return "";
        }
    }
}
