//Weist ClickListener den Buttons zu

package de.bg.fhdw.bfwi413a.karthago.activities.selection;

import android.view.View;
import android.view.View.OnClickListener;
import de.bg.fhdw.bfwi413a.karthago.R;

public class EventToListenerMapping implements OnClickListener{
	
	private ApplicationLogic mApplicationLogic;
	private Gui mGui;
	
	public EventToListenerMapping (Gui gui, ApplicationLogic applicationLogic) {
		mApplicationLogic = applicationLogic;
		mGui = gui;
		mGui.getmButtonCardfile1().setOnClickListener(this);
		mGui.getmButtonCardfile2().setOnClickListener(this);
		mGui.getmButtonCardfile3().setOnClickListener(this);
		mGui.getmButtonCardfile4().setOnClickListener(this);
		mGui.getmButtonCardfile5().setOnClickListener(this);
		mGui.getmButtonCardfile6().setOnClickListener(this);
		mGui.getmButtonCardfile7().setOnClickListener(this);
		mGui.getmButtonCardfile8().setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch ( v.getId() ) {
		case R.id.btn_cardfile1:   // CardFile Button
			mApplicationLogic.onButtonClicked(1);
			break;
		case R.id.btn_cardfile2:   // CardFile Button
			mApplicationLogic.onButtonClicked(2);
			break;
		case R.id.btn_cardfile3:   // CardFile Button
			mApplicationLogic.onButtonClicked(3);
			break;
		case R.id.btn_cardfile4:   // CardFile Button
			mApplicationLogic.onButtonClicked(4);
			break;
		case R.id.btn_cardfile5:   // CardFile Button
			mApplicationLogic.onButtonClicked(5);
			break;
		case R.id.btn_cardfile6:   // CardFile Button
			mApplicationLogic.onButtonClicked(6);
			break;
		case R.id.btn_cardfile7:   // CardFile Button
			mApplicationLogic.onButtonClicked(7);
			break;
		case R.id.btn_cardfile8:   // CardFile Button
			mApplicationLogic.onButtonClicked(8);
			break;
		}
		
	}

}
