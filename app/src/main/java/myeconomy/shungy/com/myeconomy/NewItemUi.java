package myeconomy.shungy.com.myeconomy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewItemUi extends AppCompatActivity {

    UIHolder holder;
    EconomyDBHelper economyDBHelper;

    private static class UIHolder {
        public EditText price;
        public EditText name;
        public Spinner typeSpinner;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<String> debittypes = new ArrayList<String>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item_ui);
        holder = new UIHolder();
        holder.name = (EditText) findViewById(R.id.item_name);
        holder.price = (EditText) findViewById(R.id.editPrice);
        holder.typeSpinner = (Spinner) findViewById(R.id.item_spinner);

        for(DebitType debit:DebitType.values()) {
            debittypes.add(debit.name());
        }

        ArrayAdapter<String> debitTypeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, debittypes);
        debitTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.typeSpinner.setAdapter(debitTypeAdapter);
    }

    public void debit(View view) {
        Item item;
        String name;
        double debit;
        int type;
        switch (view.getId()) {
            case R.id.debit_confirm:
                if(holder.price.getText().toString() != null) {
                    debit = Double.parseDouble(holder.price.getText().toString());
                } else {
                    break;
                }

                if(holder.name.getText().toString() != null) {
                    name = holder.name.getText().toString();
                } else {
                    break;
                }

                type = DebitType.valueOf((String)holder.typeSpinner.getSelectedItem()).getValue();

                economyDBHelper = new EconomyDBHelper(this);

                Item lastItem = economyDBHelper.getLastItem();

                if(lastItem != null) {
                    double current_balance = lastItem.getCurrentBalance()-debit;
                    item = new Item(name, type, debit, 0, current_balance, new Date());
                    economyDBHelper.insertItem(item);
                }

                break;
        }
    }
}
