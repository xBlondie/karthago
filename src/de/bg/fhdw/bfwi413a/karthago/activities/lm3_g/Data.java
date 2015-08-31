package de.bg.fhdw.bfwi413a.karthago.activities.lm3_g;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import de.bg.fhdw.bfwi413a.karthago.Navigation;
import de.bg.fhdw.bfwi413a.karthago.SessionManagement;
import de.bg.fhdw.bfwi413a.karthago.db.DatabaseHandler;
import de.bg.fhdw.bfwi413a.karthago.xml.Results;
import de.bg.fhdw.bfwi413a.karthago.xml.XMLDomParserAndHandler;

public class Data {
	
	private static final String KEY_LM3_ID = "M"; //Um den Zustand der Activity zu erhalten
	
	private int mLM3Id;
	private Activity mActivity;
	
	private final int DEFAULT_LM3_ID = 0;
	
	
	XMLDomParserAndHandler xmlhandler;
	Results result = new Results();
	String questionText;
	ArrayList<String> correctAnswers;
	String questionID;
	SessionManagement session;
	private de.bg.fhdw.bfwi413a.karthago.activities.selection.ApplicationLogic ApplicationLogicSelection;
	private DatabaseHandler dbhandler;
	
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
		
		questionID = mActivity.getIntent().getExtras().getString("currentQuestionId");
		xmlhandler = new XMLDomParserAndHandler(context);
		correctAnswers = new ArrayList<String>();
		result = xmlhandler.questionAndAnswersForFTAndGQuestions(questionID);
		questionText = result.getQuestionForFT();
		correctAnswers = result.getCorrectAnswersForFT();
		dbhandler = new DatabaseHandler(context);
        ApplicationLogicSelection = new de.bg.fhdw.bfwi413a.karthago.activities.selection.ApplicationLogic();
		session = new SessionManagement(context);
	}

	public int getmMenuId() {
		return mLM3Id;
	}

	public Activity getmActivity() {
		return mActivity;
	}
	
	public Results getResult() {
		return result;
	}

	public String getQuestionText() {
		return questionText;
	}

	public ArrayList<String> getCorrectAnswers() {
		return correctAnswers;
	}

	public String getQuestionID() {
		return questionID;
	}

	public DatabaseHandler getDbhandler() {
		return dbhandler;
	}
	
	public SessionManagement getSession() {
		return session;
	}
	
	public de.bg.fhdw.bfwi413a.karthago.activities.selection.ApplicationLogic getApplicationLogicSelection() {
		return ApplicationLogicSelection;
	}
	
	// save and restore data

	public void saveDataInBundle(Bundle bundle) {
		bundle.putInt(KEY_LM3_ID, mLM3Id);
	}
	
	public void restoreDataFromBundle(Bundle bundle) {
		mLM3Id = bundle.getInt(KEY_LM3_ID);
	}

}
