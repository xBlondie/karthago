package de.bg.fhdw.bfwi413a.karthago.activities.menu;

import de.bg.fhdw.bfwi413a.karthago.R;
import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

public class Gui {
	
	TextView mTextviewLogo;
	Button mButtonStartSelection;
	Button mButtonStartConfig;
	Button mButtonStartStatistics;
	Button mButtonLogout;
	
	public Gui(Activity activity){
		activity.setContentView(R.layout.activity_menu);
		//this.mTextviewLogo = (TextView) activity.findViewById(R.id.textview_logo);
		this.mButtonStartSelection = (Button) activity.findViewById(R.id.btn_start_selection);
		this.mButtonStartConfig = (Button) activity.findViewById(R.id.btn_start_config);
		this.mButtonStartStatistics = (Button) activity.findViewById(R.id.btn_start_statistics);
		this.mButtonLogout = (Button) activity.findViewById(R.id.btn_logout);
	}

	public TextView getmTextviewLogo() {
		return mTextviewLogo;
	}

	public void setmTextviewLogo(TextView mTextviewLogo) {
		this.mTextviewLogo = mTextviewLogo;
	}

	public Button getmButtonStartSelection() {
		return mButtonStartSelection;
	}

	public void setmButtonStartSelection(Button mButtonStartSelection) {
		this.mButtonStartSelection = mButtonStartSelection;
	}

	public Button getmButtonStartConfig() {
		return mButtonStartConfig;
	}

	public void setmButtonStartConfig(Button mButtonStartConfig) {
		this.mButtonStartConfig = mButtonStartConfig;
	}

	public Button getmButtonStartStatistics() {
		return mButtonStartStatistics;
	}

	public void setmButtonStartStatistics(Button mButtonStartStatistics) {
		this.mButtonStartStatistics = mButtonStartStatistics;
	}

	public Button getmButtonLogout() {
		return mButtonLogout;
	}

	public void setmButtonLogout(Button mButtonLogout) {
		this.mButtonLogout = mButtonLogout;
	}

}
