package myeconomy.shungy.com.myeconomy;

import java.util.ArrayList;

/**
 * Created by hungsterx on 2016-12-31.
 */

public class User {
    private final String mName;

    private Account mUserAccount;

    private ArrayList<Item> mItemlist;

    public User(String name) {
        mName = name;
        mUserAccount = new Account(0);
    }

    public void debit(Item item) {
        mUserAccount.debit(item.getPrice());
        mItemlist.add(item);
    }

    public void credit(double credit) {
        mUserAccount.credit(credit);
    }
    public double getBalance() {
        return mUserAccount.getBalance();
    }
}
