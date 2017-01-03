package myeconomy.shungy.com.myeconomy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class BalanceHistoryUi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance_history_ui);

        ListView balanceHistoryList = (ListView) findViewById(R.id.balancehistory);
        EconomyDBHelper economyHelper = new EconomyDBHelper(this);
        ArrayList<Item> historyItems;
        BalanceHistoryItemAdapter balanceHistoryAdapter;
        if(economyHelper.getLastItem() != null) {
            historyItems = economyHelper.getAllItemList();
            balanceHistoryAdapter = new BalanceHistoryItemAdapter(this, historyItems);
            balanceHistoryList.setAdapter(balanceHistoryAdapter);
        }

    }
}
