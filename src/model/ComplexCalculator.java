package model;

import model.interfaces.IComplexCalculator;
import model.interfaces.IComplexNumber;

public class ComplexCalculator implements IComplexCalculator {

    private IComplexNumber result;

    public ComplexCalculator(){
        result = new ComplexNumber();
    }
    @Override
    public void add(IComplexNumber num1, IComplexNumber num2) {
        var temp = ComplexOperatorHelper.add(num1,num2);
        result = ComplexOperatorHelper.add(result, temp);
    }
    @Override
    public void subtract(IComplexNumber num1, IComplexNumber num2) {
        var temp = ComplexOperatorHelper.subtract(num1,num2);
        result = ComplexOperatorHelper.add(result, temp);
    }

    @Override
    public void multiply(IComplexNumber num1, IComplexNumber num2) {
        var temp = ComplexOperatorHelper.multiply(num1,num2);
        result = ComplexOperatorHelper.add(result, temp);
    }

    @Override
    public void divide(IComplexNumber num1, IComplexNumber num2) {
        var temp = ComplexOperatorHelper.divide(num1,num2);
        result = ComplexOperatorHelper.add(result, temp);
    }

    @Override
    public IComplexNumber result() {
        return result;
    }

    @Override
    public void Clear() {
        result = new ComplexNumber();
    }

    private static class ComplexOperatorHelper {
        static ComplexNumber add(IComplexNumber num1, IComplexNumber num2){
            double real = num1.getReal() + num2.getReal();
            double imaginary =num1.getImaginary() + num2.getImaginary();
            return new ComplexNumber(real, imaginary);
        }
        static ComplexNumber subtract(IComplexNumber num1, IComplexNumber num2){
            double real = num1.getReal() - num2.getReal();
            double imaginary = num1.getImaginary() - num2.getImaginary();
            return new ComplexNumber(real, imaginary);
        }
        static ComplexNumber multiply(IComplexNumber num1, IComplexNumber num2){
            double real = num1.getReal() * num2.getReal() - num1.getImaginary() * num2.getImaginary();
            double imaginary = num1.getReal() * num2.getImaginary() + num1.getImaginary() * num2.getReal();
            return new ComplexNumber(real, imaginary);
        }
        static ComplexNumber divide(IComplexNumber num1, IComplexNumber num2){
            double devider = Math.pow(num2.getReal(), 2) + Math.pow(num2.getImaginary(), 2);
            double real = (num1.getReal() * num2.getReal() + num1.getImaginary() * num2.getImaginary()) / devider;
            double imaginary = (num1.getImaginary() * num2.getReal() - num1.getReal() * num2.getImaginary()) / devider;

            return new ComplexNumber(real, imaginary);
        }

    }
}
