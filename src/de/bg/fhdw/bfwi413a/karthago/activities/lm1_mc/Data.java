/**********************************************************************************
 * ----------       DATA-CLASS (LM1)- WRITTEN BY: LEONIE SCHIBURR       -----------
 *********************************************************************************/

/**
 * The Data Class provides the necessary data, like the question, answers, user and session,
 * from the xml and the database.
 * 
 * It also provides getters for the variables to use the information in the other classes.
 * 
 * Methods and Variables are commented in the Code.
 * 
 *  */

package de.bg.fhdw.bfwi413a.karthago.activities.lm1_mc;

//IMPORTS FOR NECESSARY CLASSES AND PACKAGES
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import de.bg.fhdw.bfwi413a.karthago.SessionManagement;
import de.bg.fhdw.bfwi413a.karthago.db.DatabaseHandler;
import de.bg.fhdw.bfwi413a.karthago.xml.Results;
import de.bg.fhdw.bfwi413a.karthago.xml.XMLDomParserAndHandler;


public class Data {
	
	//Not used, because obsolete
	//private static final String KEY_LM3_ID = "M";
	//private int mLM3Id;
	//private final int DEFAULT_LM3_ID = 0;
	
	//DECLARE ACTIVITY VARIABLE
		//This variable is necessary to get the current activity, for methods like finish() and getIntent()
		//which are used in other classes of the activity
	
	private Activity mActivity;
	
	//DECLARE NECESSARY VARIABLES
		//To retrieve the data from the xml file and the database
		//variables for the helper classes like XMLDOMParserAndHandler, Results, SessionManagement and DatabaseHandler
		//The informations are stored in String variables like questionID, UserAnswers a.s.o. which can be requested with getters
	
	XMLDomParserAndHandler xmlhandler;
	ArrayList<String> QuestionAndAnswers;
	ArrayList<String> CorrectAnswers;
	Results result = new Results();
	String questionID;
	SessionManagement session;
	private de.bg.fhdw.bfwi413a.karthago.activities.selection.ApplicationLogic ApplicationLogicSelection;
	private DatabaseHandler dbhandler;
	ArrayList<String> UserAnswers;
	
	//CONSTRUCTOR
	public Data(Activity activity, Bundle savedInstanceState, Context context){
		Intent intent;
		
		mActivity = activity;
		if ( savedInstanceState == null ) {
			intent = mActivity.getIntent();
			//Not used, because obsolete
			//mLM3Id = intent.getIntExtra(Navigation.KEY_LM3_ID, DEFAULT_LM3_ID);
		}
		else {
			//Not used, because obsolete
			//restoreDataFromBundle(savedInstanceState);
		}
		
		//INITIALIZE HELPER CLASSES AND DATA
		//gets current questionID
		questionID = mActivity.getIntent().getExtras().getString("currentQuestionId");
		//to get information from the xml file
		xmlhandler = new XMLDomParserAndHandler(context);
        QuestionAndAnswers = new ArrayList<String>();
        //gets the questions and Answers for the specific questionID
        result = xmlhandler.getRequiredQuestionAnswersAndCorrectAnswers(questionID);
        //saves questions and answers in a String Array
        QuestionAndAnswers = result.get_list_Question_and_Answers();
        //saves correct answers in a String Array
        CorrectAnswers = result.get_list_correct_answers();
        //to get information from the database 
        dbhandler = new DatabaseHandler(context);
        //to call the next question with the help of the selection application logic and the method startSingleQuestion
        ApplicationLogicSelection = new de.bg.fhdw.bfwi413a.karthago.activities.selection.ApplicationLogic();
        //get session for userDetails and cardfileId
        session = new SessionManagement(context);
        //to save the answer(s) of the user and work with it/them
        UserAnswers = new ArrayList<String>();
	}
	
	//GETTERS

	public Activity getmActivity() {
		return mActivity;
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

	public String getQuestionID() {
		return questionID;
	}

	public de.bg.fhdw.bfwi413a.karthago.activities.selection.ApplicationLogic getApplicationLogicSelection() {
		return ApplicationLogicSelection;
	}

	public DatabaseHandler getDbhandler() {
		return dbhandler;
	}

	public ArrayList<String> getUserAnswers() {
		return UserAnswers;
	}
	
	public SessionManagement getSession() {
		return session;
	}
	
	//Not used, because obsolete
	
//	public int getmMenuId() {
//	return mLM3Id;
//  }
	// save and restore data

//	public void saveDataInBundle(Bundle bundle) {
//		bundle.putInt(KEY_LM3_ID, mLM3Id);
//	}
//	
//	public void restoreDataFromBundle(Bundle bundle) {
//		mLM3Id = bundle.getInt(KEY_LM3_ID);
//	}

}
