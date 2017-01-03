package myeconomy.shungy.com.myeconomy;

/**
 * Created by hungsterx on 2016-12-31.
 */

public class Account {

    private double mBalance;

    public Account(double balance) {
        this.mBalance = balance;
    }

    public void debit(double amount) {
        mBalance = mBalance - amount;
    }

    public double getBalance() {
        return mBalance;
    }

    public void credit(double deposit) { mBalance = mBalance + deposit; }
}
