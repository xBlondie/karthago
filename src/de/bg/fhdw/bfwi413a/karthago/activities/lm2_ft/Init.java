//Patrick
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
import de.bg.fhdw.bfwi413a.karthago.db.DatabaseHandler;
import de.bg.fhdw.bfwi413a.karthago.xml.Results;
import de.bg.fhdw.bfwi413a.karthago.xml.XMLDomParserAndHandler;

public class Init extends Activity{
	
	private Data mData;
	private Gui mGui;
	private ApplicationLogic mApplicationLogic;
	TextView question;
	TextView leveltext;
	EditText answer;
	Button commiting;
	XMLDomParserAndHandler xmlhandler;
	Results result = new Results();
	String questionText;
	ArrayList<String> correctAnswers;
	String questionID;
	private de.bg.fhdw.bfwi413a.karthago.activities.selection.ApplicationLogic ApplicationLogicSelection;
	private DatabaseHandler dbhandler;
	String userAnswer;
	
	
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
        leveltext = (TextView) findViewById(R.id.textview_level_ft);
        answer = (EditText) findViewById(R.id.edittext_ft);
        commiting = (Button) findViewById(R.id.btn_send_ft);

        question.setText(questionText);
        String textForLevel = new String();
        textForLevel = "Level: " + dbhandler.getCurrentLevelForQuestionId(questionID);
        leveltext.setText(textForLevel);
        
        commiting.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				userAnswer = answer.getText().toString().toLowerCase();
				boolean rightORwrong = false;
				
				for(int i = 0; i < correctAnswers.size(); i++){
					if(correctAnswers.get(i).toString().toLowerCase().equals(userAnswer)){
						rightORwrong = true;
					}
				}
				
				if(rightORwrong == true){
					Toast toast = Toast.makeText(getApplicationContext(), "Die Antwort war richtig!", Toast.LENGTH_LONG);
					toast.show();
				}else{
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
