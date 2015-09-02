/***********************************************************************************************************
 * ----------       LEARN-MODE-3-GEDANKLICH-ACTIVITY - WRITTEN BY: LEONIE SCHIBURR           ----------

 * 
 * This Activity is for the questions of the cardfile, which the user has to answer in his thoughts.
 * 
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

package de.bg.fhdw.bfwi413a.karthago.activities.lm3_g;

/**********************************************************************************
 * ----------       INIT-CLASS (LM3)- WRITTEN BY: LEONIE SCHIBURR       -----------
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

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import de.bg.fhdw.bfwi413a.karthago.Navigation;
import de.bg.fhdw.bfwi413a.karthago.R;

public class Init extends Activity{
	
	private Data mData;
	private Gui mGui;
	private ApplicationLogic mApplicationLogic;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lm3_g);
		
		initData(savedInstanceState);
		initGui();
		initApplicationLogic();
		initEventToListenerMapping();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}
	
	private void initData(Bundle savedInstanceState) {
		mData = new Data(this, savedInstanceState, Init.this);
	}
	
	private void initGui() {
		mGui = new Gui(this);
	}
	
	private void initApplicationLogic() {
		mApplicationLogic = new ApplicationLogic(mGui, mData, Init.this);
	}
	
	private void initEventToListenerMapping() {
		new EventToListenerMapping(mGui, mApplicationLogic);
	}
	
	public boolean onKeyDown(int keycode, KeyEvent event){
		//CATCH BACK-BUTTON EVENT
		  if(keycode==KeyEvent.KEYCODE_BACK){
			//CALL MENU-ACTIVITY
		   Navigation.startActivityMenu(mData.getmActivity());
		  }
		 return false;
		 }
}
