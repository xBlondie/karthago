//Created by Patrick
package de.bg.fhdw.bfwi413a.karthago.ku.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandlerConfig extends SQLiteOpenHelper {
	
	//CONFIG
	public static final String DB_NAME = "db.SQLite";
	public static final String TB_NAME_CONFIG ="config";
	public static final int DB_VERSION = 1;
	public static final String ID = "ID";
	public static final String KEY = "KEY";
	public static final String VALUE = "VALUE";
	
	//XML
	public static final String TB_NAME_XML ="cards";
	private static final String QUESTION_ID = "QUESTION_ID";
	private static final String QUESTION_TEXT = "QUESTION_TEXT";
	private static final String ANSWER_TYPE = "ANSWER_TYPE";
	private static final String ANSWER_ONE = "ANSWER_ONE";
	private static final String ANSWER_TWO = "ANSWER_TWO";
	private static final String ANSWER_THREE = "ANSWER_THREE";
	private static final String ANSWER_FOUR = "ANSWER_FOUR";
	private static final String RIGHT_ANSWER = "RIGHT_ANSWER";
	private static final String COUNT_OF_RIGHT_ANSWER = "COUNT_OF_RIGHT_ANSWER";
	
	//USER
	public static final String TB_NAME_USER ="user";
	private static final String USER = "USER";
	
	public DatabaseHandlerConfig(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sqlStatement = "create table " + TB_NAME_CONFIG
				+ " (" 
				+ ID + " integer primary key autoincrement not null,"
				+ KEY + " text,"
				+ VALUE + " integer"
				+ ");";
		
		Log.d("Database", sqlStatement); 
		db.execSQL(sqlStatement);
		
		//Initialize on First-Start
		String sqlStatement1 = "INSERT INTO " + TB_NAME_CONFIG +" VALUES (0, 'Option1', 0);";
		db.execSQL(sqlStatement1);
		String sqlStatement2 = "INSERT INTO " + TB_NAME_CONFIG +" VALUES (1, 'Option2', 0);";
		db.execSQL(sqlStatement2);
		
		
		//XML
		String sqlStatement3 = "create table " + TB_NAME_XML
				+ " (" 
				+ ID + " integer primary key autoincrement not null,"
				//KARTEI FELD; DB.CLOSE HINZUFÜGEN; NUR EINEN DATABASEHANDLER
				+ QUESTION_ID + " integer,"
				+ QUESTION_TEXT + " text,"
				+ ANSWER_TYPE + " text,"
				+ ANSWER_ONE + " text,"
				+ ANSWER_TWO + " text,"
				+ ANSWER_THREE + " text,"
				+ ANSWER_FOUR + " text,"
				+ RIGHT_ANSWER + " integer,"
				+ COUNT_OF_RIGHT_ANSWER + " integer"
				+ ");";
		
		
		Log.d("Database", sqlStatement3); 
		db.execSQL(sqlStatement3);
		
		String sqlStatement4 = "create table " + TB_NAME_USER
				+ " (" 
				+ ID + " integer primary key autoincrement not null,"
				+ USER + " text"
				+ ");";
		 
		db.execSQL(sqlStatement4);
		
		String sqlStatement5 = "INSERT INTO " + TB_NAME_USER +" VALUES (0, 'ADMIN');";
		db.execSQL(sqlStatement5);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		

	}
	
	public void updateConfigOption1(SQLiteDatabase db, int value){
		ContentValues newValues = new ContentValues();
		newValues.put(VALUE, value);

		db.update(TB_NAME_CONFIG, newValues, "ID=0", null);
	}
	
	public void updateConfigOption2(SQLiteDatabase db, int value){
		ContentValues newValues = new ContentValues();
		newValues.put(VALUE, value);

		db.update(TB_NAME_CONFIG, newValues, "ID=1", null);
	}
	
	public int readConfigOption1(){
		SQLiteDatabase db = this.getReadableDatabase();
		int value = -1;
		String sqlStatement = "SELECT VALUE FROM " + TB_NAME_CONFIG + " WHERE ID = 0";
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
		String sqlStatement = "SELECT VALUE FROM " + TB_NAME_CONFIG + " WHERE ID = 1";
		//value = db.execSQL(sqlStatement);
		Cursor cursor = db.rawQuery(sqlStatement, null);
		
		if (null != cursor && cursor.moveToFirst()) {
		    value = Integer.parseInt(cursor.getString(0));
		}
		
		return value;
		
	}
	
	public List<String> readUserList(){
		List<String> labels = new ArrayList<String>();
		
		String sqlStatement = "SELECT * FROM " + TB_NAME_USER ;
		SQLiteDatabase db = this.getReadableDatabase();
		
		Cursor cursor = db.rawQuery(sqlStatement, null);
		
		 if (null != cursor && cursor.moveToFirst()) {
	            do {
	                labels.add(cursor.getString(1));
	            } while (cursor.moveToNext());
	        }
		
		 cursor.close();
	     db.close();
		
	     return labels;
		
	}
}
