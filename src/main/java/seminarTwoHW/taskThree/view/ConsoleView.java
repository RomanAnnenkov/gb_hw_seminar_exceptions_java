package seminarTwoHW.taskThree.view;

import seminarTwoHW.taskThree.exceptions.DivisionByZeroException;
import seminarTwoHW.taskThree.exceptions.NumberOutOfRangeException;
import seminarTwoHW.taskThree.exceptions.NumberSumException;
import seminarTwoHW.taskThree.program.NumberChecker;

import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner = new Scanner(System.in);
    private final NumberChecker numberChecker = new NumberChecker();

    public void run() throws NumberOutOfRangeException, DivisionByZeroException, NumberSumException {
        System.out.println("""
                Программа запрашивает три числа и выполняет проверки,
                первое число меньше 100,
                второе число больше 0,
                сумма 1-го и 2-го чисел больше 10,
                3-е число не равно 0.""");


        numberChecker.setFirstNumber(getNumber("первое"));
        boolean checkFirst = numberChecker.checkFirstNumber();
        numberChecker.setSecondNumber(getNumber("второе"));
        boolean checkSecond = numberChecker.checkSecondNumber();
        boolean checkSumFirstAndSecond = numberChecker.checkSumFirstAndSecond();
        numberChecker.setThirdNumber(getNumber("третье"));
        boolean checkThird = numberChecker.checkThirdNumber();

        if (checkFirst && checkSecond && checkSumFirstAndSecond && checkThird) {
            System.out.println("Проверка пройдена успешно");
        }

    }

    private double getNumber(String serialNumber) {
        System.out.print("Введите " + serialNumber + " число: ");
        String input = scanner.nextLine();
        while (!input.matches("[-]*[\\d]{1,}\\.*[\\d]{0,}")) {
            System.out.print("Вы ввели '" + input + "' - это не число, введите " + serialNumber + " число: ");
            input = scanner.nextLine();
        }
        return Double.parseDouble(input);
    }
}
