package de.bg.fhdw.bfwi413a.karthago.activities.lm1_mc;

import android.app.Activity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import de.bg.fhdw.bfwi413a.karthago.R;

//author: Leonie

public class Gui {
	
	TextView question;
	TextView leveltext;
	CheckBox answer1;
	CheckBox answer2;
	CheckBox answer3;
	CheckBox answer4;
	Button confirm;
	
	public Gui(Activity activity){
		activity.setContentView(R.layout.activity_lm1_mc);		
		this.question = (TextView) activity.findViewById(R.id.question);
        this.leveltext = (TextView) activity.findViewById(R.id.textview_level_mc);
		this.answer1 = (CheckBox) activity.findViewById(R.id.answer1);
		this.answer2 = (CheckBox) activity.findViewById(R.id.answer2);
		this.answer3 = (CheckBox) activity.findViewById(R.id.answer3);
		this.answer4 = (CheckBox) activity.findViewById(R.id.answer4);
		this.confirm = (Button) activity.findViewById(R.id.confirm);
	}

	public TextView getQuestion() {
		return question;
	}

	public void setQuestion(String text) {
		question.setText(text);
	}

	public TextView getLeveltext() {
		return leveltext;
	}

	public void setLeveltext(String text) {
		leveltext.setText(text);
	}

	public CheckBox getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String text) {
		answer1.setText(text);
	}

	public CheckBox getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String text) {
		answer2.setText(text);
	}

	public CheckBox getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String text) {
		answer3.setText(text);
	}

	public CheckBox getAnswer4() {
		return answer4;
	}

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
