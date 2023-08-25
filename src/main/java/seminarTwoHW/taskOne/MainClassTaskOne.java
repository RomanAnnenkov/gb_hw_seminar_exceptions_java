package seminarTwoHW.taskOne;

import seminarTwoHW.taskOne.exceptions.InvalidNumberException;
import seminarTwoHW.taskOne.view.ConsoleView;

public class MainClassTaskOne {
    /*
    Задача 1:
    Напишите программу, которая запрашивает у пользователя число и проверяет,
    является ли оно положительным. Если число отрицательное или равно нулю,
    программа должна выбрасывать исключение InvalidNumberException с сообщением "Некорректное число".
    В противном случае, программа должна выводить сообщение "Число корректно".
    */
    public static void main(String[] args) throws InvalidNumberException {
        ConsoleView view = new ConsoleView();
        view.run();
    }
}
