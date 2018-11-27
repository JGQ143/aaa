package jgq.com.zhong.MySqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Dao {

    private final SQLiteDatabase db;

    public Dao(Context context){
        Mysqlite mysqlite = new Mysqlite(context);

        db = mysqlite.getWritableDatabase();
    }

    public void insertdata(String murl, String s) {
        //先删除

        db.delete("zhong","url=?",new String[]{s});

        //添加

        ContentValues values = new ContentValues();

        values.put("url",murl);
        values.put("title",s);

        long insert = db.insert("zhong", null, values);

        Log.e("zzz","insert==="+insert);
    }

    public String querydata(String murl) {

        String title="";

        Cursor cursor = db.query("zhong", null, "url=?", new String[]{murl}, null, null, null);

        while (cursor.moveToNext()){
             title = cursor.getString(cursor.getColumnIndex("title"));
        }
        return title;
    }
}
