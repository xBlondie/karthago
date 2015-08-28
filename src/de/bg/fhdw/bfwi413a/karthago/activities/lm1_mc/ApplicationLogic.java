package de.bg.fhdw.bfwi413a.karthago.activities.lm1_mc;

import android.content.Context;
import de.bg.fhdw.bfwi413a.karthago.db.DatabaseHandler;

//author: Leonie

public class ApplicationLogic {
	
	private Gui mGui;
	private Data mData;
	private de.bg.fhdw.bfwi413a.karthago.activities.selection.ApplicationLogic ApplicationLogicSelection;
	private DatabaseHandler dbhandler;
	private String questionID;
	
	public ApplicationLogic(Gui gui, Data data, String questionID, Context context) {
		mGui = gui;
		mData = data;
		initDataToGui();
		ApplicationLogicSelection = new de.bg.fhdw.bfwi413a.karthago.activities.selection.ApplicationLogic();
		dbhandler = new DatabaseHandler(context);
		this.questionID = questionID;
	}
	
	private void initDataToGui() {
		//TODO: Init Data from XML to TextView and Button		
	}


	public void onButtonClicked() {
		//TODO: Check which RadioButton is selected
		//TODO: Logic for Answers
		
		
	}
	
}
