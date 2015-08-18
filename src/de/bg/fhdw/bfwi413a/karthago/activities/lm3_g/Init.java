//Leonie
package de.bg.fhdw.bfwi413a.karthago.activities.lm3_g;

import java.sql.Timestamp;

//author: Leonie

import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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
	Button confirm;
	
	XMLDomParserAndHandler xmlhandler;
	Results result = new Results();
	String questionText;
	ArrayList<String> correctAnswers;
	String questionID;
	private de.bg.fhdw.bfwi413a.karthago.activities.selection.ApplicationLogic ApplicationLogicSelection;
	private DatabaseHandler dbhandler;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lm3_g);
		questionID = getIntent().getExtras().getString("currentQuestionId");
		initData(savedInstanceState);
		initGui();
		initApplicationLogic();
		initEventToListenerMapping();
		
		xmlhandler = new XMLDomParserAndHandler(getApplicationContext());
		correctAnswers = new ArrayList<String>();
		result = xmlhandler.questionAndAnswersForFTAndGQuestions(questionID);
		questionText = result.getQuestionForFT();
		correctAnswers = result.getCorrectAnswersForFT();
		dbhandler = new DatabaseHandler(getApplicationContext());
        ApplicationLogicSelection = new de.bg.fhdw.bfwi413a.karthago.activities.selection.ApplicationLogic();
		
		question = (TextView) findViewById(R.id.textview_question_g);
		confirm = (Button) findViewById(R.id.btn_show_g);
		
		question.setText(questionText);
		
		confirm.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				AlertDialog.Builder builder = new AlertDialog.Builder(Init.this);
				builder.setTitle("Lösung");
				TextView corAns = new TextView(Init.this);
				for(int i = 0; i < correctAnswers.size(); i++){
					corAns.append(correctAnswers.get(i).toString());
				}
				corAns.setGravity(Gravity.CENTER_HORIZONTAL);
				builder.setView(corAns);
				// Add the buttons
				builder.setPositiveButton("Habs gewusst!", new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			        	boolean rightORwrong;
			        	Timestamp tstamp = new Timestamp(new Date().getTime());
			        	rightORwrong = true;
						dbhandler.IncreaseOrDecreaseLevelAndSetNewTimestamp(rightORwrong, questionID, tstamp.getTime());
						dialog.cancel();
						finish();
						ApplicationLogicSelection.startSingleQuestion(Init.this);
			           }
			       });
				builder.setNegativeButton("Falsche Antwort!", new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			        	   boolean rightORwrong;
				        	Timestamp tstamp = new Timestamp(new Date().getTime());
				        	rightORwrong = false;
							dbhandler.IncreaseOrDecreaseLevelAndSetNewTimestamp(rightORwrong, questionID, tstamp.getTime());
							dialog.cancel();
							finish();
							ApplicationLogicSelection.startSingleQuestion(Init.this);
			           }
			       });
				
				// Create the AlertDialog
				builder.show();
				
			}
		});
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}
	
	private void initData(Bundle savedInstanceState) {
		mData = new Data(this, savedInstanceState, Init.this);
	}
	
	private void initGui() {
		mGui = new Gui(this);
	}
	
	private void initApplicationLogic() {
		mApplicationLogic = new ApplicationLogic(mGui, mData, Init.this);
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
