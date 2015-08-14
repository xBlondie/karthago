package de.bg.fhdw.bfwi413a.karthago.activities.lm3_g;

//author: Leonie

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import de.bg.fhdw.bfwi413a.karthago.Navigation;
import de.bg.fhdw.bfwi413a.karthago.xml.Results;
import de.bg.fhdw.bfwi413a.karthago.xml.XMLDomParserAndHandler;

public class Data {
	
	private static final String KEY_LM3_ID = "M"; //Um den Zustand der Activity zu erhalten
	
	private int mLM3Id;
	private Activity mActivity;
	
	private final int DEFAULT_LM3_ID = 0;
	
	XMLDomParserAndHandler xmlhandler;
	ArrayList<String> QuestionAndAnswers;
	ArrayList<String> CorrectAnswers;
	Results result = new Results();
	
	public Data(Activity activity, Bundle savedInstanceState, Context context){
		Intent intent;
		
		mActivity = activity;
		if ( savedInstanceState == null ) {
			intent = mActivity.getIntent();
			mLM3Id = intent.getIntExtra(Navigation.KEY_LM3_ID, DEFAULT_LM3_ID);
		}
		else {
			restoreDataFromBundle(savedInstanceState);
		}
		xmlhandler = new XMLDomParserAndHandler(context);
	    String questionID = mActivity.getIntent().getExtras().getString("currentQuestionId");
	    QuestionAndAnswers = new ArrayList<String>();
	    result = xmlhandler.getRequiredQuestionAnswersAndCorrectAnswers(questionID);
	    QuestionAndAnswers = result.get_list_Question_and_Answers();
	}

	public int getmMenuId() {
		return mLM3Id;
	}

	public Activity getmActivity() {
		return mActivity;
	}
	
	public XMLDomParserAndHandler getXmlhandler() {
		return xmlhandler;
	}

	public ArrayList<String> getQuestionAndAnswers() {
		return QuestionAndAnswers;
	}

	public ArrayList<String> getCorrectAnswers() {
		return CorrectAnswers;
	}

	public Results getResult() {
		return result;
	}
	
	// save and restore data

	public void saveDataInBundle(Bundle bundle) {
		bundle.putInt(KEY_LM3_ID, mLM3Id);
	}
	
	public void restoreDataFromBundle(Bundle bundle) {
		mLM3Id = bundle.getInt(KEY_LM3_ID);
	}

}
