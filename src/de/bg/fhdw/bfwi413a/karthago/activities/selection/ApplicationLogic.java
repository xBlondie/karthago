// Die ApplicationLogic verwaltet, was passiert, wenn man die Buttons benutzt

package de.bg.fhdw.bfwi413a.karthago.activities.selection;

import java.sql.Timestamp;
import java.util.Date;

import android.content.Context;
import android.content.Intent;
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
	String requiredID;
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
		requiredID = new String();
		mContext = context;
		
	}
	
	public ApplicationLogic() {
		// TODO Auto-generated constructor stub
	}
	
	// ---- END @author Patrick ----
	
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
			String cardfile_id = "Allgemeinwissen";
			session.writeCardfileID(cardfile_id);
			startSingleQuestion(mContext);
//			for(int j = 0; j < requiredIDs.size(); j++){
//				answer_type = dbhandler.getAnswerTypeForCertainQuestionID(requiredIDs.get(j).toString());
//				if(answer_type.equals("MC")){
//				System.out.println(requiredIDs.get(j).toString());
//				Navigation.startActivityLM1_MC(mData.getmActivity(), requiredIDs.get(j).toString());
//				continue;}
//				if(answer_type.equals("FT")){
//				Navigation.startActivityLM2_FT(mData.getmActivity(), requiredIDs.get(j).toString());
//				continue;}
//				if(answer_type.equals("G")){
//				Navigation.startActivityLM3_G(mData.getmActivity(), requiredIDs.get(j).toString());
//				continue;}
//			}
			// ---- END @author Patrick ----
			
			break;
		case 2:   // Call CardFile2
			//Navigation.startActivityLMode(CardFileID);
			//@author Patrick
			
//			requiredIDs = dbhandler.getRequiredQuestionIDs(tstamp.getTime(), "Fitness", session.getUserDetails().toString());
			
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
//			requiredIDs = dbhandler.getRequiredQuestionIDs(tstamp.getTime(), "Musik", session.getUserDetails().toString());
			
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
//			requiredIDs = dbhandler.getRequiredQuestionIDs(tstamp.getTime(), "Architektur", session.getUserDetails().toString());
			
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
//			requiredIDs = dbhandler.getRequiredQuestionIDs(tstamp.getTime(), "Filme", session.getUserDetails().toString());
			
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
//			requiredIDs = dbhandler.getRequiredQuestionIDs(tstamp.getTime(), "Kunst", session.getUserDetails().toString());
			
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
//			requiredIDs = dbhandler.getRequiredQuestionIDs(tstamp.getTime(), "Geschichte", session.getUserDetails().toString());
			
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
	
	public void startSingleQuestion(Context context){ //DIESE FUNKTION MUSS IMMER FÜR DIE NÄCHSTE FRAGE AUFGERUFEN WERDEN!!!
		tstamp = new Timestamp(new Date().getTime());
		session = new SessionManagement(context);
		dbhandler = new DatabaseHandler(context);
		String cardfile_id = session.getCardfileID();
		requiredID = dbhandler.getRequiredQuestionIDs(tstamp.getTime(), cardfile_id, session.getUserDetails().toString());
		answer_type = dbhandler.getAnswerTypeForCertainQuestionID(requiredID);
		if(answer_type.equals("MC")){
		Intent nextScreen = new Intent(context, de.bg.fhdw.bfwi413a.karthago.activities.lm1_mc.Init.class);
        nextScreen.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		//Intent mit den Daten füllen
        nextScreen.putExtra("currentQuestionId", requiredID);
        context.startActivity(nextScreen);
		}
		else if(answer_type.equals("FT")){
		Intent nextScreen = new Intent(context, de.bg.fhdw.bfwi413a.karthago.activities.lm2_ft.Init.class);
        nextScreen.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		//Intent mit den Daten füllen
        nextScreen.putExtra("currentQuestionId", requiredID);
        context.startActivity(nextScreen);
		}
		else if(answer_type.equals("G")){
		Intent nextScreen = new Intent(context, de.bg.fhdw.bfwi413a.karthago.activities.lm3_g.Init.class);
        nextScreen.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		//Intent mit den Daten füllen
        nextScreen.putExtra("currentQuestionId", requiredID);
        context.startActivity(nextScreen);
		}
	}

}
