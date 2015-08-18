package de.bg.fhdw.bfwi413a.karthago.activities.lm3_g;

import java.util.ArrayList;

import android.content.Context;

public class ApplicationLogic {
	
	private Gui mGui;
	private Data mData;
	Context mContext;
	ArrayList<String> mQuestionAndAnswers;
	ArrayList<String> mCorrectAnswers;
	
	public ApplicationLogic(Gui gui, Data data, Context context) {
		mGui = gui;
		mData = data;
		mContext = context;
		initDataToGui();
	}
	
	private void initDataToGui() {
		//TODO: Init Data from XML to TextView and Button
		
	}


	public void onButtonClicked() {
		//TODO: Logic for Answers
		
	}

	
}
