package de.bg.fhdw.bfwi413a.karthago.activities.lm2_ft;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import de.bg.fhdw.bfwi413a.karthago.Navigation;

//author: Leonie

public class Data {
	
	private static final String KEY_LM2_ID = "M"; //Um den Zustand der Activity zu erhalten
	
	private int mLM2Id;
	private Activity mActivity;
	
	private final int DEFAULT_LM2_ID = 0;
	
	public Data(Activity activity, Bundle savedInstanceState){
		Intent intent;
		
		mActivity = activity;
		if ( savedInstanceState == null ) {
			intent = mActivity.getIntent();
			mLM2Id = intent.getIntExtra(Navigation.KEY_LM2_ID, DEFAULT_LM2_ID);
		}
		else {
			restoreDataFromBundle(savedInstanceState);
		}
	}

	public int getmMenuId() {
		return mLM2Id;
	}

	public Activity getmActivity() {
		return mActivity;
	}
	
	// save and restore data
	
	public void saveDataInBundle(Bundle bundle) {
		bundle.putInt(KEY_LM2_ID, mLM2Id);
	}
	
	public void restoreDataFromBundle(Bundle bundle) {
		mLM2Id = bundle.getInt(KEY_LM2_ID);
	}
	
}
