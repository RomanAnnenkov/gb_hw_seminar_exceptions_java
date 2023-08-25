package seminarTwoHW.taskThree.program;

import seminarTwoHW.taskThree.exceptions.DivisionByZeroException;
import seminarTwoHW.taskThree.exceptions.NumberOutOfRangeException;
import seminarTwoHW.taskThree.exceptions.NumberSumException;

public class NumberChecker {
    private double firstNumber;
    private double secondNumber;
    private double thirdNumber;

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public void setThirdNumber(double thirdNumber) {
        this.thirdNumber = thirdNumber;
    }

    public boolean checkFirstNumber() throws NumberOutOfRangeException {
        if (firstNumber > 100) {
            throw new NumberOutOfRangeException("Первое число вне допустимого диапазона");
        }
        return true;
    }

    public boolean checkSecondNumber() throws NumberOutOfRangeException {
        if (secondNumber < 0) {
            throw new NumberOutOfRangeException("Второе число вне допустимого диапазона");
        }
        return true;
    }

    public boolean checkSumFirstAndSecond() throws NumberSumException {
        if (firstNumber + secondNumber < 10) {
            throw new NumberSumException("Сумма первого и второго чисел слишком мала");
        }
        return true;
    }

    public boolean checkThirdNumber() throws DivisionByZeroException {
        if (thirdNumber == 0) {
            throw new DivisionByZeroException("Деление на ноль недопустимо");
        }
        return true;
    }

}
