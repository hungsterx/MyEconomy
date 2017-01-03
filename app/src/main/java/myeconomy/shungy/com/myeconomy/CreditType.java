package myeconomy.shungy.com.myeconomy;

/**
 * Created by hungsterx on 2017-01-03.
 */

public enum CreditType {
    SALARY(1),
    GIFT(2),
    OTHER(3);

    private int mValue;

    CreditType(int val) {
        mValue = val;
    }

    public int getValue() { return mValue; }
}