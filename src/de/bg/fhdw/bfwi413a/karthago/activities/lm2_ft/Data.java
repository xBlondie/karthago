package de.bg.fhdw.bfwi413a.karthago.activities.lm2_ft;

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
	
	//Not used, because obsolete
//	private static final String KEY_LM2_ID = "M";
//	private int mLM2Id;
//	private final int DEFAULT_LM2_ID = 0;
	
	private Activity mActivity;
	
	private XMLDomParserAndHandler xmlhandler;
	private Results result = new Results();
	private String questionText;
	private ArrayList<String> correctAnswers;
	private String questionID;
	private de.bg.fhdw.bfwi413a.karthago.activities.selection.ApplicationLogic ApplicationLogicSelection;
	private DatabaseHandler dbhandler;
	private String userAnswer;
	private SessionManagement session;
	
	public Data(Activity activity, Bundle savedInstanceState, Context context){
		Intent intent;
		
		mActivity = activity;
		if ( savedInstanceState == null ) {
			intent = mActivity.getIntent();
			//Not used, because obsolete
			//mLM2Id = intent.getIntExtra(Navigation.KEY_LM2_ID, DEFAULT_LM2_ID);
		}
		else {
			//Not used, because obsolete
			//restoreDataFromBundle(savedInstanceState);
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

	public de.bg.fhdw.bfwi413a.karthago.activities.selection.ApplicationLogic getApplicationLogicSelection() {
		return ApplicationLogicSelection;
	}

	public DatabaseHandler getDbhandler() {
		return dbhandler;
	}

	public String getUserAnswer() {
		return userAnswer;
	}

	public SessionManagement getSession() {
		return session;
	}
	
//	public int getmMenuId() {
//		return mLM2Id;
//	}
	
	// save and restore data

//	public void saveDataInBundle(Bundle bundle) {
//		bundle.putInt(KEY_LM2_ID, mLM2Id);
//	}
//	
//	public void restoreDataFromBundle(Bundle bundle) {
//		mLM2Id = bundle.getInt(KEY_LM2_ID);
//	}
	
}
