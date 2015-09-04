/****************************************************************************************************
 * ----------       EVENTTOLISTENERMAPPING-CLASS (LM2)- WRITTEN BY: FRANZISKA PLATE       -----------
 ***************************************************************************************************/

/**
 * The EventToListenerMapping Class sets the OnClickListener on the Buttons of the Activity.
 * It also calls the method (specified in the ApplicationLogic class) for the Button, when it is clicked.
 * If there is more then one Button clicked, it differentiates between the Buttons.
 *
 * Methods and Variables are commented in the Code.
 *
 *  */

package de.bg.fhdw.bfwi413a.karthago.activities.lm2_ft;

//IMPORTS NECESSARY CLASSES AND PACKAGES
import android.view.View;
import android.view.View.OnClickListener;

public class EventToListenerMapping implements OnClickListener{

	//DECLARE VARIABLES FOR MVC-CLASSES
	private ApplicationLogic mApplicationLogic;
	private Gui mGui;
	
	//CONSTRUCTOR
	public EventToListenerMapping (Gui gui, ApplicationLogic applicationLogic) {
		mApplicationLogic = applicationLogic;
		mGui = gui;
		//SET CLICK LISTENER ON BUTTON
		mGui.getCommiting().setOnClickListener(this);
	}	

	@Override
	public void onClick(View v) {
		//CALL ONCLICK METHOD FOR THE SPECIFIC BUTTON
		mApplicationLogic.onButtonClicked();		
	}
	
}
