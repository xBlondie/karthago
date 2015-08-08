package de.bg.fhdw.bfwi413a.karthago.activities.login;

import de.bg.fhdw.bfwi413a.karthago.Navigation;
import de.bg.fhdw.bfwi413a.karthago.session_management.SessionManagement;

public class ApplicationLogic {
	
	private Gui mGui;
	private Data mData;
	
	// @author Patrick
	SessionManagement session;
	// ---- END @author Patrick ----
	
	public ApplicationLogic(Gui gui, Data data){
		mGui = gui;
		mData = data;
	}
	
	public void onLoginButtonClick(){
		// @auhtor Patrick
//		session = new SessionManagement();
		session.createLoginSession("Test");
        // ---- END @ author Patrick ----
		
//		Log.d("LOGTAG", "onLoginButtonClicked()");
		Navigation.startActivityMenu(mData.getmActivity());	
	}
	
	public void onSpinnerUsed(){
		//Do something here
	}
}
