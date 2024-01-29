package model;

import model.interfaces.IComplexNumber;

public class ComplexNumber implements IComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(){
        real = 0;
        imaginary=0;
    }

    public ComplexNumber(double real, double imaginary){

        this.real = real;
        this.imaginary = imaginary;
    }
    public double getReal() {
        return real;
    }
    @Override
    public double getImaginary() {
        return imaginary;
    }
    @Override
    public String toString(){
        return new String().format("%f, %fi",real,imaginary);
    }
}
