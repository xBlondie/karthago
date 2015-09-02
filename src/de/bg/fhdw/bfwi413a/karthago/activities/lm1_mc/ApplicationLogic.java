/**********************************************************************************************
 * ----------       APPLICATIONLOGIC-CLASS (LM1)- WRITTEN BY: LEONIE SCHIBURR       -----------
 *********************************************************************************************/

/**
 * The ApplicationLogic Class provides the program logic for the learn mode.
 * It initializes the Gui with the data from the xml and database, like question and level, and
 * it reacts to the user inputs and validates its answer and executes the logic for right or wrong
 * answers.
 * 
 * Methods and Variables are commented in the Code.
 * 
 *  */

package de.bg.fhdw.bfwi413a.karthago.activities.lm1_mc;

import java.util.ArrayList;
import java.util.Date;

import android.content.Context;
import android.widget.Toast;

public class ApplicationLogic {
	
	private Gui mGui;
	private Data mData;
	Context mContext;
	String user;
    String cardfile;
    ArrayList<String> CorrectAnswers;
    String textForLevel;
	
	public ApplicationLogic(Gui gui, Data data, Context context) {
		mGui = gui;
		mData = data;
		mContext = context;
		initDataToGui();
	}
	
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


	public void onButtonClicked() {
		//Check which RadioButton is selected
		//Logic for Answers
		
		boolean rightORwrong = true;
		String event_name = "correct";
		
		if(mGui.getAnswer1().isChecked()){
			mData.getUserAnswers().add(mGui.getAnswer1().getText().toString());
		}
		
		if(mGui.getAnswer2().isChecked()){
			mData.getUserAnswers().add(mGui.getAnswer2().getText().toString());
		}
		
		if(mGui.getAnswer3().isChecked()){
			mData.getUserAnswers().add(mGui.getAnswer3().getText().toString());
		}
		
		if(mGui.getAnswer4().isChecked()){
			mData.getUserAnswers().add(mGui.getAnswer4().getText().toString());
		}
		
		if(mData.getUserAnswers().size() == CorrectAnswers.size()){
			for(int i = 0; i < CorrectAnswers.size(); i++){
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
			Toast toast = Toast.makeText(mContext, "Die Antwort war richtig!", Toast.LENGTH_LONG);
			toast.show();
		}else{
			String corAns = new String();
			for(int i = 0; i < CorrectAnswers.size(); i++){
				corAns = corAns + ", " + (CorrectAnswers.get(i).toString());
			}
			StringBuilder sb = new StringBuilder(corAns);
			sb.deleteCharAt(0);
			String corAnsClean = sb.toString();
			Toast toast = Toast.makeText(mContext, "Die Antwort war falsch!\nRichtige Antworten: " + corAnsClean, Toast.LENGTH_LONG);
			toast.show();
		}
		
		
		long tstamp = new Date().getTime();
		mData.getDbhandler().IncreaseOrDecreaseLevelAndSetNewTimestamp(rightORwrong, mData.getQuestionID(), tstamp);
		mData.getDbhandler().insertEvent(event_name, tstamp, user, cardfile);
		mData.getmActivity().finish();
		mData.getApplicationLogicSelection().startSingleQuestion(mContext);

	}
	
}
