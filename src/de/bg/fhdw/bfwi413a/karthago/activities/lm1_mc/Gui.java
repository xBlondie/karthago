package de.bg.fhdw.bfwi413a.karthago.activities.lm1_mc;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import de.bg.fhdw.bfwi413a.karthago.R;

//author: Leonie

public class Gui {
	
	TextView mTextviewQuestionFT;
	Button mButtonSendMC;
	EditText mEditTextFT;
	RadioGroup mRadioGroupMC;
	RadioButton mRadioAnswer1;
	RadioButton mRadioAnswer2;
	RadioButton mRadioAnswer3;
	RadioButton mRadioAnswer4;
	
	public Gui(Activity activity){
		activity.setContentView(R.layout.activity_lm1_mc);
		this.mTextviewQuestionFT = (TextView) activity.findViewById(R.id.textview_question_mc);
		this.mButtonSendMC = (Button) activity.findViewById(R.id.btn_send_mc);
		this.mRadioGroupMC = (RadioGroup) activity.findViewById(R.id.radiogroup_mc);
		this.mRadioAnswer1 = (RadioButton) activity.findViewById(R.id.radio_answer1);
		this.mRadioAnswer2 = (RadioButton) activity.findViewById(R.id.radio_answer2);
		this.mRadioAnswer3 = (RadioButton) activity.findViewById(R.id.radio_answer3);
		this.mRadioAnswer4 = (RadioButton) activity.findViewById(R.id.radio_answer4);
	}

	public TextView getmTextviewQuestionFT() {
		return mTextviewQuestionFT;
	}

	public void setmTextviewQuestionFT(TextView mTextviewQuestionFT) {
		this.mTextviewQuestionFT = mTextviewQuestionFT;
	}

	public Button getmButtonSendMC() {
		return mButtonSendMC;
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

	public RadioGroup getmRadioGroupMC() {
		return mRadioGroupMC;
	}

	public void setmRadioGroupMC(RadioGroup mRadioGroupMC) {
		this.mRadioGroupMC = mRadioGroupMC;
	}

	public RadioButton getmRadioAnswer1() {
		return mRadioAnswer1;
	}

	public void setmRadioAnswer1(RadioButton mRadioAnswer1) {
		this.mRadioAnswer1 = mRadioAnswer1;
	}

	public RadioButton getmRadioAnswer2() {
		return mRadioAnswer2;
	}

	public void setmRadioAnswer2(RadioButton mRadioAnswer2) {
		this.mRadioAnswer2 = mRadioAnswer2;
	}

	public RadioButton getmRadioAnswer3() {
		return mRadioAnswer3;
	}

	public void setmRadioAnswer3(RadioButton mRadioAnswer3) {
		this.mRadioAnswer3 = mRadioAnswer3;
	}

	public RadioButton getmRadioAnswer4() {
		return mRadioAnswer4;
	}

	public void setmRadioAnswer4(RadioButton mRadioAnswer4) {
		this.mRadioAnswer4 = mRadioAnswer4;
	}
	
}
