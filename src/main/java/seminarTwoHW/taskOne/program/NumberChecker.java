package seminarTwoHW.taskOne.program;

import seminarTwoHW.taskOne.exceptions.InvalidNumberException;

public class NumberChecker {
    private int number;

    public NumberChecker(int number) {
        this.number = number;
    }

    public boolean checkNumber() throws InvalidNumberException {
        if (number > 0) {
            return true;
        }
        throw new InvalidNumberException("Некорректное число");
    }

}
