package de.bg.fhdw.bfwi413a.karthago.activities.menu;

import de.bg.fhdw.bfwi413a.karthago.R;
import de.bg.fhdw.bfwi413a.karthago.SessionManagement;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Init extends Activity{
	
	private Data mData;
	private Gui mGui;
	private ApplicationLogic mApplicationLogic;
	
	//@ author Patrick
	TextView set_username;
	SessionManagement session;
			
	// ---- END @ author Patrick ----
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initData(savedInstanceState);
		initGui();
		initApplicationLogic();
		initEventToListenerMapping();
		
		//@author Patrick
		set_username = (TextView) findViewById(R.id.set_salutations);
		session = new SessionManagement(getApplicationContext());
		setUsername();
		// ---- END @author Patrick ----
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}
	
	private void initData(Bundle savedInstanceState) {
		mData = new Data(this, savedInstanceState);
	}
	
	private void initGui(){
		mGui = new Gui(this);
	}
	
	private void initApplicationLogic(){
		mApplicationLogic = new ApplicationLogic(mGui, mData);
	}

	private void initEventToListenerMapping(){
		new EventToListenerMapping(mGui, mApplicationLogic, this);
	}
	
	//@author Patrick
	private void setUsername(){
		session.checkLogin();
		String user = session.getUserDetails();
		set_username.setText(user);
	}
	// ---- END @author Patrick ----
}
