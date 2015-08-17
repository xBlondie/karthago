package de.bg.fhdw.bfwi413a.karthago.activities.lm1_mc;

import android.app.Activity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import de.bg.fhdw.bfwi413a.karthago.R;

//author: Leonie

public class Gui {
	
	TextView mTextviewQuestionMC;
	Button mButtonSendMC;
	EditText mEditTextFT;
	CheckBox CheckBox1;
	CheckBox CheckBox2;
	CheckBox CheckBox3;
	CheckBox CheckBox4;
	
	
	public Gui(Activity activity){
		activity.setContentView(R.layout.activity_lm1_mc);
//		this.mTextviewQuestionMC = (TextView) activity.findViewById(R.id.textview_question_mc);
//		this.mButtonSendMC = (Button) activity.findViewById(R.id.btn_send_mc);
//		this.CheckBox1 = (CheckBox) activity.findViewById(R.id.checkBox1);
//		this.CheckBox2 = (CheckBox) activity.findViewById(R.id.checkBox2);
//		this.CheckBox3 = (CheckBox) activity.findViewById(R.id.checkBox3);
//		this.CheckBox4 = (CheckBox) activity.findViewById(R.id.checkBox4);
		
	}

	public TextView getmTextviewQuestionFT() {
		return mTextviewQuestionMC;
	}

	public void setmTextviewQuestionMC(String text) {
		this.mTextviewQuestionMC.setText(text);
	}

	public Button getmButtonSendMC() {
		return null;
	}

	public void setmButtonSendMC(Button mButtonSendMC) {
		this.mButtonSendMC = mButtonSendMC;
	}

	public EditText getmEditTextFT() {
		return mEditTextFT;
	}

	public void setmEditTextFT(EditText mEditTextFT) {
		this.mEditTextFT = mEditTextFT;
	}

	public CheckBox getCheckBox1() {
		return CheckBox1;
	}

	public void setCheckBox1(String text) {
		CheckBox1.setText(text);
	}

	public CheckBox getCheckBox2() {
		return CheckBox2;
	}

	public void setCheckBox2(String text) {
		CheckBox2.setText(text);
	}

	public CheckBox getCheckBox3() {
		return CheckBox3;
	}

	public void setCheckBox3(String text) {
		CheckBox3.setText(text);
	}

	public CheckBox getCheckBox4() {
		return CheckBox4;
	}

	public void setCheckBox4(String text) {
		CheckBox4.setText(text);
	}

	
	
}
