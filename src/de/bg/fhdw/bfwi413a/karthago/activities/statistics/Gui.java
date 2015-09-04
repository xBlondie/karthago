package de.bg.fhdw.bfwi413a.karthago.activities.statistics;

import de.bg.fhdw.bfwi413a.karthago.R;
import android.app.Activity;
import android.widget.TextView;

public class Gui {

	TextView mTextviewCountAmountCardfile;
	TextView mTextviewCountQuestAll;
	TextView mTextviewCountQuestMc;
	TextView mTextviewCountQuestFt;
	TextView mTextviewCountQuestG;
	TextView mTextviewCountQuestAnswered;
	TextView mTextviewCountQuestRight;
	TextView mTextviewCountQuestWrong;

	public Gui(Activity activity){
		activity.setContentView(R.layout.activity_statistics);
		this.mTextviewCountAmountCardfile = (TextView) activity.findViewById(R.id.textview_count_amount_cardfile);
		this.mTextviewCountQuestAll = (TextView) activity.findViewById(R.id.textview_count_quest_all);
		this.mTextviewCountQuestMc = (TextView) activity.findViewById(R.id.textview_count_quest_mc);
		this.mTextviewCountQuestFt = (TextView) activity.findViewById(R.id.textview_count_quest_ft);
		this.mTextviewCountQuestG = (TextView) activity.findViewById(R.id.textview_count_quest_g);
		this.mTextviewCountQuestAnswered = (TextView) activity.findViewById(R.id.textview_count_quest_answered);
		this.mTextviewCountQuestRight = (TextView) activity.findViewById(R.id.textview_count_quest_right);
		this.mTextviewCountQuestWrong = (TextView) activity.findViewById(R.id.textview_count_quest_wrong);
	}

	public TextView getTextviewCountAmountCardfile() {
		return mTextviewCountAmountCardfile;
	}

	public void setTextviewCountAmountCardfile(String text) {
		mTextviewCountAmountCardfile.setText(text);
	}

	public TextView getTextviewCountQuestAll() {
		return mTextviewCountQuestAll;
	}

	public void setTextviewCountQuestAll(String text) {
		mTextviewCountQuestAll.setText(text);
	}

	public TextView getTextviewCountQuestMc() {
		return mTextviewCountQuestMc;
	}

	public void setTextviewCountQuestMc(String text) {
		mTextviewCountQuestMc.setText(text);
	}

	public TextView getTextviewCountQuestFt() {
		return mTextviewCountQuestFt;
	}

	public void setTextviewCountQuestFt(String text) {
		mTextviewCountQuestFt.setText(text);
	}

	public TextView getTextviewCountQuestG() {
		return mTextviewCountQuestG;
	}

	public void setTextviewCountQuestG(String text) {
		mTextviewCountQuestG.setText(text);
	}

	public TextView getTextviewCountQuestAnswered() {
		return mTextviewCountQuestAnswered;
	}

	public void setTextviewCountQuestAnswered(String text) {
		mTextviewCountQuestAnswered.setText(text);
	}

	public TextView getTextviewCountQuestRight() {
		return mTextviewCountQuestRight;
	}

	public void setTextviewCountQuestRight(String text) {
		mTextviewCountQuestRight.setText(text);
	}

	public TextView getTextviewCountQuestWrong() {
		return mTextviewCountQuestWrong;
	}

	public void setTextviewCountQuestWrong(String text) {
		mTextviewCountQuestWrong.setText(text);
	}

}
