package myeconomy.shungy.com.myeconomy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Date;

public class CreditUi extends AppCompatActivity {

    UiHolder holder;
    EconomyDBHelper economyDBHelper;

    private static class UiHolder{
        public EditText credit;
        public Spinner creditTypeSpinner;
        public EditText name;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_ui);

        holder = new UiHolder();

        holder.credit = (EditText) findViewById(R.id.credit_editcredit);
        holder.creditTypeSpinner = (Spinner) findViewById(R.id.credit_spinner);
        holder.name = (EditText) findViewById(R.id.editCreditName);

        ArrayList<String> creditTYpeList = new ArrayList<>();

        for(CreditType credittype : CreditType.values()) {
            creditTYpeList.add(credittype.name());
        }

        ArrayAdapter<String> creditdataadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, creditTYpeList);
        creditdataadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        holder.creditTypeSpinner.setAdapter(creditdataadapter);
    }

    public void credit(View view) {
        Item item = null;
        String name;
        double credit;
        int type;
        switch (view.getId()) {
            case R.id.credit_creditbutton:
                type = CreditType.valueOf((String)holder.creditTypeSpinner.getSelectedItem()).getValue();
                economyDBHelper = new EconomyDBHelper(this);

                double current_balance;

                if(holder.credit.getText().toString() != null) {
                    credit = Double.parseDouble(holder.credit.getText().toString());
                    if(holder.name.getText().toString() != null) {

                        Item lastItem = economyDBHelper.getLastItem();

                        if(lastItem != null) {
                            current_balance = lastItem.getCurrentBalance();
                        } else {
                            current_balance = 0;
                        }
                        name = holder.name.getText().toString();
                        item = new Item(name, type, 0, credit, current_balance + credit, new Date());

                    } else {
                        break;
                    }
                } else {
                    break;
                }

                if(item != null) {
                    economyDBHelper.insertItem(item);
                }
                break;
        }
    }
}


