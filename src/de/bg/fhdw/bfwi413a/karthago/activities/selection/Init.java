//initialisiert die Activity Selection

package de.bg.fhdw.bfwi413a.karthago.activities.selection;

import android.app.Activity;
import android.os.Bundle;

public class Init extends Activity{

	private Gui mGui;
	private ApplicationLogic mApplicationLogic;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initGui();
		initApplicationLogic();
		initEventToListenerMapping();
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}
	
	private void initGui() {
		mGui = new Gui(this);	
	}
	
	private void initApplicationLogic() {
		mApplicationLogic = new ApplicationLogic(mGui);
	}
	
	private void initEventToListenerMapping() {
		new EventToListenerMapping(mGui, mApplicationLogic);	
	}
	
}
