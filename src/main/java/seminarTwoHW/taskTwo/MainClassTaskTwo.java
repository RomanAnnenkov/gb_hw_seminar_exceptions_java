package seminarTwoHW.taskTwo;

import seminarTwoHW.taskTwo.exceptions.DivisionByZeroException;
import seminarTwoHW.taskTwo.view.ConsoleView;
/*
Задача 2:
Напишите программу, которая запрашивает у пользователя два числа и выполняет их деление.
Если второе число равно нулю, программа должна выбрасывать исключение DivisionByZeroException
с сообщением "Деление на ноль недопустимо". В противном случае, программа должна выводить результат деления.
*/

public class MainClassTaskTwo {
    public static void main(String[] args) throws DivisionByZeroException {
        ConsoleView view = new ConsoleView();
        view.run();
    }

}
