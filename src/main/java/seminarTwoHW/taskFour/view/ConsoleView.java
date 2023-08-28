package seminarTwoHW.taskFour.view;

import seminarTwoHW.taskFour.exceptions.InsufficientFundsException;
import seminarTwoHW.taskFour.exceptions.MaxBalanceExceededException;
import seminarTwoHW.taskFour.program.Bank;
import seminarTwoHW.taskFour.program.BankAccount;

import java.util.Scanner;

public class ConsoleView implements Runnable {
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("Программа управления банковскими счетами.");
        System.out.print("Введите название банка: ");
        String bankName = scanner.nextLine();
        Bank bank = new Bank(bankName);
        String input;
        boolean running = true;
        while (running) {
            System.out.print("Какую операцию вы хотите выполнить: ");
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    createAcc(bank);
                    break;
                case "2":
                    topUpAcc(bank);
                    break;
                case "3":
                    withdrawAcc(bank);
                    break;
                case "4":
                    setMax(bank);
                    break;
                case "5":
                    System.out.println("Информация о банке:");
                    System.out.println(bank);
                    break;
                case "6":
                    infoAcc(bank);
                    break;
                case "7":
                    System.out.println("Все счета банка:");
                    for (BankAccount bankAccount : bank.getAccounts().values()) {
                        System.out.println(bankAccount);
                    }
                    break;
                case "exit":
                    running = false;
                    break;
                default:
                    System.out.println("""
                            1 - открытие счета
                            2 - пополнение счета
                            3 - списание со счета
                            4 - задать максимальную сумму по счету
                            5 - информация о банке
                            6 - информация о счете
                            7 - вывод всех счетов банка
                            exit - завершение программы
                            """);
            }
        }
    }

    private void setMax(Bank operationBank) {
        String searchAccount = getAccountNumber();
        BankAccount account = operationBank.findAccount(searchAccount);
        if (account != null) {
            account.setMaxBalance(getSumOperation());
        } else {
            System.out.println("Счет не найден.");
        }
    }

    private void infoAcc(Bank operationBank) {
        System.out.println("Информация по счету:");
        String searchAccount = getAccountNumber();
        BankAccount account = operationBank.findAccount(searchAccount);
        if (account != null) {
            System.out.println(account);
        } else {
            System.out.println("Счет не найден.");
        }
    }

    private void withdrawAcc(Bank operationBank) {
        System.out.println("Списание со счета:");
        String searchAccount = getAccountNumber();
        double sumOperation = getSumOperation();
        try {
            operationBank.withdraw(searchAccount, sumOperation);
            System.out.println("Операция списания прошла успешно.");
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }

    private void topUpAcc(Bank operationBank) {
        System.out.println("Пополнение счета:");
        String searchAccount = getAccountNumber();
        double sumOperation = getSumOperation();
        try {
            operationBank.topUp(searchAccount, sumOperation);
            System.out.println("Операция пополнения прошла успешно.");
        } catch (MaxBalanceExceededException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createAcc(Bank operationBank) {
        System.out.println("Открытие счета:");
        String accountNumber = getAccountNumber();
        if (operationBank.createAccount(accountNumber)) {
            System.out.println("Счет открыт.");
        } else {
            System.out.println("Ошибка открытия счета, счет существует.");
        }

    }

    private String getAccountNumber() {
        System.out.print("Введите номер счета: ");
        String input = scanner.nextLine();
        while (!input.matches("[\\d]{5}")) {
            System.out.print("Номер счета состоит из 5 цифр, повторите ввод: ");
            input = scanner.nextLine();
        }
        return input;
    }

    private double getSumOperation() {
        System.out.print("Введите cумму операции: ");
        String input = scanner.nextLine();
        while (!input.matches("[\\d]{1,15}\\.*[\\d]{0,2}")) {
            System.out.print("Ошибка ввода, повторите ввод: ");
            input = scanner.nextLine();
        }
        return Double.parseDouble(input);
    }

}
