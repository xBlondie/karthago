package de.bg.fhdw.bfwi413a.karthago.activities.lm2_ft;

//author: Leonie

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import de.bg.fhdw.bfwi413a.karthago.R;

public class Gui {
	
	TextView mTextviewQuestionFT;
	Button mButtonSENDFT;
	EditText mEditTextFT;
	
	public Gui(Activity activity){
		activity.setContentView(R.layout.activity_lm2_ft);
		this.mTextviewQuestionFT = (TextView) activity.findViewById(R.id.textview_question_ft);
		this.mButtonSENDFT = (Button) activity.findViewById(R.id.btn_send_ft);
		this.mEditTextFT = (EditText) activity.findViewById(R.id.edittext_ft);
	}

	public TextView getmTextviewQuestionFT() {
		return mTextviewQuestionFT;
	}

	public void setmTextviewQuestionFT(TextView mTextviewQuestionFT) {
		this.mTextviewQuestionFT = mTextviewQuestionFT;
	}

	public Button getmButtonSENDFT() {
		return mButtonSENDFT;
	}

	public void setmButtonSENDFT(Button mButtonSENDFT) {
		this.mButtonSENDFT = mButtonSENDFT;
	}

	public EditText getmEditTextFT() {
		return mEditTextFT;
	}

	public void setmEditTextFT(EditText mEditTextFT) {
		this.mEditTextFT = mEditTextFT;
	}
	
}
