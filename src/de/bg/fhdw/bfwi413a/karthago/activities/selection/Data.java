/**********************************************************************************
 * ----------       DATA-CLASS (SELECTION)- WRITTEN BY: AN-NAM PHAM         -----------
 *
 * The Data class is necessary to manage all information used by this activity.
 * In this case it provides the getter for the selection activity.
 * 
 ************************************************************************************/
package de.bg.fhdw.bfwi413a.karthago.activities.selection;

//IMPORTS FOR NEEDED CLASSES
import android.app.Activity;

public class Data {
	
	//DECLARE VARIABLES
	private Activity mActivity;
	
	//CONSTRUCTOR TO GENERATE A DATA OBJECT
	public Data(Activity activity){		
		mActivity = activity;
	}

	//GETTER
	public Activity getmActivity() {
		return mActivity;
	}

}
