package de.bg.fhdw.bfwi413a.karthago.activities.lm1_mc;

import java.util.ArrayList;

//author: Leonie

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import de.bg.fhdw.bfwi413a.karthago.Navigation;
import de.bg.fhdw.bfwi413a.karthago.R;
import de.bg.fhdw.bfwi413a.karthago.xml.Results;
import de.bg.fhdw.bfwi413a.karthago.xml.XMLDomParserAndHandler;
import de.bg.fhdw.bfwi413a.karthago.activities.lm1_mc.Data;

public class Init extends Activity{
	//@author Patrick
	XMLDomParserAndHandler xmlhandler;
	ArrayList<String> QuestionAndAnswers;
	ArrayList<String> CorrectAnswers;
	Results result = new Results();
	
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lm1_mc);
        xmlhandler = new XMLDomParserAndHandler(getApplicationContext());
        String questionID = getIntent().getExtras().getString("currentQuestionId");
        QuestionAndAnswers = new ArrayList<String>();
        result = xmlhandler.getRequiredQuestionAnswersAndCorrectAnswers(questionID);
        QuestionAndAnswers = result.get_list_Question_and_Answers();
        CorrectAnswers = result.get_list_correct_answers();
        System.out.println(QuestionAndAnswers.get(0).toString());
        System.out.println(CorrectAnswers.get(0).toString());
	}
	
	
	// ---- END @author Patrick ----

}
