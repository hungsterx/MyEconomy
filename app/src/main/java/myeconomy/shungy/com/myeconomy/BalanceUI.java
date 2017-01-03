package myeconomy.shungy.com.myeconomy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BalanceUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance_ui);

        TextView saldoTextView = (TextView) findViewById(R.id.saldo);

        EconomyDBHelper dbHelper = new EconomyDBHelper(this);

        Item item = dbHelper.getLastItem();

        if(item == null) {
            item = new Item();
        }
        saldoTextView.setText(""+item.getCurrentBalance());
    }
}
