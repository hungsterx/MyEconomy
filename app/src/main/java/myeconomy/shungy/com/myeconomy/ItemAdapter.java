package myeconomy.shungy.com.myeconomy;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hungsterx on 2017-01-01.
 */

public class ItemAdapter extends ArrayAdapter<Item> {

    private Context mContext;

    private static class ViewHolder {
        TextView name;
        TextView price;
        TextView date;
    }
    public ItemAdapter(Context context, ArrayList<Item> data) {
        super(context, R.layout.itemview, data);
        mContext = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View customView = view;
        Item item = getItem(position);
        ViewHolder holder;
        if(customView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            customView = inflater.inflate(R.layout.itemview, null);
            holder.name = (TextView) customView.findViewById(R.id.itemname);
            holder.price = (TextView) customView.findViewById(R.id.itemprice);
            holder.date = (TextView) customView.findViewById(R.id.itemdate);

            customView.setTag(holder);

        } else {
            holder = (ViewHolder) customView.getTag();
        }


        holder.name.setText(item.getName());
        holder.price.setText(Double.toString(item.getPrice()));
        holder.date.setText(item.getCreateDate().toString());

        return customView;
    }

}
