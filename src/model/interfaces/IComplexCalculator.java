package model.interfaces;

import model.ComplexNumber;

public interface IComplexCalculator {
    void add(IComplexNumber num1, IComplexNumber num2);
    void subtract(IComplexNumber num1, IComplexNumber num2);
    void multiply(IComplexNumber num1, IComplexNumber num2);
    void divide(IComplexNumber num1, IComplexNumber num2);

    IComplexNumber result();
    void Clear();
}
