package de.bg.fhdw.bfwi413a.karthago.activities.login;

import android.app.Activity;
import android.widget.Button;
import android.widget.Spinner;
import de.bg.fhdw.bfwi413a.karthago.R;

public class Gui {
	
	//DECLARE GUI-ELEMENTS
	Button new_user;
	Button mButtonLogin;
	Spinner mSpinnerUser;
	
	public Gui (Activity activity){
		//MATCH GUI ELEMENTS WITH LAYOUT ELEMENTS
		activity.setContentView(R.layout.activity_login);
		mButtonLogin = (Button) activity.findViewById(R.id.btn_login_start);
		mSpinnerUser = (Spinner) activity.findViewById(R.id.spn_userlist);
		new_user = (Button) activity.findViewById(R.id.new_user);
	}

	//GETTER AND SETTER
	public Spinner getmSpinnerUser() {
		return mSpinnerUser;
	}

	public void setmSpinnerUser(Spinner mSpinnerUser) {
		this.mSpinnerUser = mSpinnerUser;
	}

	public Button getNew_user() {
		return new_user;
	}

	public Button getmButtonLogin() {
		return mButtonLogin;
	}
	

		
	
}
