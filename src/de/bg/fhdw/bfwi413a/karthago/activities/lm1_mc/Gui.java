/**********************************************************************************
 * ----------       GUI-CLASS (LM1)- WRITTEN BY: LEONIE SCHIBURR       ------------
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

package de.bg.fhdw.bfwi413a.karthago.activities.lm1_mc;

//IMPORTS FOR NECESSARY CLASSES AND PACKAGES
import android.app.Activity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import de.bg.fhdw.bfwi413a.karthago.R;


public class Gui {
	
	//DECLARE GUI-ELEMENTS
	TextView question;
	TextView leveltext;
	CheckBox answer1;
	CheckBox answer2;
	CheckBox answer3;
	CheckBox answer4;
	Button confirm;
	
	//CONSTRUCTOR
	public Gui(Activity activity){
		//ASSIGN LAYOUT TO ACTIVITY
		activity.setContentView(R.layout.activity_lm1_mc);
		//INITIALIZE GUI ELEMENTS
		this.question = (TextView) activity.findViewById(R.id.question);
        this.leveltext = (TextView) activity.findViewById(R.id.textview_level_mc);
		this.answer1 = (CheckBox) activity.findViewById(R.id.answer1);
		this.answer2 = (CheckBox) activity.findViewById(R.id.answer2);
		this.answer3 = (CheckBox) activity.findViewById(R.id.answer3);
		this.answer4 = (CheckBox) activity.findViewById(R.id.answer4);
		this.confirm = (Button) activity.findViewById(R.id.confirm);
	}

	//GETTERS AND SETTERS FOR GUI ELEMENTS
	
	public TextView getQuestion() {
		return question;
	}
	
	//The setter changes not the Object itself, but just the Text (Question text from XML) 
	public void setQuestion(String text) {
		question.setText(text);
	}

	public TextView getLeveltext() {
		return leveltext;
	}
	
	//The setter changes not the Object itself, but just the Text (Level-Information from Database) 
	public void setLeveltext(String text) {
		leveltext.setText(text);
	}

	public CheckBox getAnswer1() {
		return answer1;
	}

	//The setter changes not the Object itself, but just the Text (Answer text from XML) 
	public void setAnswer1(String text) {
		answer1.setText(text);
	}

	public CheckBox getAnswer2() {
		return answer2;
	}

	//The setter changes not the Object itself, but just the Text (Answer text from XML) 
	public void setAnswer2(String text) {
		answer2.setText(text);
	}

	public CheckBox getAnswer3() {
		return answer3;
	}

	//The setter changes not the Object itself, but just the Text (Answer text from XML) 
	public void setAnswer3(String text) {
		answer3.setText(text);
	}

	public CheckBox getAnswer4() {
		return answer4;
	}

	//The setter changes not the Object itself, but just the Text (Answer text from XML) 
	public void setAnswer4(String text) {
		answer4.setText(text);
	}

	public Button getConfirm() {
		return confirm;
	}

	public void setConfirm(Button confirm) {
		this.confirm = confirm;
	}	
	
}
