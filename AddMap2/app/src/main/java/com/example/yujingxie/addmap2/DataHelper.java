package com.example.yujingxie.addmap2;

/**
 * Created by yujingxie on 5/22/16.
 */
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;




public class DataHelper extends SQLiteOpenHelper {
    //database version, current ver is 1.
    public static final int DATABASE_VER=1;

    //database Name or db name
    public static final String DATABASE_NAME="waterReport";

    //table Name, table person
    public static final String TABLE_Report="report";

    //table fields name,fist name,email and domain
    public static final String KEY_NAME="name";
    public static final String KEY_Location="location";
    public static final String KEY_TIME="time";
    public static final String KEY_Duration="duration";
    public static final String KEY_LEAKAGE_TYPE="leakage_type";
    public static final String KEY_Description="description";
    public static final String KEY_Duration_Type="duration_type";

    public DataHelper(Context context, String name, CursorFactory factory,
                      int version) {
        super(context, name, factory, version);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        //creating string sqlTable for creating a table
        String sqlTable = "create table " +TABLE_Report+ "(" +KEY_NAME+ " text," +KEY_Location+ " text,"+KEY_TIME+ " text,"+KEY_Duration+" INTEGER,"+KEY_Duration_Type+" text,"+KEY_LEAKAGE_TYPE+" text,"+KEY_Description+" text);";
        //db.execSQL() will execute string which we provide and will create a table with given table name and fields.
        db.execSQL(sqlTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }


}
