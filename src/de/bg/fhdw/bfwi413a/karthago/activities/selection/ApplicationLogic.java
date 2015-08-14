// Die ApplicationLogic verwaltet, was passiert, wenn man die Buttons benutzt

package de.bg.fhdw.bfwi413a.karthago.activities.selection;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import android.content.Context;
import de.bg.fhdw.bfwi413a.karthago.Navigation;
import de.bg.fhdw.bfwi413a.karthago.SessionManagement;
import de.bg.fhdw.bfwi413a.karthago.db.DatabaseHandler;

public class ApplicationLogic {
	
	private Gui mGui;
	private Data mData;
	
	//@author Patrick
	private DatabaseHandler dbhandler;
	private Timestamp tstamp;
	private SessionManagement session;
	ArrayList<String> requiredIDs;
	Context mContext;
	String answer_type;
	// ---- END @author Patrick
	
	public ApplicationLogic(Gui gui, Data data, Context context) {
		mGui = gui;
		mData = data;
		initDataToGui();
		//@auhtior Patrick
		dbhandler = new DatabaseHandler(context);
		session = new SessionManagement(context);
		requiredIDs = new ArrayList<String>();
		mContext = context;
		// ---- END @author Patrick ----
	}
	
	private void initDataToGui() {
		String text;
		
		// init buttons
		
//		text = challenge.getAnswer1Text();
//		mGui.setTextInButtonAnswer1Text(text);
		
	}


	public void onButtonClicked(int i) {
		switch ( i ) {
		case 1:   // Call CardFile1
			//@author Patrick
			tstamp = new Timestamp(new Date().getTime());
			requiredIDs = dbhandler.getRequiredQuestionIDs(tstamp.getTime(), "Allgemeinwissen", session.getUserDetails().toString());
			for(int j = 0; j < requiredIDs.size(); j++){
				answer_type = dbhandler.getAnswerTypeForCertainQuestionID(requiredIDs.get(j).toString());
				if(answer_type.equals("MC")){
				Navigation.startActivityLM1_MC(mData.getmActivity(), requiredIDs.get(j).toString());}
				if(answer_type.equals("FT")){
				Navigation.startActivityLM2_FT(mData.getmActivity(), requiredIDs.get(j).toString());}
				if(answer_type.equals("G")){
				Navigation.startActivityLM3_G(mData.getmActivity(), requiredIDs.get(j).toString());}
			}
			// ---- END @author Patrick ----
			
			break;
		case 2:   // Call CardFile2
			//Navigation.startActivityLMode(CardFileID);
			//@author Patrick
			tstamp = new Timestamp(new Date().getTime());
			requiredIDs = dbhandler.getRequiredQuestionIDs(tstamp.getTime(), "Fitness", session.getUserDetails().toString());
			
			// ---- END @author Patrick ----
			//if(answertype = "MC"){
			//Navigation.startActivityLM1_MC(mData.getmActivity(), questionId);}
			//if(answertype = "FT"){
			//Navigation.startActivityLM2_FT(mData.getmActivity(), questionId);}
			//if(answertype = "G"){
			//Navigation.startActivityLM3_G(mData.getmActivity(), questionId);}
			break;
		case 3:   // Call CardFile3
			//Navigation.startActivityLMode(CardFileID);
			//@author Patrick
			tstamp = new Timestamp(new Date().getTime());
			requiredIDs = dbhandler.getRequiredQuestionIDs(tstamp.getTime(), "Musik", session.getUserDetails().toString());
			
			// ---- END @author Patrick ----
			//if(answertype = "MC"){
			//Navigation.startActivityLM1_MC(mData.getmActivity(), questionId);}
			//if(answertype = "FT"){
			//Navigation.startActivityLM2_FT(mData.getmActivity(), questionId);}
			//if(answertype = "G"){
			//Navigation.startActivityLM3_G(mData.getmActivity(), questionId);}
			break;
		case 4:   // Call CardFile4
			//Navigation.startActivityLMode(CardFileID);
			//@author Patrick
			tstamp = new Timestamp(new Date().getTime());
			requiredIDs = dbhandler.getRequiredQuestionIDs(tstamp.getTime(), "Architektur", session.getUserDetails().toString());
			
			// ---- END @author Patrick ----
			//if(answertype = "MC"){
			//Navigation.startActivityLM1_MC(mData.getmActivity(), questionId);}
			//if(answertype = "FT"){
			//Navigation.startActivityLM2_FT(mData.getmActivity(), questionId);}
			//if(answertype = "G"){
			//Navigation.startActivityLM3_G(mData.getmActivity(), questionId);}
			break;
		case 5:   // Call CardFile5
			//Navigation.startActivityLMode(CardFileID);
			//@author Patrick
			tstamp = new Timestamp(new Date().getTime());
			requiredIDs = dbhandler.getRequiredQuestionIDs(tstamp.getTime(), "Filme", session.getUserDetails().toString());
			
			// ---- END @author Patrick ----
			//if(answertype = "MC"){
			//Navigation.startActivityLM1_MC(mData.getmActivity(), questionId);}
			//if(answertype = "FT"){
			//Navigation.startActivityLM2_FT(mData.getmActivity(), questionId);}
			//if(answertype = "G"){
			//Navigation.startActivityLM3_G(mData.getmActivity(), questionId);}
			break;
		case 6:   // Call CardFile6
			//Navigation.startActivityLMode(CardFileID);
			//@author Patrick
			tstamp = new Timestamp(new Date().getTime());
			requiredIDs = dbhandler.getRequiredQuestionIDs(tstamp.getTime(), "Kunst", session.getUserDetails().toString());
			
			// ---- END @author Patrick ----
			//if(answertype = "MC"){
			//Navigation.startActivityLM1_MC(mData.getmActivity(), questionId);}
			//if(answertype = "FT"){
			//Navigation.startActivityLM2_FT(mData.getmActivity(), questionId);}
			//if(answertype = "G"){
			//Navigation.startActivityLM3_G(mData.getmActivity(), questionId);}
			break;
		case 7:   // Call CardFile7
			//Navigation.startActivityLMode(CardFileID);
			//@author Patrick
			tstamp = new Timestamp(new Date().getTime());
			requiredIDs = dbhandler.getRequiredQuestionIDs(tstamp.getTime(), "Geschichte", session.getUserDetails().toString());
			
			// ---- END @author Patrick ----
			//if(answertype = "MC"){
			//Navigation.startActivityLM1_MC(mData.getmActivity(), questionId);}
			//if(answertype = "FT"){
			//Navigation.startActivityLM2_FT(mData.getmActivity(), questionId);}
			//if(answertype = "G"){
			//Navigation.startActivityLM3_G(mData.getmActivity(), questionId);}
			break;
		case 8:   // Call CardFile8
			//Navigation.startActivityLMode(CardFileID);
			//@author Patrick
			//tstamp = new Timestamp(new Date().getTime());
			//requiredIDs = dbhandler.getRequiredQuestionIDs(tstamp.getTime(), "Fotografie", session.getUserDetails().toString());
			//new SelectionToLearnmodeHandler(requiredIDs, mContext);
			// ---- END @author Patrick ----
			//if(answertype = "MC"){
			//Navigation.startActivityLM1_MC(mData.getmActivity(), questionId);}
			//if(answertype = "FT"){
			//Navigation.startActivityLM2_FT(mData.getmActivity(), questionId);}
			//if(answertype = "G"){
			//Navigation.startActivityLM3_G(mData.getmActivity(), questionId);}
			break;
		}
	}

}
