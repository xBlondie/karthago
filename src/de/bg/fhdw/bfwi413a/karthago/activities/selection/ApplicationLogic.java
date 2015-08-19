// Die ApplicationLogic verwaltet, was passiert, wenn man die Buttons benutzt

package de.bg.fhdw.bfwi413a.karthago.activities.selection;

import java.sql.Timestamp;
import java.util.Date;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import de.bg.fhdw.bfwi413a.karthago.SessionManagement;
import de.bg.fhdw.bfwi413a.karthago.db.DatabaseHandler;

public class ApplicationLogic {
	
	//DECLARE NECESSARY VARIABLES
	private Gui mGui;
	private Data mData;
	
	private DatabaseHandler dbhandler;
	private Timestamp tstamp;
	private SessionManagement session;
	private String requiredID;
	private Context mContext;
	private String answer_type;
	
	
	public ApplicationLogic(Gui gui, Data data, Context context) {
		//INITIALIZE COMPONENTS
		mGui = gui;
		mData = data;
		initDataToGui();
		dbhandler = new DatabaseHandler(context);
		session = new SessionManagement(context);
		requiredID = new String();
		mContext = context;
		
	}
	
	public ApplicationLogic() {
		// TODO Auto-generated constructor stub
	}
	
	private void initDataToGui() {
	
	}


	public void onButtonClicked(int i) {
		switch ( i ) {
		case 1:
			//DECLARE THE NAME OF THE CARDFILE
			String cardfile_id1 = "Allgemeinwissen";
			//WRITE THE CARDFILENAME IN THE SESSION; IMPORTANT FOR METHOD BELOW
			session.writeCardfileID(cardfile_id1);
			//START THE QUESTION
			startSingleQuestion(mContext);
			break;
		case 2:
			//DECLARE THE NAME OF THE CARDFILE
			String cardfile_id2 = "Fitness";
			//WRITE THE CARDFILENAME IN THE SESSION; IMPORTANT FOR METHOD BELOW
			session.writeCardfileID(cardfile_id2);
			//START THE QUESTION
			startSingleQuestion(mContext);
			break;
		case 3:   
			//DECLARE THE NAME OF THE CARDFILE
			String cardfile_id3 = "Musik";
			//WRITE THE CARDFILENAME IN THE SESSION; IMPORTANT FOR METHOD BELOW
			session.writeCardfileID(cardfile_id3);
			//START THE QUESTION
			startSingleQuestion(mContext);
			break;
		case 4:   
			//DECLARE THE NAME OF THE CARDFILE
			String cardfile_id4 = "Architektur";
			//WRITE THE CARDFILENAME IN THE SESSION; IMPORTANT FOR METHOD BELOW
			session.writeCardfileID(cardfile_id4);
			//START THE QUESTION
			startSingleQuestion(mContext);
			break;
		case 5:   
			//DECLARE THE NAME OF THE CARDFILE
			String cardfile_id5 = "Filme";
			//WRITE THE CARDFILENAME IN THE SESSION; IMPORTANT FOR METHOD BELOW
			session.writeCardfileID(cardfile_id5);
			//START THE QUESTION
			startSingleQuestion(mContext);
			break;
		case 6:   
			//DECLARE THE NAME OF THE CARDFILE
			String cardfile_id6 = "Kunst";
			//WRITE THE CARDFILENAME IN THE SESSION; IMPORTANT FOR METHOD BELOW
			session.writeCardfileID(cardfile_id6);
			//START THE QUESTION
			startSingleQuestion(mContext);
			break;
		case 7:   
			//DECLARE THE NAME OF THE CARDFILE
			String cardfile_id7 = "Geschichte";
			//WRITE THE CARDFILENAME IN THE SESSION; IMPORTANT FOR METHOD BELOW
			session.writeCardfileID(cardfile_id7);
			//START THE QUESTION
			startSingleQuestion(mContext);
			break;
		case 8:   
			//DECLARE THE NAME OF THE CARDFILE
			String cardfile_id8 = "Fotografie";
			//WRITE THE CARDFILENAME IN THE SESSION; IMPORTANT FOR METHOD BELOW
			session.writeCardfileID(cardfile_id8);
			//START THE QUESTION
			startSingleQuestion(mContext);
			break;
		}
	}
	
	public void startSingleQuestion(Context context){ //DIESE FUNKTION MUSS IMMER FÜR DIE NÄCHSTE FRAGE AUFGERUFEN WERDEN!!!
		//DECLARE AND INITIALIZE IMPORTANT VARIABLES
		tstamp = new Timestamp(new Date().getTime());
		session = new SessionManagement(context);
		dbhandler = new DatabaseHandler(context);
		String cardfile_id = session.getCardfileID();
		//GET THE NEXT QUESTION
		requiredID = dbhandler.getRequiredQuestionIDs(tstamp.getTime(), cardfile_id, session.getUserDetails().toString());
		//CHECK IF A ANSWER HAS TO BE ANSWERED
		if(requiredID.equals("")){
		//IF NOT
		Toast toast = Toast.makeText(context, "Es müssen keine weiteren Fragen bearbeitet werden!", Toast.LENGTH_LONG);
		toast.show();
		Intent nextScreen = new Intent(context, de.bg.fhdw.bfwi413a.karthago.activities.selection.Init.class);
        nextScreen.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(nextScreen);
		}else{
			//IF A QUESTION HAST TO BE ANSWERED
			//GET ANSWERTYPE OF QUESTION
			answer_type = dbhandler.getAnswerTypeForCertainQuestionID(requiredID);
			//DECIDING OF WHICH ANSWERTYPE START THE ACTIVITY AND 
			if(answer_type.equals("MC")){
				//CREATE INTENT
				Intent nextScreen = new Intent(context, de.bg.fhdw.bfwi413a.karthago.activities.lm1_mc.Init.class);
				//SET FLAG BECAUSE CLASS IS NO ACTIVITY
				nextScreen.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				//PUT DATA TO INTENT
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

}
