package com.example.administrator.sqlitedatabasetest;

 import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.create_database)
    Button createDatabase;
private MyDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        dbHelper= new MyDatabaseHelper(this,"BookStore.db",null,1);

    }

    @OnClick(R.id.create_database)
    public void onClick(View v) {
       SQLiteDatabase db = dbHelper.getWritableDatabase();
              db.beginTransaction();
               try{
                   db.delete("Book",null,null);
                   if(true){
                       throw new NullPointerException();
                   }
                   ContentValues values =new ContentValues();
                   values.put("name","Game");
                   values.put("author","Eric");
                   values.put("pages","720");
                   values.put("price","20.16");
                   db.insert("Book",null,values);
                   db.setTransactionSuccessful();
               }catch(Exception e){
                   e.printStackTrace();
               }finally {
                   db.endTransaction();
               }
    }
}
