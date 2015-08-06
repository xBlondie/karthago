package de.bg.fhdw.bfwi413a.karthago.activities.menu;

import de.bg.fhdw.bfwi413a.karthago.Navigation;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Data {
	
	private static final String KEY_MENU_ID = "M"; //Um den Zustand der Activity zu erhalten
	
	private int mMenuId;
	private Activity mActivity;
	
	private final int DEFAULT_MENU_ID = 0;
	
	public Data(Activity activity, Bundle savedInstanceState){
		Intent intent;
		
		mActivity = activity;
		if ( savedInstanceState == null ) {
			intent = mActivity.getIntent();
			mMenuId = intent.getIntExtra(Navigation.KEY_MENU_ID, DEFAULT_MENU_ID);
		}
		else {
			restoreDataFromBundle(savedInstanceState);
		}
	}

	public int getmMenuId() {
		return mMenuId;
	}

	public Activity getmActivity() {
		return mActivity;
	}
	
	// save and restore data
	
	public void saveDataInBundle(Bundle bundle) {
		bundle.putInt(KEY_MENU_ID, mMenuId);
	}
	
	public void restoreDataFromBundle(Bundle bundle) {
		mMenuId = bundle.getInt(KEY_MENU_ID);
	}

}
