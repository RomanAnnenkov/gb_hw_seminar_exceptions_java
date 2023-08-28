package seminarTwoHW.taskFour.program;

import seminarTwoHW.taskFour.exceptions.InsufficientFundsException;
import seminarTwoHW.taskFour.exceptions.MaxBalanceExceededException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    private final String name;
    private final Map<String, BankAccount> accounts;

    public Map<String, BankAccount> getAccounts() {
        return accounts;
    }

    public Bank(String name) {
        this.name = name;
        this.accounts = new HashMap<>();
    }

    public synchronized boolean createAccount(String accountNumber) {
        if (findAccount(accountNumber) == null) {
            BankAccount newAccount = new BankAccount(accountNumber);
            accounts.put(accountNumber, newAccount);
            return true;
        }
        return false;
    }

    public void topUp(String accountNumber, double value) throws MaxBalanceExceededException {
        BankAccount accountForUpdate = findAccount(accountNumber);
        if (accountForUpdate != null) {
            accountForUpdate.topUp(value);
        }
    }

    public void withdraw(String accountNumber, double value) throws InsufficientFundsException {
        BankAccount accountForUpdate = findAccount(accountNumber);
        if (accountForUpdate != null) {
            accountForUpdate.withdraw(value);
        }
    }

    public BankAccount findAccount(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            return accounts.get(accountNumber);
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("Bank: %s, accounts: %d", this.name, this.accounts.size());
    }
}
