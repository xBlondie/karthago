/**********************************************************************************
 * ----------       LEARN-MODE-2-FREE-TEXT-ACTIVITY- WRITTEN BY: FRANZISKA PLATE         ----------
 * 
 * Diese Activity hat die Funktion zur Darstellung der Freitext-Fragen der App.
 * 
 * Klassen, mit die diese App kommuniziert sind:
 * 	- Navigation (Get aktuelle QuestioID)
 *  - DatabaseHandler (Einpflegen des richtigen Ereignisses)
 *  - Results (Einholen der Variablen)
 *  - XMLDomParserAndHandler (Auslösen von Events)
 * 
 * Nähere Informationen zu den Methoden siehe im Quellcode!
 * 
 *********************************************************************************/

package de.bg.fhdw.bfwi413a.karthago.activities.lm2_ft;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import de.bg.fhdw.bfwi413a.karthago.Navigation;

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
		mData = new Data(this, savedInstanceState, getApplicationContext());
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
