package myeconomy.shungy.com.myeconomy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainUserUi extends AppCompatActivity {

    private static class UiObjectsHolder{
        Button buttonDebit;
        Button buttonCredit;
        Button buttonShowBalance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_user_ui);
    }

    public void openActivity(View v) {
        Intent intent = null;

        switch (v.getId()) {
            case R.id.credit_button:
                intent = new Intent(this, CreditUi.class);
                break;
            case R.id.debit_button:
                intent = new Intent(this, NewItemUi.class);
                break;
            case R.id.showBalance_button:
                intent = new Intent(this, BalanceUI.class);
                break;
            case R.id.history_button:
                intent = new Intent(this, BalanceHistoryUi.class);
        }
        if(intent != null) {
            startActivity(intent);
        } else {
            Log.v("Hung", "null intent");
        }
    }
}
