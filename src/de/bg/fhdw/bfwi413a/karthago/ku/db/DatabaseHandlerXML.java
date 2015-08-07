//Created by Patrick
package de.bg.fhdw.bfwi413a.karthago.ku.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandlerXML extends SQLiteOpenHelper {

	public static final String DB_NAME = "db.SQLite";
	public static final String TB_NAME ="cards";
	public static final int DB_VERSION = 1;
	private static final String QUESTION_ID = "QUESTION_ID";
	private static final String ID = "ID";
	private static final String QUESTION_TEXT = "QUESTION_TEXT";
	private static final String ANSWER_TYPE = "ANSWER_TYPE";
	private static final String ANSWER_ONE = "ANSWER_ONE";
	private static final String ANSWER_TWO = "ANSWER_TWO";
	private static final String ANSWER_THREE = "ANSWER_THREE";
	private static final String ANSWER_FOUR = "ANSWER_THREE";
	private static final String RIGHT_ANSWER = "RIGHT_ANSWER";
	private static final String COUNT_OF_RIGHT_ANSWER = "COUNT_OF_RIGHT_ANSWER";
	
	public DatabaseHandlerXML(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sqlStatement = "create table " + TB_NAME
				+ " (" 
				+ ID + " integer primary key autoincrement not null,"
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

		
		Log.d("Database", sqlStatement); 
		db.execSQL(sqlStatement);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		

	}
	
	
}
