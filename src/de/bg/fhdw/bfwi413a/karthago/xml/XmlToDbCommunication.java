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
		}else{
			updateDatabase(session.getUserDetails().toString());
		}
	}

	private void updateDatabase(String user) {
		//DECLARE ARRAYLISTS ANd HELPERVARIABLE RESULTS
		ArrayList<String> questionIDsDB = new ArrayList<String>();
		ArrayList<String> questionIDsXML = new ArrayList<String>();
		Results results = new Results();
		
		questionIDsDB = dbhandler.getAllQuestionIDsOfUser(user);
		results = xmldomhandler.getAllIDs();
		questionIDsXML = results.get_list_ids();
		
		setQuestionsInactive(questionIDsDB, questionIDsXML, user);
		updateQuestionIDsDB(questionIDsXML, questionIDsDB, user);
	}

	private void updateQuestionIDsDB(ArrayList<String> questionIDsXML, ArrayList<String> questionIDsDB, String user) {
		Results result = new Results();
		result = xmldomhandler.getAllIDs(); //TODO ARRAY QUESTIONIDsXML verdoppelt sich!!
		Integer size = questionIDsXML.size() / 2;
		ArrayList<String> arrayXMLnew = new ArrayList<String>();
		for(int k = 0; k < size; k++){
			arrayXMLnew.add(questionIDsXML.get(k).toString());
		}
		Timestamp tstamp1 = new Timestamp(new Date().getTime());
		for(int i = 0; i < arrayXMLnew.size(); i++){
			boolean exist = false;
			for(int j = 0; j < questionIDsDB.size(); j++){
					
					if(arrayXMLnew.get(i).toString().equals(questionIDsDB.get(j).toString())){
						exist = true;
					}else{
						
					}
			}
			if(exist == false){
				String cardfile_name = result.get_list_cardfile_id().get(i).toString();
				String answer_type = result.get_list_answer_type().get(i).toString();
				dbhandler.insertDataFromXMLToDB(Integer.parseInt(arrayXMLnew.get(i).toString()), user, tstamp1.getTime(), cardfile_name, answer_type);
			}
		
		}
	}

	private void setQuestionsInactive(ArrayList<String> questionIDsDB, ArrayList<String> questionIDsXML, String user2) {
		for(int i = 0; i < questionIDsDB.size(); i++){
			boolean exist = false;
			for(int j = 0; j < questionIDsXML.size(); j++){
				if(exist == true){
					break;
				}else{
					if(questionIDsDB.get(i).toString().equals(questionIDsXML.get(j).toString())){
						dbhandler.setCardAsActive(Integer.parseInt(questionIDsDB.get(i).toString()), user2);
						exist = true;
					}
				}
			}
			if(exist == false){
				dbhandler.setCardAsNotActive(Integer.parseInt(questionIDsDB.get(i).toString()), user2);
			}
			
		}
		
	}


	
}
