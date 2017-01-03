package myeconomy.shungy.com.myeconomy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hungsterx on 2017-01-03.
 */

public class BalanceHistoryItemAdapter extends ArrayAdapter<Item> {
    private final Context mContext;

    private static class ViewHolder {
        TextView name;
        TextView debit;
        TextView credit;
        TextView currentBalance;
    }

    public BalanceHistoryItemAdapter(Context context, ArrayList<Item> data) {
        super(context, R.layout.currentbalance, data);
        mContext = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View customView = view;
        Item item = getItem(position);
        BalanceHistoryItemAdapter.ViewHolder holder;
        if(customView == null) {
            holder = new BalanceHistoryItemAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            customView = inflater.inflate(R.layout.currentbalance, null);
            holder.name = (TextView) customView.findViewById(R.id.current_balance_name);
            holder.debit = (TextView) customView.findViewById(R.id.current_balance_debit);
            holder.credit = (TextView) customView.findViewById(R.id.current_balance_credit);
            holder.currentBalance = (TextView) customView.findViewById(R.id.current_balance_balance);

            customView.setTag(holder);

        } else {
            holder = (BalanceHistoryItemAdapter.ViewHolder) customView.getTag();
        }


        holder.name.setText(item.getName());
        holder.debit.setText(Double.toString(item.getPrice()));
        holder.credit.setText(Double.toString(item.getCredit()));
        holder.currentBalance.setText(Double.toString(item.getCurrentBalance()));

        return customView;
    }

}
