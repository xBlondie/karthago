/**********************************************************************************
 * ----------       LOGIN-ACTIVITY - WRITTEN BY: PASCAL THRONICKE        ----------
 * 
 * Diese Activity bildet das Bindeglied zwischen der XML-Datei und der Datenbank.
 * 
 * Klassen, mit die diese App kommuniziert sind:
 * 	 - SessionManagement (Hole Username)
 * 	 - DatabaseHandler (Steuern der Datenbank-Befehle)
 *   - XMLDomParserundHandler (Auslösen verschiedener Methoden)
 *   - Results (zur EInholung von mehreren Variablen gleichzeitig)
 * 
 * Nähere Informationen zu den Methoden siehe im Quellcode!
 * 
 *********************************************************************************/

package de.bg.fhdw.bfwi413a.karthago.xml;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import android.content.Context;
import de.bg.fhdw.bfwi413a.karthago.SessionManagement;
import de.bg.fhdw.bfwi413a.karthago.db.DatabaseHandler;

public class XmlToDbCommunication{

	//DECLARE VARIABLES
	DatabaseHandler dbhandler;
	SessionManagement session;
	XMLDomParserAndHandler xmldomhandler;
	ArrayList<String> allCardFileNames;
	ArrayList<String> list_ids;
	ArrayList<String> list_cardfile_names;
	ArrayList<String> list_answer_type;
	Results result;
	String user;
	Timestamp tstamp;
	
	public XmlToDbCommunication(Context context){
		//INITIALIZE OBJECTS
		dbhandler = new DatabaseHandler(context);
		session = new SessionManagement(context);
		xmldomhandler = new XMLDomParserAndHandler(context);
		allCardFileNames = new ArrayList<String>();
		result = new Results();
		list_ids = new ArrayList<String>();
		list_cardfile_names = new ArrayList<String>();
		list_answer_type = new ArrayList<String>();
		user = new String();
		tstamp = new Timestamp(new Date().getTime()); 
	}
	
	//METHOD TO GET ALL CARDFILE-NAMES AND COPY THEM INTO THE DATABASE
	private void copyCardFileNamesIntoDB() {
		allCardFileNames = xmldomhandler.getCardFileNames();
		for (int i = 0; i < allCardFileNames.size(); i++){
			dbhandler.insertCardFileNames(allCardFileNames.get(i).toString());
		}
		
	}
	
	//METHOD TO COPY ALL NECESSARY INFORMATIONS INTO DATABASE-TABLE "CARDS"
	private void copyIDsOfXMLToDB(){
		result = xmldomhandler.getAllIDs();
		list_ids = result.get_list_ids();
		list_cardfile_names = result.get_list_cardfile_id();
		list_answer_type = result.get_list_answer_type();
		user = session.getUserDetails().toString();
		
		for(int i = 0; i<list_ids.size(); i++){
			dbhandler.insertDataFromXMLToDB(Integer.parseInt(list_ids.get(i).toString()), user, tstamp.getTime(), list_cardfile_names.get(i).toString(), list_answer_type.get(i).toString());
		}
		
		
	}
	
	//METHOD TO INITIALIZE DATABASE AT FIRST TIME
	public void initializeAtFirstStart(){
		boolean first_start;
		//CHECK IF ITS THE USERS FIRST START
		first_start = dbhandler.FirstStart(session.getUserDetails().toString());
		if(first_start == true){
			//IF YES THEN DO...
			copyCardFileNamesIntoDB();
			copyIDsOfXMLToDB();
			//UPDATE THE FIRST START VALUE
			dbhandler.updateFirstStart(session.getUserDetails().toString());
			
		}
	}
	
}
