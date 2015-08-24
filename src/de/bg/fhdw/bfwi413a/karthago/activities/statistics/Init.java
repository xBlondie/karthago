//Vasilij
package de.bg.fhdw.bfwi413a.karthago.activities.statistics;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import de.bg.fhdw.bfwi413a.karthago.Navigation;
import de.bg.fhdw.bfwi413a.karthago.activities.statistics.Data;
import de.bg.fhdw.bfwi413a.karthago.xml.Results;
import de.bg.fhdw.bfwi413a.karthago.xml.XMLDomParserAndHandler;
import de.bg.fhdw.bfwi413a.karthago.Util;

public class Init extends Activity {
	
	Data mData;
	Gui mGui;
	ApplicationLogic mApplicationLogic;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		initData(savedInstanceState);
		initGui();
		initApplicationLogic();
		initEventToListenerMapping();
		
		StringBuilder state = new StringBuilder();
		XMLDomParserAndHandler xml = new XMLDomParserAndHandler(getApplicationContext());
		int cardFileAmount = xml.getCardFileNames().size();
		state.append("Card Files: " + cardFileAmount + "\n");

		Results results = xml.getAllIDs();
		int cardAmount = results.get_list_ids().size();
		state.append("Questions: " + cardAmount + "\n");

		Map<String, Integer> frequencies = Util.frequencies(results.get_list_answer_type());
		for (Map.Entry<String, Integer> item: frequencies.entrySet()) {
			state.append(item.getKey() + ": " + item.getValue() + "\n");
		}
		
		mGui.setTextviewStatistic(state.toString());
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
