package de.bg.fhdw.bfwi413a.karthago.activities.login;

import de.bg.fhdw.bfwi413a.karthago.R;
import android.app.Activity;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Gui {

	Button mButtonLogin;
	Spinner mSpinnerUser;
	
	public Gui (Activity activity){
		activity.setContentView(R.layout.activity_login);
		mButtonLogin = (Button) activity.findViewById(R.id.btn_login_start);
		mSpinnerUser = (Spinner) activity.findViewById(R.id.spinner_userlogin);
	}
	
	//getter and setter

	public Button getmButtonLogin() {
		return mButtonLogin;
	}

	public void setmButtonLogin(Button mButtonLogin) {
		this.mButtonLogin = mButtonLogin;
	}

	public Spinner getmSpinnerUser() {
		return mSpinnerUser;
	}

	public void setmSpinnerUser(Spinner mSpinnerUser) {
		this.mSpinnerUser = mSpinnerUser;
	}
	
	
}
