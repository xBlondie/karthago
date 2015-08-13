package de.bg.fhdw.bfwi413a.karthago.activities.lm3_g;

//author: Leonie

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import de.bg.fhdw.bfwi413a.karthago.R;

public class Gui {
	
	TextView mTextviewQuestionG;
	Button mButtonShowG;
	
	public Gui(Activity activity){
		activity.setContentView(R.layout.activity_lm3_g);
		this.mTextviewQuestionG = (TextView) activity.findViewById(R.id.textview_question_g);
		this.mButtonShowG = (Button) activity.findViewById(R.id.btn_show_g);
	}

	public TextView getmTextviewQuestionG() {
		return mTextviewQuestionG;
	}

	public void setmTextviewQuestionG(TextView mTextviewQuestionG) {
		this.mTextviewQuestionG = mTextviewQuestionG;
	}

	public Button getmButtonShowG() {
		return mButtonShowG;
	}

	public void setmButtonShowG(Button mButtonShowG) {
		this.mButtonShowG = mButtonShowG;
	}
	
}
