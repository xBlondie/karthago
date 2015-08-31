/**********************************************************************************
 * ----------       LOGIN-ACTIVITY - WRITTEN BY: JULIA KÖRVERS           ----------
 * 
 * Diese Activity bildet den Einstiegspunkt der App. Die Hauptfunktionalitäten 
 * dieser App liegen in der:
 *   - Bereitstellung des Login-Prozesses für den User
 *   - Registration neuer User
 * 
 * Klassen, mit die diese App kommuniziert sind:
 * 	 - Navigation (Aufruf der nächsten Activity)
 *   - SessionManagement (Erstellung einer Session für den User)
 *   - DatabaseHandler (Erstellung des Users, Initialisierung der Tabellen)
 * 
 * Nähere Informationen zu den Methoden siehe im Quellcode!
 * 
 *********************************************************************************/


package de.bg.fhdw.bfwi413a.karthago.activities.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import de.bg.fhdw.bfwi413a.karthago.db.DatabaseHandler;
import de.bg.fhdw.bfwi413a.karthago.onboarding.StartOnboarding;

public class Init extends Activity{
	
	//DECLARE MVC-CLASSES
	private Data mData;
	private Gui mGui;
	private ApplicationLogic mApplicationLogic;
	
	//DECLARE NECESSARY CLASSES
	private DatabaseHandler mdbHandler;
	private boolean first_app_start;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//INITIALIZE DATABASE HANDLER
		initDatabaseHandler();
		//LOOK IF IT IS APPS FIRST START
		first_app_start = false;
		first_app_start = mdbHandler.getAppStartFlag();
		if(first_app_start == true){
			//IF IT IS THE FIRST START OF APP
			Intent i = new Intent(Init.this, StartOnboarding.class);
			finish();
			startActivity(i);
		}
		
		//INITIALIZE MVC-CLASSES
		initData(savedInstanceState);
		initGui();
		initApplicationLogic();	
		initEventToListenerMapping();
	}
	

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}
	
	//INITIALIZE DATA
	private void initData(Bundle savedInstanceState) {
		mData = new Data(this, savedInstanceState);
	}
	
	//INITIALIZE GUI
	private void initGui() {
		mGui = new Gui(this);
		
	}

	//INITIALIZE APPLICATION LOGIC
	private void initApplicationLogic() {
		mApplicationLogic = new ApplicationLogic(mGui, mData, Init.this);
		
	}

	//INITIALIZE EVENT TO LISTENER MAPPING
	private void initEventToListenerMapping() {
		new EventToListenerMapping(mGui, mApplicationLogic);
		
	}
	
	//INITIALIZE DATABASE-HANDLER
	private void initDatabaseHandler(){
		 mdbHandler = new DatabaseHandler(getApplicationContext());
	}

}
