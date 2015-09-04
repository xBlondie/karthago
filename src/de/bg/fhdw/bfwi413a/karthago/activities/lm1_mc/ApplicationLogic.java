/**********************************************************************************************
 * ----------       APPLICATIONLOGIC-CLASS (LM1)- WRITTEN BY: LEONIE SCHIBURR       -----------
 *********************************************************************************************/

/**
 * The ApplicationLogic Class provides the program logic for the learn mode.
 * It initializes the Gui with the data from the xml and database, like question and level, and
 * it reacts to the user input and validates its answer and executes the logic for right or wrong
 * answers.
 * 
 * Methods and Variables are commented in the Code.
 * 
 *  */

package de.bg.fhdw.bfwi413a.karthago.activities.lm1_mc;

//IMPORTS FOR NECESSARY CLASSES AND PACKAGES
import java.util.ArrayList;
import java.util.Date;

import android.content.Context;
import android.widget.Toast;

public class ApplicationLogic {
	
	//DECLARE VARIABLES FOR DATA AND MVC-CLASSES
	private Gui mGui;
	private Data mData;
	Context mContext;
	String user;
    String cardfile;
    ArrayList<String> CorrectAnswers;
    String textForLevel;
	
    //CONSTRUCTOR
	public ApplicationLogic(Gui gui, Data data, Context context) {
		mGui = gui;
		mData = data;
		mContext = context;
		//INITIALIZE DATA TO GUI ELEMENTS
		initDataToGui();
	}
	
	//METHOD TO INITIALZE GUI WITH DATA FROM XML AND DATABASE
	private void initDataToGui() {
		//Init Data from XML to TextView and Button
		mGui.setQuestion(mData.getQuestionAndAnswers().get(0).toString());
        textForLevel = "Level: " + mData.getDbhandler().getCurrentLevelForQuestionId(mData.getQuestionID());
        mGui.setLeveltext(textForLevel);
		mGui.setAnswer1(mData.getQuestionAndAnswers().get(1).toString());
		mGui.setAnswer2(mData.getQuestionAndAnswers().get(2).toString());
		mGui.setAnswer3(mData.getQuestionAndAnswers().get(3).toString());
		mGui.setAnswer4(mData.getQuestionAndAnswers().get(4).toString());
		user = mData.getSession().getUserDetails();
		cardfile = mData.getSession().getCardfileID();
		CorrectAnswers = mData.getResult().get_list_correct_answers();
	}

	//METHOD TO CHECK USER ANSWER 
	public void onButtonClicked() {
		//Logic for Answering Process
		
		//Saves boolean value --> if user answer is wrong = false, if right = true; default = true
		boolean rightORwrong = true;
		//Saves event --> Differentiates between "correct" and "incorrect"; default = "correct"
		String event_name = "correct";
		
		//Verify which RadioButton is checked
		
		if(mGui.getAnswer1().isChecked()){
			//Adds Answer to UserAnswers, if its checked
			mData.getUserAnswers().add(mGui.getAnswer1().getText().toString());
		}
		
		if(mGui.getAnswer2().isChecked()){
			//Adds Answer to UserAnswers, if its checked
			mData.getUserAnswers().add(mGui.getAnswer2().getText().toString());
		}
		
		if(mGui.getAnswer3().isChecked()){
			//Adds Answer to UserAnswers, if its checked
			mData.getUserAnswers().add(mGui.getAnswer3().getText().toString());
		}
		
		if(mGui.getAnswer4().isChecked()){
			//Adds Answer to UserAnswers, if its checked
			mData.getUserAnswers().add(mGui.getAnswer4().getText().toString());
		}
		
		//Checks if the number of user answers equals the number of correct answers
		if(mData.getUserAnswers().size() == CorrectAnswers.size()){
			for(int i = 0; i < CorrectAnswers.size(); i++){
				//checks if selected answer(s) equal(s) the correct answer(s)
				if(mData.getUserAnswers().get(i).toString().equals(CorrectAnswers.get(i).toString())){
					
				}else{
					rightORwrong = false;
					event_name = "incorrect";
					break;
				}
			}
		}else{
			rightORwrong = false;
			event_name = "incorrect";
		}
		
		if(rightORwrong == true){
			//if user answered correct he will be informed with a message
			Toast toast = Toast.makeText(mContext, "Die Antwort war richtig!", Toast.LENGTH_LONG);
			toast.show();
		}else{
			//if user answered incorrect, he will be informed with a message
			//and the correct answers will be displayed
			
			//saves correct answers in a String with comma separation
			String corAns = new String();
			for(int i = 0; i < CorrectAnswers.size(); i++){
				corAns = corAns + ", " + (CorrectAnswers.get(i).toString());
			}
			//workaround to delete the comma before the first answer
			StringBuilder sb = new StringBuilder(corAns);
			sb.deleteCharAt(0);
			String corAnsClean = sb.toString();
			
			//information text for the user
			Toast toast = Toast.makeText(mContext, "Die Antwort war falsch!\nRichtige Antworten: " + corAnsClean, Toast.LENGTH_LONG);
			toast.show();
		}
		
		//Sets new level and timestamp according to rightORwrong
		long tstamp = new Date().getTime();
		mData.getDbhandler().IncreaseOrDecreaseLevelAndSetNewTimestamp(rightORwrong, mData.getQuestionID(), tstamp);
		//For statistics
		mData.getDbhandler().insertEvent(event_name, tstamp, user, cardfile);
		//Finishes current Activity
		mData.getmActivity().finish();
		//starts new Activity (next question or back to selection)
		mData.getApplicationLogicSelection().startSingleQuestion(mContext);
	}
	
}
