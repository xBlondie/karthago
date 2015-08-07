package de.bg.fhdw.bfwi413a.karthago.activities.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import de.bg.fhdw.bfwi413a.karthago.Navigation;

public class Data {

private static final String KEY_LOGIN_ID = "M"; //Um den Zustand der Activity zu erhalten
	
	private int mLoginId;
	private Activity mActivity;
	
	private final int DEFAULT_LOGIN_ID = 0;
	
	public Data(Activity activity, Bundle savedInstanceState){
		Intent intent;
		
		mActivity = activity;
		if ( savedInstanceState == null ) {
			intent = mActivity.getIntent();
			mLoginId = intent.getIntExtra(Navigation.KEY_LOGIN_ID, DEFAULT_LOGIN_ID);
		}
		else {
			restoreDataFromBundle(savedInstanceState);
		}
	}

	public int getmMenuId() {
		return mLoginId;
	}

	public Activity getmActivity() {
		return mActivity;
	}
	
	// save and restore data
	
	public void saveDataInBundle(Bundle bundle) {
		bundle.putInt(KEY_LOGIN_ID, mLoginId);
	}
	
	public void restoreDataFromBundle(Bundle bundle) {
		mLoginId = bundle.getInt(KEY_LOGIN_ID);
	}

}
