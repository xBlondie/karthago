package de.bg.fhdw.bfwi413a.karthago.activities.login;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.InputType;
import android.widget.EditText;
import android.widget.Toast;
import de.bg.fhdw.bfwi413a.karthago.Navigation;
import de.bg.fhdw.bfwi413a.karthago.SessionManagement;

public class ApplicationLogic {
	
	//DECLARE NECESSARY OBJECTS
	private Gui mGui;
	private Data mData;
	private Context mContext;
	private SessionManagement session;
	
	public ApplicationLogic(Gui gui, Data data, Context context){
		//INITIALIZE OBJECTS
		mGui = gui;
		mData = data;
		mContext = context;
		session = new SessionManagement(context);
		
		//SET USERLIST TO SPINENR
		setUserlist();
	}
	
	
	private void setUserlist() {
		mGui.mSpinnerUser.setAdapter(mData.getDataAdapter());
		
	}

	//IF NEW USER WAS CLICKED
	public void onNewUser(){
		//CREATE ALERT DIALOG FOR INPUT OF NEW USER
    	AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
    	//SET TITLE
    	builder.setTitle("Neuen Benutzer erstellen");

    	// SET UP THE INPUT
    	final EditText input = new EditText(mContext);
    	// SPECIFY THE INPUT TYPE; IN THIS CASE ITS TEXT
    	input.setInputType(InputType.TYPE_CLASS_TEXT);
    	builder.setView(input);

    	// SET UP THE BUTTONS
    	builder.setPositiveButton("Hinzufügen", new DialogInterface.OnClickListener() { 
    	    @Override
    	    //SET UP ONCLICKLISTENER FOR CREATE-BUTTON
    	    public void onClick(DialogInterface dialog, int which) {
    	    	//CHECK IF SOME TEXT WAS PUT IN
    	    	if (input.getText().toString().length() > 0) {
    	    		//INSERT USER IN DATABASE-TABLE
    	    		mData.mdbHandler.insertUser(input.getText().toString());
    	    		//REFRESH THE USER LIST
    	    		mData.loadUserlistFromDatabase();
    	    		setUserlist();
    	    		//SHOW TOAST FOR USER-NOTIFICATION
    	    		Toast.makeText(mContext, "Neuer User wurde erstellt",
                            Toast.LENGTH_SHORT).show();
    	    	}else{
    	    		//SHOW TOAST THAT SOME TEXT IS MISSING
    	    		Toast.makeText(mContext, "Bitte gebe einen Namen ein",
                            Toast.LENGTH_SHORT).show();
    	    	}
    	    	
    	    }
    	});
    	builder.setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {
    	    @Override
    	    //SET ONCLICKLISTENER FOR "CANCEL"-CASE
    	    public void onClick(DialogInterface dialog, int which) {
    	        //CANCEL ALERT-DIALOG
    	    	dialog.cancel();
    	    }
    	});

    	//SHOW THE ALERT-DIALOG
    	builder.show();

	}

	//IF LOGIN USER WAS CLICKED
	public void loginUser() {
		//CREATE SESSION WITH THE USERNAME WHICH WAS SELECTED ABOVE
		session.createLoginSession((String) mGui.mSpinnerUser.getSelectedItem().toString());
		// START NEXT ACTIVITY; IN THIS CASE THE MENU ACTIVITY
		Navigation.startActivityMenu(mData.getmActivity());		
		
	}
}
