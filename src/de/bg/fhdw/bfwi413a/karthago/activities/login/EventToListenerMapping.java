package de.bg.fhdw.bfwi413a.karthago.activities.login;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class EventToListenerMapping implements OnClickListener, OnItemSelectedListener{
	
	private ApplicationLogic mApplicationLogic;
	private Gui mGui;
	
	public EventToListenerMapping(Gui gui, ApplicationLogic applicationLogic) {
		mApplicationLogic = applicationLogic;
		mGui = gui;
		mGui.getmButtonLogin().setOnClickListener(this);
		mGui.getmSpinnerUser().setOnItemSelectedListener(this);
	}

	@Override
	public void onClick(View v) {
		mApplicationLogic.onLoginButtonClick();
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		//mApplicationLogic.onSpinnerUsed();
		
		// On selecting a spinner item
        String label = parent.getItemAtPosition(position).toString();
 
        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "You selected: " + label,
                Toast.LENGTH_LONG).show();
 
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
	}
	
	

}
