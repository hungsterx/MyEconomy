package myeconomy.shungy.com.myeconomy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by hungsterx on 2017-01-02.
 */

public class EconomyDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "myeconomy.db";

    private static final int DATABASE_VERSION = 1;

    private final Context mContext;

    public EconomyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }
    public static final String SQL_CREATE_TABLE = "CREATE TABLE " + EconomyContract.EconomyEntry.TABLE_NAME + " ("
            + EconomyContract.EconomyEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + EconomyContract.EconomyEntry.COLUMN_TYPE + " INTEGER,"
            + EconomyContract.EconomyEntry.COLUMN_DESCRIPTION + " TEXT,"
            + EconomyContract.EconomyEntry.COLUMN_DATE + " TEXT,"
            + EconomyContract.EconomyEntry.COLUMN_DEBIT + " DECIMAL(18,2),"
            + EconomyContract.EconomyEntry.COLUMN_CREDIT + " DECIMAL(18,2),"
            + EconomyContract.EconomyEntry.COLUMN_CURRENT_BALANCE + " DECIMAL(18,2)"
            + ")";

    public static final String SQL_DELETE_TABLE =
            "DROP TABLE IF EXISTS " + EconomyContract.EconomyEntry.TABLE_NAME;

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void insertItem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(EconomyContract.EconomyEntry.COLUMN_TYPE, item.getType());
        values.put(EconomyContract.EconomyEntry.COLUMN_DESCRIPTION, item.getName());
        values.put(EconomyContract.EconomyEntry.COLUMN_DATE, Item.DATEFORMAT.format(item.getCreateDate()));
        values.put(EconomyContract.EconomyEntry.COLUMN_DEBIT, item.getPrice());
        values.put(EconomyContract.EconomyEntry.COLUMN_CREDIT, item.getCredit());
        values.put(EconomyContract.EconomyEntry.COLUMN_CURRENT_BALANCE, item.getCurrentBalance());
        long rowInserted = db.insert(EconomyContract.EconomyEntry.TABLE_NAME, null, values);

        if(rowInserted != -1)
            Toast.makeText(mContext, "New row added, row id: " + rowInserted, Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(mContext, "Something wrong", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<Item> getAllItemList() {

        ArrayList<Item> itemlist = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from " + EconomyContract.EconomyEntry.TABLE_NAME, null );
        res.moveToFirst();
        while(res.isAfterLast() == false) {
            int type = res.getInt(res.getColumnIndex(EconomyContract.EconomyEntry.COLUMN_TYPE));
            String name = res.getString(res.getColumnIndex(EconomyContract.EconomyEntry.COLUMN_DESCRIPTION));
            String date = res.getString(res.getColumnIndex(EconomyContract.EconomyEntry.COLUMN_DATE));
            double debit = res.getDouble(res.getColumnIndex(EconomyContract.EconomyEntry.COLUMN_DEBIT));
            double credit = res.getDouble(res.getColumnIndex(EconomyContract.EconomyEntry.COLUMN_CREDIT));
            double currentbalance = res.getDouble(res.getColumnIndex(EconomyContract.EconomyEntry.COLUMN_CURRENT_BALANCE));

            Date d;
            Item item = null;

            try {
                d = Item.DATEFORMAT.parse(date);
                item = new Item(name, type, debit, credit, currentbalance, d);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if(item != null) {
                itemlist.add(item);
            }

            res.moveToNext();

        }

        return itemlist;
    }

    public Item getLastItem() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from " + EconomyContract.EconomyEntry.TABLE_NAME, null );
        res.moveToLast();
        Date d;
        Item item = null;
        if(res.getCount() > 0) {
            int type = res.getInt(res.getColumnIndex(EconomyContract.EconomyEntry.COLUMN_TYPE));
            String name = res.getString(res.getColumnIndex(EconomyContract.EconomyEntry.COLUMN_DESCRIPTION));
            String date = res.getString(res.getColumnIndex(EconomyContract.EconomyEntry.COLUMN_DATE));
            double debit = res.getDouble(res.getColumnIndex(EconomyContract.EconomyEntry.COLUMN_DEBIT));
            double credit = res.getDouble(res.getColumnIndex(EconomyContract.EconomyEntry.COLUMN_CREDIT));
            double currentbalance = res.getDouble(res.getColumnIndex(EconomyContract.EconomyEntry.COLUMN_CURRENT_BALANCE));

            try {
                d = Item.DATEFORMAT.parse(date);
                item = new Item(name, type, debit, credit, currentbalance, d);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return item;
    }
}
