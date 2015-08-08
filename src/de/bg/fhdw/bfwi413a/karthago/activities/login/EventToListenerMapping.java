package de.bg.fhdw.bfwi413a.karthago.activities.login;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

public class EventToListenerMapping implements OnClickListener, OnItemSelectedListener{
	
	private ApplicationLogic mApplicationLogic;
	private Gui mGui;
	
	
	public EventToListenerMapping(Gui gui, ApplicationLogic applicationLogic) {
		mApplicationLogic = applicationLogic;
		mGui = gui;
//		mGui.getmButtonLogin().setOnClickListener(this);
		mGui.getmSpinnerUser().setOnItemSelectedListener(this);
		
		
	}

	@Override
	public void onClick(View v) {
//		mApplicationLogic.onLoginButtonClick();
	}
	

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		//mApplicationLogic.onSpinnerUsed();
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
	}
	
	

}
