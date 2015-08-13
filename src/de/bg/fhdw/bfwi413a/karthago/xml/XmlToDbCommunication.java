//@author Patrick
package de.bg.fhdw.bfwi413a.karthago.xml;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import android.content.Context;
import de.bg.fhdw.bfwi413a.karthago.SessionManagement;
import de.bg.fhdw.bfwi413a.karthago.db.DatabaseHandler;

public class XmlToDbCommunication{

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
	
	private void copyCardFileNamesIntoDB() {
		allCardFileNames = xmldomhandler.getCardFileNames();
		for (int i = 0; i < allCardFileNames.size(); i++){
			dbhandler.insertCardFileNames(allCardFileNames.get(i).toString());
		}
		
	}
	
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
	
	public void initializeAtFirstStart(){
		boolean first_start;
		first_start = dbhandler.FirstStart(session.getUserDetails().toString());
		if(first_start == true){
			copyCardFileNamesIntoDB();
			copyIDsOfXMLToDB();
			dbhandler.updateFirstStart(session.getUserDetails().toString());
			
		}
	}
	
	
}
