package de.bg.fhdw.bfwi413a.karthago.activities.login;

import android.view.View;

public class EventToListenerMapping{
	
	//DECLARE NECESSARY OBJECTS
	private ApplicationLogic mApplicationLogic;
	private Gui mGui;
	
	
	public EventToListenerMapping(Gui gui, ApplicationLogic applicationLogic) {
		//INITIALIZE OBJECTS
		mApplicationLogic = applicationLogic;
		mGui = gui;
		//EVENT IF NEW-USER WAS CLICKED
		mGui.getNew_user().setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mApplicationLogic.onNewUser();
			}
		});
		
		//EVENT IF LOGIN-BUTTON WAS CLICKED
		mGui.getmButtonLogin().setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mApplicationLogic.loginUser();
				
			}
		});
		
		
	}
		

}
