/**********************************************************************************
 * ----------       GUI-CLASS (LM3)- WRITTEN BY: LEONIE SCHIBURR       ------------
 *********************************************************************************/

/**
 * The Gui Class declares variables for the gui elements (TextView, Buttons, ...) for the activity
 * and initializes them with the IDs of the views and widgets implemented in the layout.
 * 
 * It also provides getters and setters to get the gui elements and to set their content to
 * the different questions.
 * 
 * Methods and Variables are commented in the Code.
 * 
 *  */

package de.bg.fhdw.bfwi413a.karthago.activities.lm3_g;

//IMPORTS FOR NECESSARY CLASSES AND PACKAGES
import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import de.bg.fhdw.bfwi413a.karthago.R;

public class Gui {
	
	//DECLARE GUI-ELEMENTS
	TextView question;
	TextView leveltext;
	Button confirm;
	
	//CONSTRUCTOR
	public Gui(Activity activity){
		//ASSIGN LAYOUT TO ACTIVITY
		activity.setContentView(R.layout.activity_lm3_g);
		//INITIALIZE GUI ELEMENTS
		this.question = (TextView) activity.findViewById(R.id.textview_question_g);
		this.leveltext = (TextView) activity.findViewById(R.id.textview_level_g);
		this.confirm = (Button) activity.findViewById(R.id.btn_show_g);
	}
	
	//GETTERS AND SETTERS FOR GUI ELEMENTS

	public TextView getQuestion() {
		return question;
	}

	//The setter changes not the Object itself, but just the Text (Question text from XML) 
	public void setQuestion(String text) {
		question.setText(text);
	}
	
	public TextView getLeveltext (){
		return leveltext;
	}
	
	//The setter changes not the Object itself, but just the Text (Question text from XML) 
	public void setLeveltext (String text){
		leveltext.setText(text);
	}

	public Button getConfirm() {
		return confirm;
	}

	//The setter changes not the Object itself, but just the Text (Question text from XML) 
	public void setConfirm(String text) {
		confirm.setText(text);
	}
	
}
