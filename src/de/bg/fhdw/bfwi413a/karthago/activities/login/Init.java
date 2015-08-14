package de.bg.fhdw.bfwi413a.karthago.activities.login;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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

public class Init extends Activity implements
OnItemSelectedListener {
	
	private Data mData;
	private Gui mGui;
	private ApplicationLogic mApplicationLogic;
	
	//@author Patrick
	private DatabaseHandler mdbHandler;
	Spinner userlist;
	Button new_user;
	Button mButtonLogin;
	SessionManagement session;
	
	// ----END @author Patrick ----
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initData(savedInstanceState);
		initGui();
		initApplicationLogic();
		initEventToListenerMapping();
		initDatabaseHandler();
		
		//@author Patrick
		initSpinner();
		initBtnNewUser();
		loadUserlistFromDatabase();
		initLoginBtn();
		session = new SessionManagement(getApplicationContext());
		//----END @auhtor Patrick ----
	}
	

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}
	
	//@author Patrick
	private void initSpinner(){
		userlist = (Spinner) findViewById(R.id.spn_userlist);
	}
	//END @author Patrick
	
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
	
	//@author Patrick
	
	private void initDatabaseHandler(){
		 mdbHandler = new DatabaseHandler(getApplicationContext());
	}
	
	private void loadUserlistFromDatabase() {
 
        // Spinner Drop down elements
        List<String> users = mdbHandler.getUserList();
 
        // Creating adapter for spinner
        //ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
        //        android.R.layout.simple_spinner_item, users);
        
        //An-Nam's Version für Textgröße vom Spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item, users);
 
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
 
        // attaching data adapter to spinner
        userlist.setAdapter(dataAdapter);
		
	}



	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		// On selecting a spinner item
//        String user = parent.getItemAtPosition(position).toString();
        
		
	}


	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		
		
	}
	
	private void initBtnNewUser() {
		new_user = (Button) findViewById(R.id.new_user);
        new_user.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	AlertDialog.Builder builder = new AlertDialog.Builder(Init.this);
            	builder.setTitle("Neuen Benutzer erstellen");

            	// Set up the input
            	final EditText input = new EditText(Init.this);
            	// Specify the type of input expected; in this case as text
            	input.setInputType(InputType.TYPE_CLASS_TEXT);
            	builder.setView(input);

            	// Set up the buttons
            	builder.setPositiveButton("Hinzufügen", new DialogInterface.OnClickListener() { 
            	    @Override
            	    public void onClick(DialogInterface dialog, int which) {
            	    	if (input.getText().toString().length() > 0) {
            	    		mdbHandler.insertUser(input.getText().toString());
            	    		loadUserlistFromDatabase();
            	    		
            	    	}else{
            	    		Toast.makeText(getApplicationContext(), "Bitte gebe einen Namen ein",
                                    Toast.LENGTH_SHORT).show();
            	    	}
            	    	
            	    }
            	});
            	builder.setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {
            	    @Override
            	    public void onClick(DialogInterface dialog, int which) {
            	        dialog.cancel();
            	    }
            	});

            	builder.show();
            }
        });
		
	}
	
	private void initLoginBtn(){
		mButtonLogin = (Button) findViewById(R.id.btn_login_start);
		mButtonLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				session.createLoginSession((String) userlist.getSelectedItem().toString());
				
				Navigation.startActivityMenu(mData.getmActivity());
				
			}
		});
	}
	
	

	//----END @author Patrick ----

}
