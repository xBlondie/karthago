package de.bg.fhdw.bfwi413a.karthago.activities.statistics;

import android.content.Context;

public class ApplicationLogic {

	private Data mData;
	private Gui mGui;
	
	public ApplicationLogic(Gui gui, Data data, Context context) {
		//INITIALIZE COMPONENTS
		mGui = gui;
		mData = data;
		initDataToGui();
	}
	
	private void initDataToGui() {
		
	}
}
