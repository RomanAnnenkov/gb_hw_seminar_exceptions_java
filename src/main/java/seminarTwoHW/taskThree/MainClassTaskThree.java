package seminarTwoHW.taskThree;

import seminarTwoHW.taskThree.exceptions.DivisionByZeroException;
import seminarTwoHW.taskThree.exceptions.NumberOutOfRangeException;
import seminarTwoHW.taskThree.exceptions.NumberSumException;
import seminarTwoHW.taskThree.view.ConsoleView;

public class MainClassTaskThree {
    /*
    Задача3: - по желанию
    Напишите программу, которая запрашивает у пользователя три числа и выполняет следующие проверки:
    Если первое число больше 100, выбросить исключение NumberOutOfRangeException с сообщением "Первое число вне допустимого диапазона".
    Если второе число меньше 0, выбросить исключение NumberOutOfRangeException с сообщением "Второе число вне допустимого диапазона".
    Если сумма первого и второго чисел меньше 10, выбросить исключение NumberSumException с сообщением "Сумма первого и второго чисел слишком мала".
    Если третье число равно 0, выбросить исключение DivisionByZeroException с сообщением "Деление на ноль недопустимо".
    В противном случае, программа должна выводить сообщение "Проверка пройдена успешно".
    */
    public static void main(String[] args) throws DivisionByZeroException, NumberOutOfRangeException, NumberSumException {
        ConsoleView view = new ConsoleView();
        view.run();
    }
}
