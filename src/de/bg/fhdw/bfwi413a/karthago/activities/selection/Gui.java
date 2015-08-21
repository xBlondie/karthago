//Gui wird benötigt, damit die Gui geladen werden kann und funktioniert

package de.bg.fhdw.bfwi413a.karthago.activities.selection;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import de.bg.fhdw.bfwi413a.karthago.R;

public class Gui {

	//Objektvariablen anlegen, damit sie funktionieren
	TextView mTextviewCardfileSelection;
	Button mButtonCardfile1;
	Button mButtonCardfile2;
	Button mButtonCardfile3;
	Button mButtonCardfile4;
	Button mButtonCardfile5;
	Button mButtonCardfile6;
	Button mButtonCardfile7;
	Button mButtonCardfile8;
	
	//Constructor, damit die GUI initialisiert werden kann
	public Gui(Activity activity) {
		activity.setContentView(R.layout.activity_selection);
		this.mTextviewCardfileSelection = (TextView) activity.findViewById(R.id.textview_cardfile_selection);
		this.mButtonCardfile1 = (Button) activity.findViewById(R.id.btn_cardfile1);
		this.mButtonCardfile2 = (Button) activity.findViewById(R.id.btn_cardfile2);
		this.mButtonCardfile3 = (Button) activity.findViewById(R.id.btn_cardfile3);
		this.mButtonCardfile4 = (Button) activity.findViewById(R.id.btn_cardfile4);
		this.mButtonCardfile5 = (Button) activity.findViewById(R.id.btn_cardfile5);
		this.mButtonCardfile6 = (Button) activity.findViewById(R.id.btn_cardfile6);
		this.mButtonCardfile7 = (Button) activity.findViewById(R.id.btn_cardfile7);
		this.mButtonCardfile8 = (Button) activity.findViewById(R.id.btn_cardfile8);
	}

	
	//getter und setter (werden benötigt, um Informationen von woanders zu holen oder zu schicken)
	public Button getmButtonCardfile1() {
		return mButtonCardfile1;
	}

	public void setmButtonCardfile1(Button mButtonCardfile1) {
		this.mButtonCardfile1 = mButtonCardfile1;
	}

	public Button getmButtonCardfile2() {
		return mButtonCardfile2;
	}

	public void setmButtonCardfile2(Button mButtonCardfile2) {
		this.mButtonCardfile2 = mButtonCardfile2;
	}

	public Button getmButtonCardfile3() {
		return mButtonCardfile3;
	}

	public void setmButtonCardfile3(Button mButtonCardfile3) {
		this.mButtonCardfile3 = mButtonCardfile3;
	}

	public Button getmButtonCardfile4() {
		return mButtonCardfile4;
	}

	public void setmButtonCardfile4(Button mButtonCardfile4) {
		this.mButtonCardfile4 = mButtonCardfile4;
	}

	public Button getmButtonCardfile5() {
		return mButtonCardfile5;
	}

	public void setmButtonCardfile5(Button mButtonCardfile5) {
		this.mButtonCardfile5 = mButtonCardfile5;
	}

	public Button getmButtonCardfile6() {
		return mButtonCardfile6;
	}

	public void setmButtonCardfile6(Button mButtonCardfile6) {
		this.mButtonCardfile6 = mButtonCardfile6;
	}

	public Button getmButtonCardfile7() {
		return mButtonCardfile7;
	}

	public void setmButtonCardfile7(Button mButtonCardfile7) {
		this.mButtonCardfile7 = mButtonCardfile7;
	}

	public Button getmButtonCardfile8() {
		return mButtonCardfile8;
	}

	public void setmButtonCardfile8(Button mButtonCardfile8) {
		this.mButtonCardfile8 = mButtonCardfile8;
	}
	
	public void diasableButtons(){
		mButtonCardfile1.setEnabled(false);
		mButtonCardfile2.setEnabled(false);
		mButtonCardfile3.setEnabled(false);
		mButtonCardfile4.setEnabled(false);
		mButtonCardfile5.setEnabled(false);
		mButtonCardfile6.setEnabled(false);
		mButtonCardfile7.setEnabled(false);
		mButtonCardfile8.setEnabled(false);
		
	}
}
