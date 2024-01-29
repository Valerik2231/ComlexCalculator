import Run.ComplexCalcProcess;
import model.ComplexCalculator;
import model.ComplexNumber;
import model.LoggingComplexCalculator;

public class Main {
    public static void main(String[] args) {

        var calc = new ComplexCalcProcess(new LoggingComplexCalculator(new ComplexCalculator()));
        calc.Run();

    }
}