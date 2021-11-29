public class Row {
    private String function;
    private double value;
    private int rowNumber;

    public Row() {
    }

    public Row(String function, double value) {
        this.function = function;
        this.value = value;
    }

    public Row(int rowNumber, String function, double value) {
        this.function = function;
        this.value = value;
        this.rowNumber = rowNumber;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }
}
