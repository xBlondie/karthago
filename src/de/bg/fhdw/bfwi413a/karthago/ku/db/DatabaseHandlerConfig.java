//Created by Patrick
package de.bg.fhdw.bfwi413a.karthago.ku.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandlerConfig extends SQLiteOpenHelper {

	public static final String DB_NAME = "db.SQLite";
	public static final String TB_NAME ="config";
	public static final int DB_VERSION = 1;
	public static final String ID = "ID";
	public static final String KEY = "KEY";
	public static final String VALUE = "VALUE";
	
	public DatabaseHandlerConfig(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sqlStatement = "create table " + TB_NAME
				+ " (" 
				+ ID + " integer primary key autoincrement not null,"
				+ KEY + " text,"
				+ VALUE + " integer"
				+ ");";
		
		Log.d("Database", sqlStatement); 
		db.execSQL(sqlStatement);
		
		//Initialize on First-Start
		String sqlStatement1 = "INSERT INTO " + TB_NAME +" VALUES (0, 'Option1', 0);";
		db.execSQL(sqlStatement1);
		String sqlStatement2 = "INSERT INTO " + TB_NAME +" VALUES (1, 'Option2', 0);";
		db.execSQL(sqlStatement2);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		

	}
	
	public void updateConfigOption1(SQLiteDatabase db, int value){
		ContentValues newValues = new ContentValues();
		newValues.put(VALUE, value);

		db.update(TB_NAME, newValues, "ID=0", null);
	}
	
	public void updateConfigOption2(SQLiteDatabase db, int value){
		ContentValues newValues = new ContentValues();
		newValues.put(VALUE, value);

		db.update(TB_NAME, newValues, "ID=1", null);
	}
	
	public int readConfigOption1(){
		SQLiteDatabase db = this.getReadableDatabase();
		int value = -1;
		String sqlStatement = "SELECT VALUE FROM " + TB_NAME + " WHERE ID = 0";
		//value = db.execSQL(sqlStatement);
		Cursor cursor = db.rawQuery(sqlStatement, null);
		
		if (null != cursor && cursor.moveToFirst()) {
		    value = Integer.parseInt(cursor.getString(0));
		}
		
		return value;
		
	}
	
	public int readConfigOption2(){
		SQLiteDatabase db = this.getReadableDatabase();
		int value = -1;
		String sqlStatement = "SELECT VALUE FROM " + TB_NAME + " WHERE ID = 1";
		//value = db.execSQL(sqlStatement);
		Cursor cursor = db.rawQuery(sqlStatement, null);
		
		if (null != cursor && cursor.moveToFirst()) {
		    value = Integer.parseInt(cursor.getString(0));
		}
		
		return value;
		
	}
}
