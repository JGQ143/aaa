package jgq.com.zhong.MySqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Mysqlite extends SQLiteOpenHelper {
    public Mysqlite(Context context) {
        super(context, "zhong.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table zhong(id integer primary key autoincrement,url text,title text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
