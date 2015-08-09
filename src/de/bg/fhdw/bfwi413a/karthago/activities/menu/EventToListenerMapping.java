package de.bg.fhdw.bfwi413a.karthago.activities.menu;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import de.bg.fhdw.bfwi413a.karthago.R;
import de.bg.fhdw.bfwi413a.karthago.SessionManagement;

public class EventToListenerMapping implements OnClickListener{
	
	private ApplicationLogic mApplicationLogic;
	private Gui mGui;
	
	//@author Patrick
	SessionManagement session;
	// ---- END @author Patrick ----
	
	public EventToListenerMapping(Gui gui, ApplicationLogic applicationLogic, Context context){
		mApplicationLogic = applicationLogic;
		mGui = gui;
		mGui.getmButtonStartSelection().setOnClickListener(this);
		mGui.getmButtonStartConfig().setOnClickListener(this);
		mGui.getmButtonStartStatistics().setOnClickListener(this);
		mGui.getmButtonLogout().setOnClickListener(this);
		
		//@author Patrick
		session = new SessionManagement(context);
		//---- END @author Patrick ----
	}

	@Override
	public void onClick(View v) {
		switch ( v.getId() ) {
		case R.id.btn_start_selection:   // CardFile Button
			mApplicationLogic.onButtonClicked(1);
			break;
		case R.id.btn_start_config:   // CardFile Button
			mApplicationLogic.onButtonClicked(2);
			break;
		case R.id.btn_start_statistics:   // CardFile Button
			mApplicationLogic.onButtonClicked(3);
			break;
		case R.id.btn_logout:   // CardFile Button
			//@author Patrick
			session.logoutUser();
			// ---- END @author Patrick ----
			mApplicationLogic.onButtonClicked(4);
			break;
		}
	}

}
