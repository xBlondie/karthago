package de.bg.fhdw.bfwi413a.karthago.activities.menu;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import de.bg.fhdw.bfwi413a.karthago.R;
import de.bg.fhdw.bfwi413a.karthago.SessionManagement;
import de.bg.fhdw.bfwi413a.karthago.xml.XMLDomParserAndHandler;
import de.bg.fhdw.bfwi413a.karthago.xml.XmlToDbCommunication;

public class Init extends Activity{
	
	private Data mData;
	private Gui mGui;
	private ApplicationLogic mApplicationLogic;
	
	//@ author Patrick
	TextView set_username;
	SessionManagement session;
	XMLDomParserAndHandler xmlhandler;
	XmlToDbCommunication xmldb;
			
	// ---- END @ author Patrick ----
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initData(savedInstanceState);
		initGui();
		initApplicationLogic();
		initEventToListenerMapping();
		
		//Custom font by An-nam and Fanziska
		//TextView textViewCustom = (TextView) findViewById (R.id.textViewCustomFont);
		
		
		//@author Patrick
		set_username = (TextView) findViewById(R.id.set_salutations);
		session = new SessionManagement(getApplicationContext());
		setUsername();
		xmlhandler = new XMLDomParserAndHandler(Init.this);
		xmldb = new XmlToDbCommunication(Init.this);
		xmldb.initializeAtFirstStart();
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
