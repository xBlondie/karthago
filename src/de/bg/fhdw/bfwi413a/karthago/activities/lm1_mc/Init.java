package de.bg.fhdw.bfwi413a.karthago.activities.lm1_mc;

import java.util.ArrayList;

//author: Leonie



import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import de.bg.fhdw.bfwi413a.karthago.Navigation;
import de.bg.fhdw.bfwi413a.karthago.R;
import de.bg.fhdw.bfwi413a.karthago.activities.lm3_g.ApplicationLogic;
import de.bg.fhdw.bfwi413a.karthago.activities.lm3_g.Data;
import de.bg.fhdw.bfwi413a.karthago.activities.lm3_g.EventToListenerMapping;
import de.bg.fhdw.bfwi413a.karthago.activities.lm3_g.Gui;
import de.bg.fhdw.bfwi413a.karthago.xml.Results;
import de.bg.fhdw.bfwi413a.karthago.xml.XMLDomParserAndHandler;
import de.bg.fhdw.bfwi413a.karthago.activities.lm1_mc.Data;

public class Init extends Activity{
	
	private Data mData;
	private Gui mGui;
	private ApplicationLogic mApplicationLogic;
	
	//@author Patrick
	XMLDomParserAndHandler xmlhandler;
	ArrayList<String> QuestionAndAnswers;
	ArrayList<String> CorrectAnswers;
	Results result = new Results();
	
	
	public void onCreate(Bundle savedInstanceState) {
		//@author Leonie
        super.onCreate(savedInstanceState);
		initData(savedInstanceState);
		initGui();
		initApplicationLogic();
		initEventToListenerMapping();
		//end @author Leonie
		
        setContentView(R.layout.activity_lm1_mc);
        xmlhandler = new XMLDomParserAndHandler(getApplicationContext());
        String questionID = getIntent().getExtras().getString("currentQuestionId");
        QuestionAndAnswers = new ArrayList<String>();
        result = xmlhandler.getRequiredQuestionAnswersAndCorrectAnswers(questionID);
        QuestionAndAnswers = result.get_list_Question_and_Answers();
        CorrectAnswers = result.get_list_correct_answers();
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
		mApplicationLogic = new ApplicationLogic(mGui, mData);
	}
	
	private void initEventToListenerMapping() {
		new EventToListenerMapping(mGui, mApplicationLogic);
	}
	//@end author Leonie

}
