package de.bg.fhdw.bfwi413a.karthago.activities.lm2_ft;

import java.util.Date;

import android.content.Context;
import android.widget.Toast;

public class ApplicationLogic {
	
	private Gui mGui;
	private Data mData;
	private String user;
    private String cardfile;
    private String userAnswer;
    private Context mContext;
	
	public ApplicationLogic(Gui gui, Data data, Context context) {
		mGui = gui;
		mData = data;
		mContext = context;
		initDataToGui();
	}
	
	private void initDataToGui() {
		//Init Data from XML to TextView and Button
		mGui.setQuestion(mData.getQuestionText());
	    String textForLevel = new String();
	    textForLevel = "Level: " + mData.getDbhandler().getCurrentLevelForQuestionId(mData.getQuestionID());
	    mGui.setLeveltext(textForLevel);
	    user = mData.getSession().getUserDetails();
	    cardfile = mData.getSession().getCardfileID();
	}


	public void onButtonClicked() {
		//Logic for Answers
		userAnswer = mGui.getAnswer().getText().toString();
		boolean rightORwrong = false;
		String event_name = "incorrect";
		
		for(int i = 0; i < mData.getCorrectAnswers().size(); i++){
			if(mData.getCorrectAnswers().get(i).toString().equalsIgnoreCase(userAnswer)){
				rightORwrong = true;
				event_name = "correct";
				break;
			}
		}
		
		if(rightORwrong == true){
			Toast toast = Toast.makeText(mContext, "Die Antwort war richtig!", Toast.LENGTH_LONG);
			toast.show();
		}else{
			String corAns = new String();
			for(int i = 0; i < mData.getCorrectAnswers().size(); i++){
				corAns = corAns + ", " + (mData.getCorrectAnswers().get(i).toString());
			}
			StringBuilder sb = new StringBuilder(corAns);
			sb.deleteCharAt(0);
			String corAnsClean = sb.toString();
			Toast toast = Toast.makeText(mContext, "Die Antwort war falsch!\nRichtige Antworten: " + corAnsClean, Toast.LENGTH_LONG);
			toast.show();
		}
		
		
		long tstamp = new Date().getTime();
		mData.getDbhandler().IncreaseOrDecreaseLevelAndSetNewTimestamp(rightORwrong, mData.getQuestionID(), tstamp);
		//For statistics
		mData.getDbhandler().insertEvent(event_name, tstamp, user, cardfile);
		mData.getmActivity().finish();
		mData.getApplicationLogicSelection().startSingleQuestion(mContext);
	}

}
