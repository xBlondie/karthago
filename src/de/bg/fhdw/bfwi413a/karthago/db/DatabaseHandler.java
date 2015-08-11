/************************************************************************************************
 * @author Patrick				
 * 										
 * Diese Klasse dient zur Kommunikation zwischen den einzelnen Activities dieser App.
 * Dazu bietet diese Klasse alle Funktionen, die zur Verwaltung der Datenbank notwendig sind,
 * an. Somit kann die komplette Handler-Klasse privat gehalten werden. Auch die Instanzen
 * der Datenbank werden in der jeweiligen Methode instanziiert, sodass unnötige Parameter-
 * übergaben vermieden werden.
 * 
 * DEKLARIERUNG IN ANDEREN KLASSEN WIE FOLGT:
 * 
 * DatabaseHandler dbHandler = new DatabaseHandler(this); ODER "[NAME DER ACTIVITY].this"
 * 
 * Diese Klasse baut sich wie folgt auf:
 * - Variablendeklarationen
 * - onCreate der Datenbank
 * - onUpgrade der Datenbank
 * - Methoden für die einzelnen Activities
 * 
 * Nähere Informationen zu den Methoden finden Sie an der passenden Stelle!
 * 
 ***********************************************************************************************/
package de.bg.fhdw.bfwi413a.karthago.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
	
	//DECLARE GENERAL-PARAMETERS
	public static final String DB_NAME = "db.SQLite";
	public static final int DB_VERSION = 1;
	
	//DECLARE COLUMNS-CONFIG
	public static final String TB_NAME_CONFIG ="config";
	public static final String ID = "ID";
	public static final String KEY = "KEY";
	public static final String VALUE = "VALUE";
	
	//DECLARE COLUMNS-XML
	public static final String TB_NAME_XML ="cards";
	private static final String CARD_DECK = "CARD_DECK";
	private static final String QUESTION_ID = "QUESTION_ID";
	private static final String ANSWER_TYPE = "ANSWER_TYPE";
	private static final String RIGHT_ANSWER = "RIGHT_ANSWER";
	private static final String TIMESTAMP = "TIMESTAMP";
	private static final String COUNT_OF_RIGHT_ANSWER = "COUNT_OF_RIGHT_ANSWER";
	
	//DECLARE COLUMNS-USER
	public static final String TB_NAME_USER ="user";
	private static final String USER = "USER";
	
	//DECLARE COLUMNS-TIMESTAMP
	public static final String TB_NAME_TIMESTAMP = "timestamp";
	private static final String LEVEL = "LEVEL";
	private static final String INCREASED_TIME_FOR_LEVEL = "INCREASED_TIME_FOR_LEVEL_IN_SECONDS";
	
	
	//CONSTRUCTOR TO INITIALIZE THE DATABASE IF NOT EXISTS
	public DatabaseHandler(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//CREATE CONFIG-TABLE
		String CREATE_CONFIG_TABLE = "CREATE TABLE IF NOT EXISTS " + TB_NAME_CONFIG
				+ " (" 
				+ ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
				+ KEY + " TEXT,"
				+ VALUE + " INTEGER"
				+ ");";
		
		//CREATE XML-TABLE
		String CREATE_XML_TABLE = "CREATE TABLE IF NOT EXISTS " + TB_NAME_XML
				+ " (" 
				+ ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
				+ CARD_DECK + " INTEGER,"
				+ TIMESTAMP + " TEXT,"
				+ QUESTION_ID + " INTEGER,"
				+ ANSWER_TYPE + " TEXT,"
				+ RIGHT_ANSWER + " INTEGR,"
				+ COUNT_OF_RIGHT_ANSWER + " INTEGER"
				+ ");";
		
		//CREATE USER-TABLE
		String CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS " + TB_NAME_USER
				+ " (" 
				+ ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
				+ USER + " TEXT"
				+ ");";
		
		//CREATE TIMESTAMP-TABLE
		String CREATE_TIMESTAMP_TABLE = "CREATE TABLE IF NOT EXISTS " + TB_NAME_TIMESTAMP
				+ " (" 
				+ ID + " INTEGER PRIMARY KEY AUTIONCREMENT NOT NULL,"
				+ LEVEL + " INTEGER,"
				+ INCREASED_TIME_FOR_LEVEL + " INTEGER"
				+ ");";
		
		
		//EXECUTE THE SQL-STATEMENTS
		db.execSQL(CREATE_CONFIG_TABLE);
		db.execSQL(CREATE_XML_TABLE);
		db.execSQL(CREATE_USER_TABLE);
		db.execSQL(CREATE_TIMESTAMP_TABLE);
		
		//INITIALIZE TABLES FOR USING FIRST TIME
		initializeTablesForFirstStart(db);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//DROP ALL OLD TABLES IF EXISTED
        db.execSQL("DROP TABLE IF EXISTS " + TB_NAME_CONFIG);
        db.execSQL("DROP TABLE IF EXISTS " + TB_NAME_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TB_NAME_XML);
        db.execSQL("DROP TABLE IF EXISTS " + TB_NAME_TIMESTAMP);
  
        //RESTART THE CREATE PROCESS
        onCreate(db);

	}
	
	public void initializeTablesForFirstStart(SQLiteDatabase db){
		//INITIALIZING THE DATABASES (USER AND CONFIG) FOR FIRST START
		String initializeSorttyp = "INSERT INTO " + TB_NAME_CONFIG +" VALUES (0, 'Option1', 0);";
		String initializeLearnmode = "INSERT INTO " + TB_NAME_CONFIG +" VALUES (1, 'Option2', 0);";
		
		//ADMIN USER HAS TO EXIST EVERYTIME, SO HE IS NOT DELETEABLE (NO INFLUENCE ON SYSTEM)
		String SET_FIRST_USER = "INSERT INTO " + TB_NAME_USER +" VALUES (0, 'ADMIN');";
		
		//SET THE LEVELS AND TIMES FOR TIMESTAMPS
		String LEVEL_1 = "INSERT INTO " + TB_NAME_TIMESTAMP +" VALUES (0,1,60)";
		String LEVEL_2 = "INSERT INTO " + TB_NAME_TIMESTAMP +" VALUES (1,2,300)";
		String LEVEL_3 = "INSERT INTO " + TB_NAME_TIMESTAMP +" VALUES (2,3,3600)";
		String LEVEL_4 = "INSERT INTO " + TB_NAME_TIMESTAMP +" VALUES (3,4,43200)";
		String LEVEL_5 = "INSERT INTO " + TB_NAME_TIMESTAMP +" VALUES (4,5,86400)";
		String LEVEL_6 = "INSERT INTO " + TB_NAME_TIMESTAMP +" VALUES (5,6,172800)";
		String LEVEL_7 = "INSERT INTO " + TB_NAME_TIMESTAMP +" VALUES (6,7,604800)";
		
		//EXCECUTE SQL-STATEMENTS
		db.execSQL(initializeSorttyp);
		db.execSQL(initializeLearnmode);
		db.execSQL(SET_FIRST_USER);
		db.execSQL(LEVEL_1);
		db.execSQL(LEVEL_2);
		db.execSQL(LEVEL_3);
		db.execSQL(LEVEL_4);
		db.execSQL(LEVEL_5);
		db.execSQL(LEVEL_6);
		db.execSQL(LEVEL_7);
	}
	
	public void updateConfigOption1(int value){
		//CREATE DATABASE-INSTANCE
		SQLiteDatabase db = this.getWritableDatabase();
		
		//PUT CONFIG-OPTION1
		ContentValues newValues = new ContentValues();
		newValues.put(VALUE, value);
		
		//UPDATE-DATA IN SQLITE
		db.update(TB_NAME_CONFIG, newValues, "ID=0", null);
		db.close();
	}
	
	public void updateConfigOption2(int value){
		//CREATE DATABASE-INSTANCE
		SQLiteDatabase db = this.getWritableDatabase();
		
		//PUT CONFIG-OPTION2
		ContentValues newValues = new ContentValues();
		newValues.put(VALUE, value);
		
		//UPDATE-DATA IN SQLITE
		db.update(TB_NAME_CONFIG, newValues, "ID=1", null);
		db.close();
	}
	
	public int readConfigOption1(){
		//CREATE DATABASE-INSTANCE
		SQLiteDatabase db = this.getReadableDatabase();
		
		//IF OPERATION FAILS, EXIT PER ERROR
		int value = -1;
		
		//GET DATA OF ROW
		String sqlStatement = "SELECT VALUE FROM " + TB_NAME_CONFIG + " WHERE ID = 0";
		Cursor cursor = db.rawQuery(sqlStatement, null);
		
		//GET DATA AND WRITE INTO VALUE
		if (null != cursor && cursor.moveToFirst()) {
		    value = Integer.parseInt(cursor.getString(0));
		}
		
		db.close();
		return value;
		
	}
	
	public int readConfigOption2(){
		//CREATE DATABASE_INSTANCE
		SQLiteDatabase db = this.getReadableDatabase();
		
		//IF OPERATION FAILS, EXIT PER ERROR
		int value = -1;
		
		//GET DATA OF ROW
		String sqlStatement = "SELECT VALUE FROM " + TB_NAME_CONFIG + " WHERE ID = 1";
		Cursor cursor = db.rawQuery(sqlStatement, null);
		
		//GET DATA AND WRITE IT INTO VALUE
		if (null != cursor && cursor.moveToFirst()) {
		    value = Integer.parseInt(cursor.getString(0));
		}
		
		db.close();
		return value;
		
	}
	
	public List<String> getUserList(){
		//ARRAY TO STORE USERS
        List<String> users = new ArrayList<String>();
         
        //SELECT ALL FROM USERS
        String selectQuery = "SELECT  * FROM " + TB_NAME_USER;
      
        //CREATE DATABASE-INSTANCE AND FETCH DATA
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
      
        //LOOPING THROUGH ALLS ROWS AND ADD TO LIST
        if (cursor.moveToFirst()) {
            do {
                users.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
         
        cursor.close();
        db.close();
         
        return users;
    }
	
	 public void insertUser(String user){
		//CREATE DATABASE-INSTANCE
        SQLiteDatabase db = this.getWritableDatabase();
        
        //PREPARE SQL
        ContentValues values = new ContentValues();
        values.put(USER, user);
          
        //INSERT ROW
        db.insert(TB_NAME_USER, null, values);
        db.close();
	 }
	 
	 public void deleateUser (String user){
		 //CREATE DATABASE-INSTANCE
		 SQLiteDatabase db = this.getWritableDatabase();
		 
		 //PREPARE SQL
		 db.delete(TB_NAME_USER, USER + " = '" + user +"'", null);
		 db.close();
	 }
	 
}
