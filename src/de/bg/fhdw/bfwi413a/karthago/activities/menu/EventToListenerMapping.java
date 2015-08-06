package de.bg.fhdw.bfwi413a.karthago.activities.menu;

import de.bg.fhdw.bfwi413a.karthago.R;
import android.view.View;
import android.view.View.OnClickListener;

public class EventToListenerMapping implements OnClickListener{
	
	private ApplicationLogic mApplicationLogic;
	private Gui mGui;
	
	public EventToListenerMapping(Gui gui, ApplicationLogic applicationLogic){
		mApplicationLogic = applicationLogic;
		mGui = gui;
		mGui.getmButtonStartSelection().setOnClickListener(this);
		mGui.getmButtonStartConfig().setOnClickListener(this);
		mGui.getmButtonStartStatistics().setOnClickListener(this);
		mGui.getmButtonLogout().setOnClickListener(this);
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
			mApplicationLogic.onButtonClicked(4);
			break;
		}
	}

}
