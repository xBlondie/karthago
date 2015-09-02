/****************************************************************************************************
 * ----------       EVENTTOLISTENERMAPPING-CLASS (LM1)- WRITTEN BY: LEONIE SCHIBURR       -----------
 ***************************************************************************************************/

/**
 * The EventToListenerMapping sets the OnClickListener on the Buttons of the Activity.
 * It also calls the specific Application Logic for the Button, when it is clicked.
 * If there is more then one Button clicked, it differentiates between the Buttons.
 * 
 * Methods and Variables are commented in the Code.
 * 
 *  */

package de.bg.fhdw.bfwi413a.karthago.activities.lm1_mc;

import android.view.View;
import android.view.View.OnClickListener;

public class EventToListenerMapping implements OnClickListener{

	private ApplicationLogic mApplicationLogic;
	private Gui mGui;
	
	
	public EventToListenerMapping (Gui gui, ApplicationLogic applicationLogic) {
		mApplicationLogic = applicationLogic;
		mGui = gui;
		mGui.getConfirm().setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		mApplicationLogic.onButtonClicked();
	}
	
}
