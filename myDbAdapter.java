package lav.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import static lav.c.myDbHelper.NAME;
import static lav.c.myDbHelper.TABLE_NAME;

/**
 * Created by Ashwin on 3/2/2018.
 */

public class myDbAdapter {

    myDbHelper myhelper;
    String status;
    String noval = "no value";

    public myDbAdapter(Context context) {
        myhelper = new myDbHelper(context);
    }

    public long insertData(String name) {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME, name);
        long id = dbb.insert(TABLE_NAME, null, contentValues);
        return id;
    }

    public String getData() {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.NAME};
        Cursor cursor = db.query(TABLE_NAME, columns, null, null, null, null, null);
        StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext()) {
           // int cid = cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            String name = cursor.getString(cursor.getColumnIndex(myDbHelper.NAME));

            buffer.append( name + " \n");
        }
        return buffer.toString();
    }

    public void deleteAll() {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        db.delete(TABLE_NAME, null, null);
        db.execSQL("delete from " + TABLE_NAME);
        //db.execSQL("TRUNCATE table" + myDbHelper.TABLE_NAME);
        db.close();
    }

    public int updateName(String oldName, String newName) {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME, newName);
        String[] whereArgs = {oldName};
        int count = db.update(TABLE_NAME, contentValues, myDbHelper.NAME + " = ?", whereArgs);
        return count;
    }

    public String compare(String name) {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] column = {myhelper.NAME};
        String whereArgs[] = {name};
        Cursor cursor = db.query(myhelper.TABLE_NAME, column, myhelper.NAME + "=?", whereArgs, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                Log.e("N",noval);
                String n = cursor.getString(cursor.getColumnIndex(myhelper.NAME));

                if (n.equals(name)) {
                    status = n;
                }else {
                    status = noval;


                }
            }
        }
        return status;
    }

    public boolean comp(String name){
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] column = {myhelper.NAME};
        String whereArgs[] = {name};
        Cursor cursor = db.query(myhelper.TABLE_NAME, column, myhelper.NAME + "=?", whereArgs, null, null, null);
        if (cursor.moveToFirst()) {
            return false;
        }
        return true;
    }


}

class myDbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "myDatabase";
    public static final String TABLE_NAME = "myTable";
    private static final int DATABASE_Version = 1;
    public static final String UID="_id";
    public static final String NAME = "Name";
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
            " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255));";
    private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
    public Context context;

    public myDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_Version);
        this.context=context;
    }

    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL(CREATE_TABLE);
        } catch (Exception e) {
           // Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
          //  Toast.makeText(context, "upgraded", Toast.LENGTH_SHORT).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }catch (Exception e) {
           // Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}

