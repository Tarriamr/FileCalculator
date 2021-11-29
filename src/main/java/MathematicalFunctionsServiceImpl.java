public class MathematicalFunctionsServiceImpl implements MathematicalFunctionsService {

    @Override
    public double add(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    @Override
    public double subtract(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    @Override
    public double multiply(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    @Override
    public double divide(double firstNumber, double secondNumber) {
        if (secondNumber == 0) {
            throw new IllegalArgumentException("You try divide by zero!");
        }
        return firstNumber / secondNumber;
    }

    private double roundUp(double number) {
        long round = Math.round(number * 10000);
        return round / 10000d;
    }
}
