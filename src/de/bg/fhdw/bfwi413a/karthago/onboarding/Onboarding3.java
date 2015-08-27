package de.bg.fhdw.bfwi413a.karthago.onboarding;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import de.bg.fhdw.bfwi413a.karthago.R;
import de.bg.fhdw.bfwi413a.karthago.SessionManagement;
import de.bg.fhdw.bfwi413a.karthago.db.DatabaseHandler;

public class Onboarding3 extends Activity{ 
	
	//DECLARE NECESSARY VARIABLES
	TextView txtView;
	Button button;
	EditText editText;
	DatabaseHandler mdbhandler;
	SessionManagement session;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//SET LAYOUT
		setContentView(R.layout.onboarding_3);
		
		//INITIALIZE GUI ELEMENTS AND NECESARY VARIABLES
		txtView = (TextView) findViewById(R.id.textView1);
		button = (Button) findViewById(R.id.Button01);
		editText = (EditText) findViewById(R.id.editText1);
		mdbhandler = new DatabaseHandler(getApplicationContext());
		session = new SessionManagement(getApplicationContext());
		
		//SET ON CLICK LISTENeR FOR BUTTON
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//CONTAINS THE INPUT-FIELD TEXT
				if (editText.getText().toString().length() > 0) {
    	    		//INSERT USER IN DATABASE-TABLE
    	    		mdbhandler.insertUser(editText.getText().toString());
    	    		//CREATE USER-SESSION
    	    		session.createLoginSession(editText.getText().toString());
    	    		//STaRT NEXT ACTIVITY
    	    		Intent i = new Intent(Onboarding3.this, Onboarding4.class);
    				finish();
    				startActivity(i);
				}
			}
		});
	}
}
