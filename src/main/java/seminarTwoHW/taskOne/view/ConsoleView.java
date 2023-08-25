package seminarTwoHW.taskOne.view;

import seminarTwoHW.taskOne.exceptions.InvalidNumberException;
import seminarTwoHW.taskOne.program.NumberChecker;

import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    public void run() throws InvalidNumberException {
        System.out.println("Программа, которая запрашивает число и проверяет, является ли оно положительным.");
        System.out.print("Введите число: ");
        String input = scanner.nextLine();
        ;
        while (!input.matches("[-]*[\\d]{1,9}")) {
            if (input.matches("[-]*[\\d]{10,}")) {
                System.out.println("Вы ввели '" + input + "' - это слишком большое число.");
                System.out.print("Введите число с количеством разрядов меньше 10: ");
            } else {
                System.out.print("Вы ввели '" + input + "' - это не число, введите число: ");
            }
            input = scanner.nextLine();
        }

        NumberChecker numberChecker = new NumberChecker(Integer.parseInt(input));
        if (numberChecker.checkNumber()) {
            System.out.println("Число корректно");
        }

    }

}
