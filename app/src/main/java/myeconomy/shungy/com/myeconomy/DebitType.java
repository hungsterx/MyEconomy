package myeconomy.shungy.com.myeconomy;

/**
 * Created by hungsterx on 2017-01-02.
 */

public enum DebitType {
    FOOD(1),
    GIFT(2),
    LIVING(3),
    OTHER(4),
    FUN(5);

    private int mValue;

    DebitType(int val) {
        mValue = val;
    }

    public int getValue() { return mValue; }
}
