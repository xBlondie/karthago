package de.bg.fhdw.bfwi413a.karthago.activities.statistics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import de.bg.fhdw.bfwi413a.karthago.Navigation;

public class Data {
	
	private static final String KEY_STATISTICS_ID = "ST"; //Um den Zustand der Activity zu erhalten
	
	private int mStatisticsId;
	private Activity mActivity;
	
	private final int DEFAULT_STATISTICS_ID = 0;
	
	public Data(Activity activity, Bundle savedInstanceState){
		Intent intent;
		
		mActivity = activity;
		if ( savedInstanceState == null ) {
			intent = mActivity.getIntent();
			mStatisticsId = intent.getIntExtra(Navigation.KEY_SELECTION_ID, DEFAULT_STATISTICS_ID);
		}
		else {
			restoreDataFromBundle(savedInstanceState);
		}
	}

	public int getmMenuId() {
		return mStatisticsId;
	}

	public Activity getmActivity() {
		return mActivity;
	}
	
	// save and restore data
	
	public void saveDataInBundle(Bundle bundle) {
		bundle.putInt(KEY_STATISTICS_ID, mStatisticsId);
	}
	
	public void restoreDataFromBundle(Bundle bundle) {
		mStatisticsId = bundle.getInt(KEY_STATISTICS_ID);
	}

}
