package myeconomy.shungy.com.myeconomy;

import android.provider.BaseColumns;

/**
 * Created by hungsterx on 2017-01-02.
 */

public final class EconomyContract {
    private EconomyContract() {}

    public static class EconomyEntry implements BaseColumns {

        public static final String TABLE_NAME = "myeconomy";

        public static final String COLUMN_TYPE = "type";

        public static final String COLUMN_DESCRIPTION = "description";

        public static final String COLUMN_DATE = "date";

        public static final String COLUMN_DEBIT = "debit";

        public static final String COLUMN_CREDIT = "credit";

        public static final String COLUMN_CURRENT_BALANCE = "currentbalance";
    }
}
