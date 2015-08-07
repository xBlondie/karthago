//Created by Patrick
package de.bg.fhdw.bfwi413a.karthago.ku.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandlerUser extends SQLiteOpenHelper {

	public static final String DB_NAME = "db.SQLite";
	public static final String TB_NAME ="user";
	public static final int DB_VERSION = 1;
	private static final String ID = "_ID";
	private static final String USER = "USER";
	
	
	public DatabaseHandlerUser(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sqlStatement = "create table " + TB_NAME
				+ " (" 
				+ ID + " integer primary key autoincrement not null,"
				+ USER + " text"
				+ ");";
		
		Log.d("Database", sqlStatement); 
		db.execSQL(sqlStatement);
		
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		

	}
	
	
}
