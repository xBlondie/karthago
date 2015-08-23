package de.bg.fhdw.bfwi413a.karthago.onboarding;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import de.bg.fhdw.bfwi413a.karthago.R;

public class Onboarding6 extends Activity{ 
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.onboarding_6);
	}
	
		public boolean onTouchEvent(MotionEvent event) {

		    // get masked (not specific to a pointer) action
		    int maskedAction = event.getActionMasked();

		    switch (maskedAction) {

		    case MotionEvent.ACTION_DOWN:
		    	Intent i = new Intent(Onboarding6.this, Onboarding7.class);
				finish();
				startActivity(i);
		      break;

		    
		    }
			return false;
		    } 
}

