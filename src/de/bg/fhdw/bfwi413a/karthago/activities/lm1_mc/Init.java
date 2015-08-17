package de.bg.fhdw.bfwi413a.karthago.activities.lm1_mc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

//author: Leonie



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import de.bg.fhdw.bfwi413a.karthago.R;
import de.bg.fhdw.bfwi413a.karthago.db.DatabaseHandler;
import de.bg.fhdw.bfwi413a.karthago.xml.Results;
import de.bg.fhdw.bfwi413a.karthago.xml.XMLDomParserAndHandler;

public class Init extends Activity{
	
	private Data mData;
	private Gui mGui;
	private ApplicationLogic mApplicationLogic;
	
	//@author Patrick
	XMLDomParserAndHandler xmlhandler;
	ArrayList<String> QuestionAndAnswers;
	ArrayList<String> CorrectAnswers;
	Results result = new Results();
	TextView question;
	CheckBox answer1;
	CheckBox answer2;
	CheckBox answer3;
	CheckBox answer4;
	String questionID;
	Button confirm;
	private de.bg.fhdw.bfwi413a.karthago.activities.selection.ApplicationLogic ApplicationLogicSelection;
	private DatabaseHandler dbhandler;
	
	
	
	public void onCreate(Bundle savedInstanceState) {
		//@author Leonie
        super.onCreate(savedInstanceState);
        questionID = getIntent().getExtras().getString("currentQuestionId");
		initData(savedInstanceState);
		initGui();
		initApplicationLogic();
		initEventToListenerMapping();
		//end @author Leonie
		
        setContentView(R.layout.activity_lm1_mc);
        xmlhandler = new XMLDomParserAndHandler(getApplicationContext());
        QuestionAndAnswers = new ArrayList<String>();
        result = xmlhandler.getRequiredQuestionAnswersAndCorrectAnswers(questionID);
        QuestionAndAnswers = result.get_list_Question_and_Answers();
        CorrectAnswers = result.get_list_correct_answers();
        dbhandler = new DatabaseHandler(getApplicationContext());
        ApplicationLogicSelection = new de.bg.fhdw.bfwi413a.karthago.activities.selection.ApplicationLogic();
        
        question = (TextView) findViewById(R.id.question);
		answer1 = (CheckBox) findViewById(R.id.answer1);
		answer2 = (CheckBox) findViewById(R.id.answer2);
		answer3 = (CheckBox) findViewById(R.id.answer3);
		answer4 = (CheckBox) findViewById(R.id.answer4);
		confirm = (Button) findViewById(R.id.confirm);
		
		question.setText(QuestionAndAnswers.get(0).toString());
		answer1.setText(QuestionAndAnswers.get(1).toString());
		answer2.setText(QuestionAndAnswers.get(2).toString());
		answer3.setText(QuestionAndAnswers.get(3).toString());
		answer4.setText(QuestionAndAnswers.get(4).toString());
		
		
		confirm.setOnClickListener(new View.OnClickListener() {
	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Timestamp tstamp = new Timestamp(new Date().getTime());
				dbhandler.IncreaseOrDecreaseLevelAndSetNewTimestamp(false, questionID, tstamp.getTime());
				finish();
				ApplicationLogicSelection.startSingleQuestion(Init.this);
			}
		});
		
		
	}	
	// ---- END @author Patrick ----
	
	
	//@author Leonie 
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
		mApplicationLogic = new ApplicationLogic(mGui, mData, questionID, getApplicationContext());
	}
	
	private void initEventToListenerMapping() {
		new EventToListenerMapping(mGui, mApplicationLogic);
	}
	//@end author Leonie

}
