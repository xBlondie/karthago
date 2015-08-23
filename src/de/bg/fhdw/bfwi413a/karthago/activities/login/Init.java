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

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import de.bg.fhdw.bfwi413a.karthago.Navigation;
import de.bg.fhdw.bfwi413a.karthago.R;
import de.bg.fhdw.bfwi413a.karthago.SessionManagement;
import de.bg.fhdw.bfwi413a.karthago.db.DatabaseHandler;
import de.bg.fhdw.bfwi413a.karthago.onboarding.StartOnboarding;

public class Init extends Activity implements
OnItemSelectedListener {
	
	//DECLARE MVC-CLASSES
	private Data mData;
	private Gui mGui;
	private ApplicationLogic mApplicationLogic;
	
	//DECLARE GUI-ELEMENTS
	private Spinner userlist;
	private Button new_user;
	private Button mButtonLogin;
	
	//DECLARE NECESSARY CLASSES
	private SessionManagement session;
	private DatabaseHandler mdbHandler;
	private boolean first_app_start;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initDatabaseHandler();
		first_app_start = false;
		first_app_start = mdbHandler.getAppStartFlag();
		if(first_app_start == true){ //TODO auf TRUE zurückändern!
			Intent i = new Intent(Init.this, StartOnboarding.class);
			finish();
			startActivity(i);
		}
		
		//INITIALIZE MVC-CLASSES
		initData(savedInstanceState);
		initGui();
		initApplicationLogic();
		initEventToListenerMapping();
		
		//INITIALIZE GUI-ELEMENTS
		initSpinner();
		initBtnNewUser();
		initLoginBtn();
		
		//INITIALIZE SESSION-VARIABLE
		session = new SessionManagement(getApplicationContext());
		
		//LOAD THE ACTUAL USERLIST FROM DATABASE AND SET TO SPINNER
		loadUserlistFromDatabase();
		
	}
	

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}
	
	//METHOD FOR INITIALIZING SPINNER
	private void initSpinner(){
		userlist = (Spinner) findViewById(R.id.spn_userlist);
	}
	
	private void initData(Bundle savedInstanceState) {
		mData = new Data(this, savedInstanceState);
	}
	
	private void initGui() {
		mGui = new Gui(this);
		
	}

	private void initApplicationLogic() {
		mApplicationLogic = new ApplicationLogic(mGui, mData);
		
	}

	private void initEventToListenerMapping() {
		new EventToListenerMapping(mGui, mApplicationLogic);
		
	}
	
	//INITIALIZE DATABASE-HANDLER
	private void initDatabaseHandler(){
		 mdbHandler = new DatabaseHandler(getApplicationContext());
	}
	
	//METHOD FOR LOADING THE ACTUAL USERLIST
	private void loadUserlistFromDatabase() {
 
        // GET SPINNER DROP DOWN ELEMENTS
        List<String> users = mdbHandler.getUserList();
 
        // CREATE ADAPTER OF USERLIST
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item, users);
 
        // DROP DOWN LAYOUT STYLE
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
 
        // ATTACHING DATA TO SPINNER
        userlist.setAdapter(dataAdapter);
		
	}



	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		//NOT USED METHOD       
		
	}


	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		//NOT USED METHOD
		
	}
	
	//METHOD TO CREATE NEW USER
	private void initBtnNewUser() {
		new_user = (Button) findViewById(R.id.new_user);
		//SET ONCLICKLISTENER
        new_user.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	//CREATE ALERT DIALOG FOR INPUT OF NEW USER
            	AlertDialog.Builder builder = new AlertDialog.Builder(Init.this);
            	//SET TITLE
            	builder.setTitle("Neuen Benutzer erstellen");

            	// SET UP THE INPUT
            	final EditText input = new EditText(Init.this);
            	// SPECIFY THE INPUT TYPE; IN THIS CASE ITS TEXT
            	input.setInputType(InputType.TYPE_CLASS_TEXT);
            	builder.setView(input);

            	// SET UP THE BUTTONS
            	builder.setPositiveButton("Hinzufügen", new DialogInterface.OnClickListener() { 
            	    @Override
            	    //SET UP ONCLICKLISTENER FOR CREATE-BUTTON
            	    public void onClick(DialogInterface dialog, int which) {
            	    	//CHECK IF SOME TEXT WAS PUT IN
            	    	if (input.getText().toString().length() > 0) {
            	    		//INSERT USER IN DATABASE-TABLE
            	    		mdbHandler.insertUser(input.getText().toString());
            	    		//REFRESH THE USER LIST
            	    		loadUserlistFromDatabase();
            	    		//SHOW TOAST FOR USER-NOTIFICATION
            	    		Toast.makeText(getApplicationContext(), "Neuer User wurde erstellt",
                                    Toast.LENGTH_SHORT).show();
            	    	}else{
            	    		//SHOW TOAST THAT SOME TEXT IS MISSING
            	    		Toast.makeText(getApplicationContext(), "Bitte gebe einen Namen ein",
                                    Toast.LENGTH_SHORT).show();
            	    	}
            	    	
            	    }
            	});
            	builder.setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {
            	    @Override
            	    //SET ONCLICKLISTENER FOR "CANCEL"-CASE
            	    public void onClick(DialogInterface dialog, int which) {
            	        //CANCEL ALERT-DIALOG
            	    	dialog.cancel();
            	    }
            	});

            	//SHOW THE ALERT-DIALOG
            	builder.show();
            }
        });
		
	}
	
	//METHOD WHEN CLICKING THE LOGIN-BUTTON
	private void initLoginBtn(){
		mButtonLogin = (Button) findViewById(R.id.btn_login_start);
		mButtonLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//CREATE SESSION WITH THE USERNAME WHICH WAS SELECTED ABOVE
				session.createLoginSession((String) userlist.getSelectedItem().toString());
				// START NEXT ACTIVITY; IN THIS CASE THE MENU ACTIVITY
				Navigation.startActivityMenu(mData.getmActivity());
				
			}
		});
	}

}
