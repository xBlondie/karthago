/*************************************************************************************************
 * ----------       LOGIN-ACTIVITY - WRITTEN BY: JULIA KÖRVERS           ----------
 * 
 * Diese Klasse dient zur Implementierung des Session-Managements der App. Um die 
 * ständige Verfügbarkeit des eingeloggten Benutzers und der damit verbundenen 
 * userspezifischen Appanpassungen sicherzustellen, wird der Benutzer am Anfang der 
 * App (nach betätigen des LoginButtons [siehe LoginActivity) in eine temporäre 
 * Session gesichert und kann von jeder anderen Activity verwendet werden.
 * 
 * Klassen, mit die diese App kommuniziert:
 * 		- Keine
 * 
 * 
 ************************************************************************************************/


package de.bg.fhdw.bfwi413a.karthago;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

@SuppressLint("CommitPrefEdits")
public class SessionManagement {
	// DECLARE NECESSARY VARIABLES
	private SharedPreferences pref;
	private Editor editor;
	private Context _context;
	private int PRIVATE_MODE = 0;
	
	// SHAREDPREF FILE NAME
    private static final String PREF_NAME = "Karthago";
     
    // ALL SHARED PREFERENCES KEYS
    private static final String IS_LOGIN = "IsLoggedIn";
    // PUBLIC TO ACCESS FROM OUTSIDE
    public static final String KEY_NAME = "user";
    public static final String CARDFILE_ID = "cardfileID";
     
    // CONSTRUCTOR
    public SessionManagement(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    //METHOD TO CREATE LOGIN SESSION
	public void createLoginSession(String username){
        // STORING LOGIN VALUE AS TRUE
        editor.putBoolean(IS_LOGIN, true);
         
        // STORING NAME IN PREF
        editor.putString(KEY_NAME, username);
        // COMMIT CHANGES
        editor.commit();
    }
    
	//METHOD TO GET USER DETAILS
    public String getUserDetails(){
        String user = new String();
        // GET USERNAME
        user = pref.getString(KEY_NAME, null);
         
        // return user
        return user;
    }
    
    public void checkLogin(){
        // Check login status
        if(!this.isLoggedIn()){
            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context, de.bg.fhdw.bfwi413a.karthago.activities.login.Init.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
             
            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
             
            // Staring Login Activity
            _context.startActivity(i);
        }
    }
    
    //METHOD TO CHECK IF LOGGEDIN
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }
    
    //METHOD TO LOGOUT USER
    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();
         
        // After logout redirect user to Login Activity
        Intent i = new Intent(_context, de.bg.fhdw.bfwi413a.karthago.activities.login.Init.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
         
        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
         
        // Staring Login Activity
        _context.startActivity(i);
    }
    
    //METHOD TO LOGOUT USER WITHOUT REDIRECT (WHEN USER CHANGES IN CONFIG)
    public void changeUserWithRedirectToMenu(String choosedUser){
    	// Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();
        
        createLoginSession(choosedUser);
        
     // After logout redirect user to Menu Activity
        Intent i = new Intent(_context, de.bg.fhdw.bfwi413a.karthago.activities.menu.Init.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
         
        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
         
        // Staring Login Activity
        _context.startActivity(i);
    }
    
    //METHOD TO WRITE CARDFILE-ID FOR SELECTIONACTIVITY
    public void writeCardfileID(String cardfileID){
    	editor.putString(CARDFILE_ID, cardfileID);
    	editor.commit();
    }
    
    //METHOD TO GET CARDFILE-ID FOR SELECTIONACTIVITY
    public String getCardfileID(){
        String cardfile = new String();
        // GET CARDFILE
        cardfile = pref.getString(CARDFILE_ID, null);
         
        // return cardfile
        return cardfile;
    }
}
