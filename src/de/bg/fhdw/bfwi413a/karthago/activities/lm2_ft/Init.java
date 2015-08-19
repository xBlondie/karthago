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
import java.util.Locale;

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
import de.bg.fhdw.bfwi413a.karthago.db.DatabaseHandler;
import de.bg.fhdw.bfwi413a.karthago.xml.Results;
import de.bg.fhdw.bfwi413a.karthago.xml.XMLDomParserAndHandler;

public class Init extends Activity{
	
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
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		questionID = getIntent().getExtras().getString("currentQuestionId");
		initData(savedInstanceState);
		initGui();
		initApplicationLogic();
		initEventToListenerMapping();
		
		setContentView(R.layout.activity_lm2_ft);
		 
		
		xmlhandler = new XMLDomParserAndHandler(getApplicationContext());
		correctAnswers = new ArrayList<String>();
		result = xmlhandler.questionAndAnswersForFTAndGQuestions(questionID);
		questionText = result.getQuestionForFT();
		correctAnswers = result.getCorrectAnswersForFT();
		dbhandler = new DatabaseHandler(getApplicationContext());
        ApplicationLogicSelection = new de.bg.fhdw.bfwi413a.karthago.activities.selection.ApplicationLogic();
        
        question = (TextView) findViewById(R.id.textview_question_ft);
        answer = (EditText) findViewById(R.id.edittext_ft);
        commiting = (Button) findViewById(R.id.btn_send_ft);

        question.setText(questionText);
        
        commiting.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				userAnswer = answer.getText().toString();
				boolean rightORwrong = false;
				
				for(int i = 0; i < correctAnswers.size(); i++){
					if(correctAnswers.get(i).toString().equalsIgnoreCase(userAnswer)){
						rightORwrong = true;
						break;
					}
				}
				
				if(rightORwrong == true){
					Toast toast = Toast.makeText(getApplicationContext(), "Die Antwort war richtig!", Toast.LENGTH_LONG);
					toast.show();
				}else{
					Toast toast = Toast.makeText(getApplicationContext(), "Die Antwort war falsch!", Toast.LENGTH_LONG);
					toast.show();
				}
				
				
				Timestamp tstamp = new Timestamp(new Date().getTime());
				dbhandler.IncreaseOrDecreaseLevelAndSetNewTimestamp(rightORwrong, questionID, tstamp.getTime());
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
	
	public boolean onKeyDown(int keycode, KeyEvent event){
		  if(keycode==KeyEvent.KEYCODE_BACK){
		   Navigation.startActivityMenu(mData.getmActivity());
		  }
		 return false;
		 }
	
}
