package Run;

import model.ComplexNumber;
import model.interfaces.ICommand;
import model.interfaces.IComplexCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ComplexCalcProcess implements IMenu {

    private IComplexCalculator calculator;
    private List<ICommand> commands = new ArrayList<>();
    private boolean processContinue = true;
    public ComplexCalcProcess(IComplexCalculator calculator){
        this.calculator = calculator;

    }

    public void Run(){
        while (processContinue){
            ShowMenu();
            EnterMenuOption(GetLine("Введите номер меню: "));
        }
    }
    @Override
    public void ShowMenu() {
        System.out.println("1-сложить");
        System.out.println("2-вычесть");
        System.out.println("3-умножить");
        System.out.println("4-разделить");
        System.out.println("5-выход");
    }

    @Override
    public void EnterMenuOption(String menuSelect) {
        if (menuSelect == "5"){
            processContinue = false;
            return;
        }

        System.out.println("Введите первое число:");
        var num1 = GetComplex();
        System.out.println("Введите второе число:");
        var num2 = GetComplex();

        switch (menuSelect){
            case "1":
                calculator.add(num1,num2);
                break;
            case "2":
                calculator.subtract(num1,num2);
                break;
            case "3":
                calculator.multiply(num1,num2);
                break;
            case "4":
                calculator.divide(num1,num2);
                break;
            case "5":
                processContinue = false;
                break;

            default:
                System.out.println("Ошибка ввода");
                return;
        }
        System.out.print("Результат: ");
        System.out.println(calculator.result());

    }


    public double GetDoubleNumber(){
        double result = 0;
        boolean notOkey = true;
        while (notOkey){
            try {
                result = Double.parseDouble(GetLine());
                notOkey = false;
            }
            catch (Exception e){
                System.out.println("Ошибка ввода! Попробуйте ещё раз: ");
            }
        }
        return result;
    }
    private String GetLine(){
        Scanner scanner = new Scanner(System.in);
        var result = scanner.nextLine();
        //scanner.close();
        return result;
    }
    private String GetLine(String message){
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        var result = scanner.nextLine();
        //scanner.close();
        return result;
    }

    @Override
    public void Exit() {
        System.exit(0);
    }

    private ComplexNumber GetComplex(){
        System.out.println("Введите реальную часть числа");
        var real = GetDoubleNumber();
        System.out.println("Введите мнимую часть числа");
        var imaginary = GetDoubleNumber();

        return new ComplexNumber(real,imaginary);
    }


}
