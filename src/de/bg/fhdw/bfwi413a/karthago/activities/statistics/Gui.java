package de.bg.fhdw.bfwi413a.karthago.activities.statistics;

import de.bg.fhdw.bfwi413a.karthago.R;
import android.app.Activity;
import android.widget.TextView;

public class Gui {

	TextView mTextviewStatistic;
	
	public Gui(Activity activity){
		activity.setContentView(R.layout.activity_statistics);
		this.mTextviewStatistic = (TextView) activity.findViewById(R.id.textview_statistic);
	}

	public TextView getTextviewStatistic() {
		return mTextviewStatistic;
	}

	public void setTextviewStatistic(String text) {
		mTextviewStatistic.setText(text); 
	}
	
	
}
