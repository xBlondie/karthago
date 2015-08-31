/**********************************************************************************
 * ----------       LOGIN-ACTIVITY - WRITTEN BY: FRANZISKA PLATE         ----------
 * 
 * Diese Activity hat die Funktion zur Darstellung der Freitext-Fragen der App.
 * 
 * Klassen, mit die diese App kommuniziert sind:
 * 	- Navigation (Get aktuelle QuestioID)
 *  - DatabaseHandler (Einpflegen des richtigen Ereignisses)
 *  - Results (Einholen der Variablen)
 *  - XMLDomParserAndHandler (Auslösen von Events)
 * 
 * Nähere Informationen zu den Methoden siehe im Quellcode!
 * 
 *********************************************************************************/

package de.bg.fhdw.bfwi413a.karthago.activities.lm2_ft;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import de.bg.fhdw.bfwi413a.karthago.Navigation;
import de.bg.fhdw.bfwi413a.karthago.R;
import de.bg.fhdw.bfwi413a.karthago.SessionManagement;
import de.bg.fhdw.bfwi413a.karthago.db.DatabaseHandler;
import de.bg.fhdw.bfwi413a.karthago.xml.Results;
import de.bg.fhdw.bfwi413a.karthago.xml.XMLDomParserAndHandler;

public class Init extends Activity{
	
	//DECLARE NECESSARY OBJECTS
	private Data mData;
	private Gui mGui;
	private ApplicationLogic mApplicationLogic;
	private TextView question;
	private EditText answer;
	private Button commiting;
	private XMLDomParserAndHandler xmlhandler;
	private Results result = new Results();
	private String questionText;
	private ArrayList<String> correctAnswers;
	private String questionID;
	private de.bg.fhdw.bfwi413a.karthago.activities.selection.ApplicationLogic ApplicationLogicSelection;
	private DatabaseHandler dbhandler;
	private String userAnswer;
	private TextView leveltext;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//GET CURRENT QUESTIONID FOR LOADING QUESTION
		questionID = getIntent().getExtras().getString("currentQuestionId");
		
		//INITIALIZE OBJECTS
		initData(savedInstanceState);
		initGui();
		initApplicationLogic();
		initEventToListenerMapping();
		
		//SET LAYOUT
		setContentView(R.layout.activity_lm2_ft);
		 
		//INITIALIZE FURTHER OBJECTS
		xmlhandler = new XMLDomParserAndHandler(getApplicationContext());
		dbhandler = new DatabaseHandler(getApplicationContext());
		ApplicationLogicSelection = new de.bg.fhdw.bfwi413a.karthago.activities.selection.ApplicationLogic();
		SessionManagement session = new SessionManagement(getApplicationContext());
		correctAnswers = new ArrayList<String>();
		
		//GET ALL REQUIRED PARTS (QUESTION AND CORRECT ANSWERS) IN BACKGROUND
		result = xmlhandler.questionAndAnswersForFTAndGQuestions(questionID);
		//FETCH QUESTION-TEXT
		questionText = result.getQuestionForFT();
		//FETCH ALL CORRECT ANSWERS
		correctAnswers = result.getCorrectAnswersForFT();
        
		//GET USER AND CARDFILE-ID
		final String user = session.getUserDetails();
        final String cardfile = session.getCardfileID();
        
        //INITIALIZE GUI-ELEMENTS
        question = (TextView) findViewById(R.id.textview_question_ft);
        leveltext = (TextView) findViewById(R.id.textview_level_ft);
        answer = (EditText) findViewById(R.id.edittext_ft);
        commiting = (Button) findViewById(R.id.btn_send_ft);

        //SET QUESTION-TEXT
        question.setText(questionText);
        
        //SET ACTUAL LEVEL IN DISPLAY
        String textForLevel = new String();
        textForLevel = "Level: " + dbhandler.getCurrentLevelForQuestionId(questionID);
        leveltext.setText(textForLevel);
        
        //SET ONCLICK LISTENER ON BUTTON
        commiting.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//FETCH USERANSWER
				userAnswer = answer.getText().toString();
				//BOOLEAN IF ANSWER WAS RIGHT
				boolean rightORwrong = false;
				//FOR STATISTIK
				String event_name = "incorrect";
				
				for(int i = 0; i < correctAnswers.size(); i++){
					//COMPARE USER ANSWER WITH RIGHT ANSWER
					if(correctAnswers.get(i).toString().equalsIgnoreCase(userAnswer)){
						//IF ONE QUESTION IS RIGHT SET BOOLEAN TRUE
						rightORwrong = true;
						event_name = "correct";
						break;
					}
				}
				
				//IF ANSWER WAS RIGHT
				if(rightORwrong == true){
					//SHOW TOAST
					Toast toast = Toast.makeText(getApplicationContext(), "Die Antwort war richtig!", Toast.LENGTH_LONG);
					toast.show();
				}else{
					//SHOW ALL RIGHT ANSWERS
					String corAns = new String();
					for(int i = 0; i < correctAnswers.size(); i++){
						corAns = corAns + ", " + (correctAnswers.get(i).toString());
					}
					StringBuilder sb = new StringBuilder(corAns);
					sb.deleteCharAt(0);
					String corAnsClean = sb.toString();
					Toast toast = Toast.makeText(getApplicationContext(), "Die Antwort war falsch!\nRichtige Antworten: " + corAnsClean, Toast.LENGTH_LONG);
					toast.show();
				}
				
				//GET NEW TIMESTAMP
				Timestamp tstamp = new Timestamp(new Date().getTime());
				//INCREASE OR DECREASE LEVEL IN DATABASE
				dbhandler.IncreaseOrDecreaseLevelAndSetNewTimestamp(rightORwrong, questionID, tstamp.getTime());
				//UPDATE STATISTIK
				dbhandler.insertEvent(event_name, tstamp.getTime(), user, cardfile);
				//FINISH ACTIVITY AND LOAD NEW QUESTION 
				finish();
				ApplicationLogicSelection.startSingleQuestion(Init.this);
			}
		});
		
		
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}
	
	private void initData(Bundle savedInstanceState) {
		mData = new Data(this, savedInstanceState);
	}
	
	private void initGui() {
		mGui = new Gui(this);
	}
	
	private void initApplicationLogic() {
		mApplicationLogic = new ApplicationLogic(mGui, mData);
	}
	
	private void initEventToListenerMapping() {
		new EventToListenerMapping(mGui, mApplicationLogic);
	}
	
	//ON BACK BUTTON EVENT
	public boolean onKeyDown(int keycode, KeyEvent event){
		  if(keycode==KeyEvent.KEYCODE_BACK){
			  //RETURN TO MENU
		   Navigation.startActivityMenu(mData.getmActivity());
		  }
		 return false;
		 }
	
}
