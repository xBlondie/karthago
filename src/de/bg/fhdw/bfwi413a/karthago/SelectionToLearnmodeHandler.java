//@author Patrick
package de.bg.fhdw.bfwi413a.karthago;

import java.util.ArrayList;

import android.content.Context;
import de.bg.fhdw.bfwi413a.karthago.db.DatabaseHandler;

public class SelectionToLearnmodeHandler {

	ArrayList<String> requiredIDs;
	String answer_type;
	DatabaseHandler dbhandler;
	
	public SelectionToLearnmodeHandler(ArrayList<String> requiredIDs, Context context){
		this.requiredIDs = requiredIDs;
		dbhandler = new DatabaseHandler(context);
		LoopOverQuestionForQuestion(this.requiredIDs);
	}
	
	public void LoopOverQuestionForQuestion(ArrayList<String> questionIDs){
		for(int i = 0; i < questionIDs.size(); i++){
			answer_type = getAnswerType(questionIDs.get(i).toString());
			if(answer_type.equals("MC")){
				//SPRINGE IN DIE MC-ACTIVITY UND ÜBERGIB DABEI DIE QUESTION_ID
			}else if(answer_type.equals("FT")){
				//SPRINGE IN DIE FT-ACTIVITY UND ÜBERGIB DABEI DIE QUESTION_ID
			}
		}
	}

	private String getAnswerType(String questionID) {
		
		return dbhandler.getAnswerTypeForCertainQuestionID(questionID);
	}
	
}
