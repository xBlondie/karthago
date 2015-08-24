/**********************************************************************************
 * ----------       LOGIN-ACTIVITY - WRITTEN BY: FYNN-OLE CALLSEN        ----------
 * 
 * Diese Activity stellt das Menü der App dar. Von dieser App aus, können folgende
 * Activities aufgerufen werden:
 * 		- Selektion
 * 		- Konfiguration
 * 		- Statistiken
 * 
 * Weiterhin kann sich der User über diese Activity abmelden.
 * 
 * Klassen, mit die diese Activity kommuniziert sind:
 *   - SessionManagement (Erstellung einer Session für den User)
 *   - XMLDomParserAndHandler (prüft ob XML-File existiert)
 *   - XMLToDBCommunication (Initialisiere Datenbank mit XML-Daten)
 * 
 * Nähere Informationen zu den Methoden siehe im Quellcode!
 * 
 *********************************************************************************/


package de.bg.fhdw.bfwi413a.karthago.activities.menu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import de.bg.fhdw.bfwi413a.karthago.R;
import de.bg.fhdw.bfwi413a.karthago.SessionManagement;
import de.bg.fhdw.bfwi413a.karthago.xml.XMLDomParserAndHandler;
import de.bg.fhdw.bfwi413a.karthago.xml.XmlToDbCommunication;

public class Init extends Activity {

	//DECLARE NECESSARY VARIABLES
	private Data mData;
	private Gui mGui;
	private ApplicationLogic mApplicationLogic;

	TextView set_username;
	SessionManagement session;
	XMLDomParserAndHandler xmlhandler;
	XmlToDbCommunication xmldb;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//INITIALIZE COMPONENTS
		initData(savedInstanceState);
		initGui();
		initApplicationLogic();
		initEventToListenerMapping();
		set_username = (TextView) findViewById(R.id.set_salutations);
		session = new SessionManagement(getApplicationContext());
		xmlhandler = new XMLDomParserAndHandler(Init.this);
		xmldb = new XmlToDbCommunication(Init.this);
		
		//CHECK IF IS LOGED IN SET USERNAME IN TEXTVIEW
		setUsername();
		//INITIALIZE DATABASE WITH XML-DATA
		xmldb.initializeAtFirstStart();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}

	private void initData(Bundle savedInstanceState) {
		mData = new Data(this, savedInstanceState);
	}

	private void initGui() {
		mGui = new Gui(this);
	}

	private void initApplicationLogic() {
		mApplicationLogic = new ApplicationLogic(mGui, mData);
	}

	private void initEventToListenerMapping() {
		new EventToListenerMapping(mGui, mApplicationLogic, this);
	}

	private void setUsername() {
		//CHECK IF USER IS LOGED IN PROPERLY
		session.checkLogin();
		//GET USERNAME OF SHARED PREFERENCES
		String user = session.getUserDetails();
		//SET USERNAME IN TEXTVIEW
		set_username.setText(user);
	}

//TODO PASCAL BITTE UNTEN STEHENDEN TEIL KOMMENTIEREN!!!!
@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
if ((keyCode == KeyEvent.KEYCODE_BACK)) {
       

    AlertDialog.Builder backB = new AlertDialog.Builder(Init.this);
    backB.setTitle("Sie haben die Zurück Taste gedrückt");
    backB.setMessage("Möchten Sie das Programm wirklich beenden?");

    backB.setPositiveButton("Ja", new DialogInterface.OnClickListener() {

        public void onClick(DialogInterface dialog, int whichButton) {
        session.logoutUserWithoutRedirect();
        android.os.Process.killProcess(android.os.Process.myPid());
        }

    });

    backB.setNegativeButton("Nein", new DialogInterface.OnClickListener(){
        public void onClick(DialogInterface dialog, int id) {
            dialog.cancel();
        }
    });


backB.show();

}return true;
}
}
