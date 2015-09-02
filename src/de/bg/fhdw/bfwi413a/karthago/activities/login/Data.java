package de.bg.fhdw.bfwi413a.karthago.activities.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import de.bg.fhdw.bfwi413a.karthago.Navigation;

public class Data {

	//Not used, because obsolete
	//private static final String KEY_LOGIN_ID = "M"; //Um den Zustand der Activity zu erhalten
	//private int mLoginId;
	//private final int DEFAULT_LOGIN_ID = 0;
	
	private Activity mActivity;
	
	public Data(Activity activity, Bundle savedInstanceState){
		Intent intent;
		
		mActivity = activity;
		if ( savedInstanceState == null ) {
			intent = mActivity.getIntent();
			//Not used, because obsolete
			//mLoginId = intent.getIntExtra(Navigation.KEY_LOGIN_ID, DEFAULT_LOGIN_ID);
		}
		else {
			//Not used, because obsolete
			//restoreDataFromBundle(savedInstanceState);
		}
	}

	

	public Activity getmActivity() {
		return mActivity;
	}
	
	//Not used, because obsolete
	
	//public int getmMenuId() {
	//	return mLoginId;
	//}
	
	// save and restore data
	
	//public void saveDataInBundle(Bundle bundle) {
		//bundle.putInt(KEY_LOGIN_ID, mLoginId);
	//}
	
	//public void restoreDataFromBundle(Bundle bundle) {
		//mLoginId = bundle.getInt(KEY_LOGIN_ID);
	//}

}
