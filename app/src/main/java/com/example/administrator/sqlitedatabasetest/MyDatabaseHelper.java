package com.example.administrator.sqlitedatabasetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by qijiajun  on 2016/8/10.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_BOOK = "create table Book("
            + "id INTEGER PRIMARY KEY autoincrement,"
            + "author text,"
            + "price real,"
            + "pages integer,"
            + "name text,)";
//            + "category_id integer)";
    //    public static final String CREATE_CATEGORY ="create table Category("
//            +"id integer primary key autoincrement,"
//            +" category_name text,"
//            +"category_code integer)";
    private Context mContext;
//log.i
    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                            int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
//        db.execSQL(Create_CATEGORY);
        Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVerdion) {
//如果更新数据库数据可以通过upgrade
//        switch(oldVersion){
//            case 1:
//                db.execSQL(CREATE_CATEGORY);
//            case 2:
//                db.execSQL("alter table Book add column category_id integer");
//    }
}
}
