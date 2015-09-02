// Data wird benötigt, um in dieser Activity benötigten Information/Daten zu verwalten.

package de.bg.fhdw.bfwi413a.karthago.activities.selection;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import de.bg.fhdw.bfwi413a.karthago.Navigation;

public class Data {

	//Not used, because obsolete
	//private static final String KEY_SELECTION_ID = "M"; //Um den Zustand der Activity zu erhalten
	//private int mSelectionId;
	//private final int DEFAULT_SELECTION_ID = 0;
	
	private Activity mActivity;
	
	public Data(Activity activity, Bundle savedInstanceState){
		Intent intent;
		
		mActivity = activity;
		if ( savedInstanceState == null ) {
			intent = mActivity.getIntent();
			//Not used, because obsolete
			//mSelectionId = intent.getIntExtra(Navigation.KEY_SELECTION_ID, DEFAULT_SELECTION_ID);
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
//	public int getmMenuId() {
//	return mSelectionId;
//  }
	
	// save and restore data
	
//	public void saveDataInBundle(Bundle bundle) {
//		bundle.putInt(KEY_SELECTION_ID, mSelectionId);
//	}
//	
//	public void restoreDataFromBundle(Bundle bundle) {
//		mSelectionId = bundle.getInt(KEY_SELECTION_ID);
//	}

}
