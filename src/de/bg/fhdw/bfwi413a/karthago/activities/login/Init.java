package de.bg.fhdw.bfwi413a.karthago.activities.login;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import de.bg.fhdw.bfwi413a.karthago.R;
import de.bg.fhdw.bfwi413a.karthago.ku.db.DatabaseHandlerConfig;

public class Init extends Activity{
	
	private Data mData;
	private Gui mGui;
	private ApplicationLogic mApplicationLogic;
	private DatabaseHandlerConfig mdbHandler;
	private List<String> lables;
	private ArrayAdapter<String> dataAdapter;
	Spinner spinner;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initData(savedInstanceState);
		initSpinner();
		initGui();
		initApplicationLogic();
		initEventToListenerMapping();
		initDatabaseHandler();
		initList();
		initDataAdapter();
		
		
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}
	
	private void initSpinner(){
		spinner = (Spinner) findViewById(R.id.spinner_userlogin);
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
	
	private void initDatabaseHandler(){
		 mdbHandler = new DatabaseHandlerConfig(this);
	}
	
	private void initList(){
		lables = mdbHandler.readUserList();
	}
	
	private void initDataAdapter(){
		dataAdapter = new ArrayAdapter<String>(this,
	            android.R.layout.simple_spinner_item, lables);
		
		dataAdapter
        .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		// attaching data adapter to spinner
		spinner.setAdapter(dataAdapter);
	}
	
	

}
