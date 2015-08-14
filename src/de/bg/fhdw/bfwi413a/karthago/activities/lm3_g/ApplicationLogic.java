package de.bg.fhdw.bfwi413a.karthago.activities.lm3_g;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.widget.TextView;
import de.bg.fhdw.bfwi413a.karthago.ConfigActivity;

public class ApplicationLogic {
	
	private Gui mGui;
	private Data mData;
	Context mContext;
	ArrayList<String> mQuestionAndAnswers;
	ArrayList<String> mCorrectAnswers;
	
	public ApplicationLogic(Gui gui, Data data, Context context) {
		mGui = gui;
		mData = data;
		mContext = context;
		initDataToGui();
	}
	
	private void initDataToGui() {
		//TODO: Init Data from XML to TextView and Button
		mQuestionAndAnswers = mData.getQuestionAndAnswers();
		mGui.setmTextviewQuestionG(mQuestionAndAnswers.get(0).toString());
	}


	public void onButtonClicked() {
		//TODO: Logic for Answers
		mCorrectAnswers = mData.getCorrectAnswers();
		AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
		builder.setTitle("Korrekt:");
		TextView myMsg = new TextView(mContext);
		myMsg.setText(mCorrectAnswers.toString());
		myMsg.setGravity(Gravity.CENTER_HORIZONTAL);
		builder.setView(myMsg);
		// Add the buttons
		builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		               dialog.cancel();
		           }
		       });
		
		// Create the AlertDialog
		builder.show();
	}

	
}
