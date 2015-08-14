//initialisiert die Activity Selection

package de.bg.fhdw.bfwi413a.karthago.activities.selection;

import de.bg.fhdw.bfwi413a.karthago.Navigation;
import de.bg.fhdw.bfwi413a.karthago.activities.selection.Data;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;

public class Init extends Activity{

	private Data mData;
	private Gui mGui;
	private ApplicationLogic mApplicationLogic;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
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
		mData = new Data(this, savedInstanceState);
	}
	
	private void initGui() {
		mGui = new Gui(this);	
	}
	
	private void initApplicationLogic() {
		mApplicationLogic = new ApplicationLogic(mGui, mData, getApplicationContext());
	}
	
	private void initEventToListenerMapping() {
		new EventToListenerMapping(mGui, mApplicationLogic);	
	}
	
	public boolean onKeyDown(int keycode, KeyEvent event){
		  if(keycode==KeyEvent.KEYCODE_BACK){
		   Navigation.startActivityMenu(mData.getmActivity());
		  }
		 return false;
		 }
	
}
