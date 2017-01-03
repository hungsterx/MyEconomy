package myeconomy.shungy.com.myeconomy;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hungsterx on 2016-12-31.
 */

public class Item {

    private final String mName;

    private final double mPrice;

    private final double mCredit;

    private final double mCurrentBalance;

    private final Date mCreateDate;

    private final int mType;

    public static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");

    public Item() {
        mName = "nothing";
        mPrice = 0;
        mCredit = 0;
        mCurrentBalance = 0;
        mCreateDate = new Date();
        mType = CreditType.OTHER.getValue();
    }

    public Item(String name, int type, double price, double credit, double balance, Date createDate) {
        mName = name;
        mPrice = price;
        mCredit = credit;
        mCurrentBalance = balance;
        mCreateDate = createDate;
        mType = type;
    }

    public String getName() {
        return mName;
    }

    public double getPrice() {
        return mPrice;
    }

    public double getCredit() {
        return mCredit;
    }

    public double getCurrentBalance() { return mCurrentBalance; }

    public Date getCreateDate() {
        return mCreateDate;
    }

    public int getType() { return mType; }
}
