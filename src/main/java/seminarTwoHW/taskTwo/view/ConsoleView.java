package seminarTwoHW.taskTwo.view;

import seminarTwoHW.taskTwo.exceptions.DivisionByZeroException;
import seminarTwoHW.taskTwo.program.MathOperation;

import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner = new Scanner(System.in);
    private final MathOperation mathOperation = new MathOperation();

    public void run() throws DivisionByZeroException {
        System.out.println("Программа, запрашивает два числа и выполняет их деление.");
        System.out.print("Введите первое число: ");
        String input = scanner.nextLine();
        while (!input.matches("[-]*[\\d]{1,}\\.*[\\d]{0,}")) {
            System.out.print("Вы ввели '" + input + "' - это не число, введите первое число: ");
            input = scanner.nextLine();
        }
        mathOperation.setNumberOne(Double.parseDouble(input));
        System.out.print("Введите второе число: ");
        input = scanner.nextLine();
        while (!input.matches("[-]*[\\d]{1,}\\.*[\\d]{0,}")) {
            System.out.print("Вы ввели '" + input + "' - это не число, введите второе число: ");
            input = scanner.nextLine();
        }
        mathOperation.setNumberTwo(Double.parseDouble(input));
        System.out.printf("Результат: " + mathOperation.divide());
    }


}
