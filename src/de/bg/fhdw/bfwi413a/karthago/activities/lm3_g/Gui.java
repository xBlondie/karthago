/**********************************************************************************
 * ----------       GUI-CLASS (LM3)- WRITTEN BY: LEONIE SCHIBURR       ------------
 *********************************************************************************/

/**
 * The Gui Class implements the gui elements (TextView, Buttons, ...) for the activity
 * and initializes them with the ids of the views and widgets from the layout.
 * 
 * It also provides getters and setters to get the gui elements and set there content to
 * the different questions.
 * 
 * Methods and Variables are commented in the Code.
 * 
 *  */

package de.bg.fhdw.bfwi413a.karthago.activities.lm3_g;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import de.bg.fhdw.bfwi413a.karthago.R;

public class Gui {
	
	TextView question;
	TextView leveltext;
	Button confirm;
	
	public Gui(Activity activity){
		activity.setContentView(R.layout.activity_lm3_g);
		this.question = (TextView) activity.findViewById(R.id.textview_question_g);
		this.leveltext = (TextView) activity.findViewById(R.id.textview_level_g);
		this.confirm = (Button) activity.findViewById(R.id.btn_show_g);
	}

	public TextView getQuestion() {
		return question;
	}

	public void setQuestion(String text) {
		question.setText(text);
	}
	
	public TextView getLeveltext (){
		return leveltext;
	}
	
	public void setLeveltext (String text){
		leveltext.setText(text);
	}

	public Button getConfirm() {
		return confirm;
	}

	public void setConfirm(String text) {
		confirm.setText(text);
	}
	
}
