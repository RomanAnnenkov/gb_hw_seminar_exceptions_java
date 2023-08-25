package seminarTwoHW.taskOne;

import seminarTwoHW.taskOne.exceptions.InvalidNumberException;
import seminarTwoHW.taskOne.view.ConsoleView;

public class MainClassTaskOne {
    public static void main(String[] args) throws InvalidNumberException {
        ConsoleView view = new ConsoleView();
        view.run();
    }
}
