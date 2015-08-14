package de.bg.fhdw.bfwi413a.karthago.activities.lm1_mc;

import java.util.ArrayList;

//author: Leonie

import android.app.Activity;
import android.os.Bundle;
import de.bg.fhdw.bfwi413a.karthago.R;
import de.bg.fhdw.bfwi413a.karthago.xml.XMLDomParserAndHandler;

public class Init extends Activity{
	//@author Patrick
	XMLDomParserAndHandler xmlhandler;
	ArrayList<String> QuestionAndAnswers;
	
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lm1_mc);
        xmlhandler = new XMLDomParserAndHandler(getApplicationContext());
        String questionID = getIntent().getExtras().getString("currentQuestionId");
        QuestionAndAnswers = new ArrayList<String>();
        QuestionAndAnswers = xmlhandler.getRequiredQuestionAnswersAndCorrectAnswers(questionID);
        System.out.println(QuestionAndAnswers.get(0).toString());
	}
	
	
	// ---- END @author Patrick ----
}
