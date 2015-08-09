/*************************************************************************************************
 * @author Patrick
 * 
 * Diese Klasse dient zur Implementierung des Session-Managements der App. Um die ständige 
 * Verfügbarkeit des eingeloggten Benutzers und der damit verbundenen userspezifischen
 * Appanpassungen sicherzustellen, wird der Benutzer am Anfang der App (nach betätigen des Login-
 * Buttons) in eine temporäre Session gesichert und kann von jeder anderen Activity verwendet
 * werden.
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
	private SharedPreferences pref;
	private Editor editor;
	private Context _context;
	private int PRIVATE_MODE = 0;
	
	// Sharedpref file name
    private static final String PREF_NAME = "Karthago";
     
    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";
     
    // User name (make variable public to access from outside)
    public static final String KEY_NAME = "user";
     
    // Constructor
    public SessionManagement(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
    
    public void createLoginSession(String username){
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);
         
        // Storing name in pref
        editor.putString(KEY_NAME, username);
        // commit changes
        editor.commit();
    }
    
    public String getUserDetails(){
        String user = new String();
        // user name
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
    
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }
    
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
}
