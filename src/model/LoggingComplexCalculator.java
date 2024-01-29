package model;

import model.interfaces.IComplexCalculator;
import model.interfaces.IComplexNumber;

public class LoggingComplexCalculator implements IComplexCalculator {

    private IComplexCalculator calculator;

    public LoggingComplexCalculator(IComplexCalculator calculator) {
        this.calculator = calculator;


    }

    @Override
    public void add(IComplexNumber num1, IComplexNumber num2) {
        System.out.println(String.format("Складываю %s и %s", num1, num2));
        calculator.add(num1, num2);
    }

    @Override
    public void subtract(IComplexNumber num1, IComplexNumber num2) {
        System.out.println(String.format("Вычитаю %s и %s", num1, num2));
        calculator.subtract(num1, num2);
    }

    @Override
    public void multiply(IComplexNumber num1, IComplexNumber num2) {
        System.out.println(String.format("Умножаю %s и %s", num1, num2));
        calculator.multiply(num1, num2);
    }

    @Override
    public void divide(IComplexNumber num1, IComplexNumber num2) {
        System.out.println(String.format("Делю %s и %s", num1, num2));
        calculator.divide(num1, num2);

    }

    @Override
    public IComplexNumber result() {
        System.out.println(String.format("Вывод результата"));
        return calculator.result();

    }

    @Override
    public void Clear() {
        System.out.println("Очистка ввода");
        calculator.Clear();
    }
}

