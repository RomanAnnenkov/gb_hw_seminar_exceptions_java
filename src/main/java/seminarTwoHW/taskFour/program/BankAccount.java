package seminarTwoHW.taskFour.program;

import seminarTwoHW.taskFour.exceptions.InsufficientFundsException;
import seminarTwoHW.taskFour.exceptions.MaxBalanceExceededException;

import java.util.Objects;

public class BankAccount {
    private final String accountNumber;
    private double balance;
    private double maxBalance;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setMaxBalance(double maxBalance) {
        this.maxBalance = maxBalance;
    }

    public BankAccount(String accountNumber, double maxBalance) {
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.maxBalance = maxBalance;
    }
    public BankAccount(String accountNumber) {
        this(accountNumber, 0);

    }

    public synchronized void topUp(Double value) throws MaxBalanceExceededException {
        if ((this.maxBalance != 0) && (this.balance >= this.maxBalance)) {
            throw new MaxBalanceExceededException("Account " + this.accountNumber + " max balance exceeded");
        }
        this.balance += value;
    }

    public synchronized void withdraw(Double value) throws InsufficientFundsException {
        if (this.balance < value) {
            throw new InsufficientFundsException("Account " + this.accountNumber + " insufficient funds");
        }
        this.balance -= value;
    }

    @Override
    public String toString() {
        return String.format("AccountNumber: %s, balance: %f, max: %f", accountNumber, balance, maxBalance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return accountNumber.equals(that.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }
}
