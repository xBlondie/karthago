/**********************************************************************************************
 * ----------       APPLICATIONLOGIC-CLASS (LM2)- WRITTEN BY: FRANZISKA PLATE       -----------
 *********************************************************************************************/

/**
 * The ApplicationLogic Class provides the program logic for the learn mode 2 (free text answers).
 * It initializes the Gui with the data from the xml and database, like question and level, and
 * it reacts to the user inputs and validates its answer and executes the logic for right or wrong
 * answers.
 * 
 * Methods and Variables are commented in the Code.
 * 
 *  */

package de.bg.fhdw.bfwi413a.karthago.activities.lm2_ft;
//IMPORTS NECESSARY CALSSES AND PACKAGES
import java.util.Date;

import android.content.Context;
import android.widget.Toast;

public class ApplicationLogic {
	//DECLARE VARIABLES FOR DATA AND MVC-CLASSES
	private Gui mGui;
	private Data mData;
	private String user;
    private String cardfile;
    private String userAnswer;
    private Context mContext;
	
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
		mGui.setQuestion(mData.getQuestionText());
	    String textForLevel = new String();
	    textForLevel = "Level: " + mData.getDbhandler().getCurrentLevelForQuestionId(mData.getQuestionID());
	    mGui.setLeveltext(textForLevel);
	    user = mData.getSession().getUserDetails();
	    cardfile = mData.getSession().getCardfileID();
	}

	//METHOD TO CHECK USER ANSWER
	public void onButtonClicked() {
		//Logic for the answering Prozess
		
		//Save User input from EditTextView in userAnswer
		userAnswer = mGui.getAnswer().getText().toString();
		//Saves boolean value --> if user answer is wrong = false, if right = true; default = false
		boolean rightORwrong = false;
		//Saves event --> Differentiates between "correct" and "incorrect"; default = "incorrect" --> 
		String event_name = "incorrect";
		
		//Checkts if userAnswers is one of the correct answers
		for(int i = 0; i < mData.getCorrectAnswers().size(); i++){
			if(mData.getCorrectAnswers().get(i).toString().equalsIgnoreCase(userAnswer)){
				rightORwrong = true;
				event_name = "correct";
				break;
			}
		}
		//If useranswer is true user will get a Note that answer is correct
		if(rightORwrong == true){
			Toast toast = Toast.makeText(mContext, "Die Antwort war richtig!", Toast.LENGTH_LONG);
			toast.show();
		}else{
			//Correct answers are shown and separated by commas 
			String corAns = new String();
			for(int i = 0; i < mData.getCorrectAnswers().size(); i++){
				corAns = corAns + ", " + (mData.getCorrectAnswers().get(i).toString());
			}
			//StringBuilder is used because of deleting the first comma of the correct answers
			StringBuilder sb = new StringBuilder(corAns);
			sb.deleteCharAt(0);
			String corAnsClean = sb.toString();
			Toast toast = Toast.makeText(mContext, "Die Antwort war falsch!\nRichtige Antworten: " + corAnsClean, Toast.LENGTH_LONG);
			toast.show();
		}
		
		//Get current TimeStamp 
		long tstamp = new Date().getTime();
		//Set new TimeStamp --> get right or worng answere information, looks through the database, increases or decreases TimeStamp
		mData.getDbhandler().IncreaseOrDecreaseLevelAndSetNewTimestamp(rightORwrong, mData.getQuestionID(), tstamp);
		//For statistics
		mData.getDbhandler().insertEvent(event_name, tstamp, user, cardfile);
		//Finishes current Activity
		mData.getmActivity().finish();
		//starts new Activity (next question or back to selection)
		mData.getApplicationLogicSelection().startSingleQuestion(mContext);
	}

}
