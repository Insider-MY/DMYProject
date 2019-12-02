package com.lyd.newsstory.login;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private final static int DATABASE_VERSION =1;  //版本
    private final static String DATABASE_NAME = "User.db";  //数据库名字

    public DBHelper( Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建数据库表
        String userInfo_table = "create table usertable"+
                "(id integer primary key autoincrement,username text,"+"password text)";
        db.execSQL(userInfo_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //当数据库需要升级的时候,Android系统会主动调用这个这个方法
        db.execSQL("alter table usertable add column other string");
    }

    //查询数据
    public Cursor select(){
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor cursor =db.rawQuery("select distinct * from usertable",null);
        return cursor;
    }
}
