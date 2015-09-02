/***********************************************************************************************************
 * ----------       LEARN-MODE-1-MULTIPLE-CHOICE-ACTIVITY - WRITTEN BY: LEONIE SCHIBURR           ----------
 * 
 * This Activity is for the Multiple Choice Questions of the cardfile.
 * The main Functions are:
 * - Provide the information for the current question from the xmlfile and the database
 * - Initialize the Activity with gui elements, question data, listeners and logic
 * - Interaction with user and providing answering process
 * 
 * Classes, with which this Activity communicates, are:
 * 	 - Navigation (Call to start the next Activity)
 *   - SessionManagement (To get the current session)
 *   - DatabaseHandler (To retrieve data like the questionId, user a.s.o.)
 * 
 * Methodes and Variables are commented in the Code.
 * 
 **********************************************************************************************************/

package de.bg.fhdw.bfwi413a.karthago.activities.lm1_mc;

/**********************************************************************************
 * ----------       INIT-CLASS (LM1)- WRITTEN BY: LEONIE SCHIBURR       -----------
 *********************************************************************************/

/**
 * The Init Class initializes the activity. It initializes the Gui, the Data, the Application Logic and 
 * the Event to Listener Mapping.
 * It also reacts if the back button is of the device is pressed and provides the onSaveInstanceState method
 * to store additional data for the recreation of the Activity if necessary.
 * 
 * Methods and Variables are commented in the Code.
 * 
 *  */


import de.bg.fhdw.bfwi413a.karthago.Navigation;
import android.app.Activity;

import android.os.Bundle;
import android.view.KeyEvent;

public class Init extends Activity{
	
	//DECLARE VARIABLES FOR MVC-CLASSES
	private Data mData;
	private Gui mGui;
	private ApplicationLogic mApplicationLogic;
		
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //INITIALIZE MVC-CLASSES
		initData(savedInstanceState);
		initGui();
		initApplicationLogic();
		initEventToListenerMapping();	
	}
 
	//METHOD FOR RECREATING ACTIVITY
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}
	
	//METHOD FOR INITIALIZING DATA
	private void initData(Bundle savedInstanceState) {
		mData = new Data(this, savedInstanceState, getApplicationContext());
	}
	
	//METHOD FOR INITIALIZING GUI
	private void initGui() {
		mGui = new Gui(this);
	}
	
	//METHOD FOR INITIALIZING APPLICATIONLOGIC
	private void initApplicationLogic() {
		mApplicationLogic = new ApplicationLogic(mGui, mData, getApplicationContext());
	}
	
	//METHOD FOR INITIALIZING EVENTTOLISTENERMAPPING
	private void initEventToListenerMapping() {
		new EventToListenerMapping(mGui, mApplicationLogic);
	}
	
	//LISTENER FOR BACK BUTTON
	public boolean onKeyDown(int keycode, KeyEvent event){
		//CATCH BACK-BUTTON EVENT
		  if(keycode==KeyEvent.KEYCODE_BACK){
			  //CALL MENU-ACTIVITY
		   Navigation.startActivityMenu(mData.getmActivity());
		  }
		 return false;
		 }

}
