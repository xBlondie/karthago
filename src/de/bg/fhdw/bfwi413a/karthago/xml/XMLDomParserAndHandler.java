/**********************************************************************************
 * ----------       LOGIN-ACTIVITY - WRITTEN BY: PASCAL THRONICKE        ----------
 * 
 * Diese Activity bildet das Bindeglied zwischen der XML-Datei und der Applikation.
 * Diese Klasse ist dafür zuständig die wichtigsten Elemente wie Karteiname,
 * Fragen und Antworten aus der XML heruaszufiltern sowie zu prüfen, ob ein XML-
 * File überhaupt existiert.
 * 
 * Klassen, mit die diese App kommuniziert sind:
 * 	 - Navigation (Aufruf der nächsten Activity)
 *   - SessionManagement (Erstellung einer Session für den User)
 *   - DatabaseHandler (Erstellung des Users, Initialisierung der Tabellen)
 * 
 * Nähere Informationen zu den Methoden siehe im Quellcode!
 * 
 *********************************************************************************/

package de.bg.fhdw.bfwi413a.karthago.xml;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.content.Context;
import android.content.res.AssetManager;


public class XMLDomParserAndHandler{ 
	//DECLARE NECESSARY VARIABLES
	private DocumentBuilderFactory mFactory = DocumentBuilderFactory.newInstance();
	private DocumentBuilder mBuilder;
	private Document mDoc;
	
	private AssetManager am;
	private ArrayList<String> list_ids;
	private ArrayList<String> list_cardfile_id;
	private ArrayList<String> list_answer_type;
	
	
	public XMLDomParserAndHandler (Context context){
		//INITIALIZE OBJECTS
		am = context.getAssets(); //ONLY THORUGH ASSETMANAGER WE GOT THE XML-FILE
		ifXMLFileExist();
		list_ids = new ArrayList<String>();
		list_cardfile_id = new ArrayList<String>();
		list_answer_type = new ArrayList<String>();
		
	}
	
	//METHOD TO CHECK IF XML FILE EXIST
	public void ifXMLFileExist(){
		try{
			mBuilder = mFactory.newDocumentBuilder();
			mDoc = mBuilder.parse(am.open("FrageXML.xml")); //ONLY USE 1 XML FILE
		}catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//METHOD TO GET ALL CARDFILE NAMES
	public ArrayList<String> getCardFileNames(){
		//INITIALIZE RETURN VARIABLE
		ArrayList<String> cardfile_names = new ArrayList<String>();
		
		//NORMALIZE MDOC [RECOMMENDED]
		mDoc.getDocumentElement().normalize();
		
		//GET NODELIST WITH ELEMENTS TAGGED CARDS
		NodeList nList = mDoc.getElementsByTagName("CardFile");
		
		//LOOP THROUGH NODELIST
		for (int temp = 0; temp < nList.getLength(); temp++) {
			//PICK ONE NODE
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;
				//ADD CARDFILE-NAME TO ARRAYLIST
				cardfile_names.add(eElement.getAttribute("name").toString());
			}
		}
		
		return cardfile_names;
	}
	
	//METHOD TO GET ALL IDs - USED TO FILL DATABASE-TABLE CARDS
	public Results getAllIDs(){
		
		mDoc.getDocumentElement().normalize();
		
		NodeList nList = mDoc.getElementsByTagName("Question");
		
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
					
					
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;
				list_ids.add(eElement.getElementsByTagName("QuestionId").item(0).getTextContent());
				list_answer_type.add(eElement.getElementsByTagName("AnswerType").item(0).getTextContent());
				
				Element eElementParent = (Element) nNode.getParentNode();
				list_cardfile_id.add(eElementParent.getAttribute("name").toString());
				
			}
		}
		//RETURN NEW OBJECT TO RETURN 3 VALUES
		return new Results(list_ids, list_cardfile_id, list_answer_type);
	}
	
	//METHOD TO GET REQUIRED QUESTION AND ANSWERS - USED FOR QUESTIONTYPE "MC"
	public Results getRequiredQuestionAnswersAndCorrectAnswers(String questionID) {
		//INITIALIZE ARRAYLISTS
		ArrayList<String> QuestionAndAnswers = new ArrayList<String>();
		ArrayList<String> CorrectAnswers = new ArrayList<String>();
		
		mDoc.getDocumentElement().normalize();
		
		NodeList nList = mDoc.getElementsByTagName("Question");
		
		 for (int j = 0; j < nList.getLength(); j++) {
	         Node nNode = nList.item(j);
	         if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	        	 Element el = (Element) nNode;
	        	 
	        	 //SEARCH ELEMENT WHOSE ELEMENT HAS THE SAME QUESTION ID AS THE SEARCHED
		         if (el.getElementsByTagName("QuestionId").item(0).getTextContent().equals(questionID)) {
		        	 
		        	  //IF FOUND THAN ADD...
		              QuestionAndAnswers.add(el.getElementsByTagName("QuestionText").item(0).getTextContent());
		              QuestionAndAnswers.add(el.getElementsByTagName("Answer1").item(0).getTextContent());
		              QuestionAndAnswers.add(el.getElementsByTagName("Answer2").item(0).getTextContent());
		              QuestionAndAnswers.add(el.getElementsByTagName("Answer3").item(0).getTextContent());
		              QuestionAndAnswers.add(el.getElementsByTagName("Answer4").item(0).getTextContent());
		              
		         }
	         
	         }
	     }
		 
		 //GET DIRECTLY INTO THE QUESTION TAG ANSWERS
		 NodeList nListAnswers = mDoc.getElementsByTagName("Answers");
		 for (int k = 0; k < nListAnswers.getLength(); k++) {
	         Node nNode = nListAnswers.item(k);
	         if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	        	 Element el_answers = (Element) nNode;
	         
	        	 Node node_answers_parent = el_answers.getParentNode();
	        	 
	        	 Element el_answers_parent = (Element) node_answers_parent;
	        	 //SEARCH FOR PARENT-ELEMENT WHOSE QUESTION ID IS THE SAME AS THE SEARCHED ONE
		         if (el_answers_parent.getElementsByTagName("QuestionId").item(0).getTextContent().equals(questionID)) {
		        	 
		        	 //IF FOUND GET THE CHILD NODES
		              NodeList ChildAnswers = el_answers.getChildNodes();
		              for(int l = 0; l < ChildAnswers.getLength(); l++){
		            	  Node nNodeAnswers = ChildAnswers.item(l);
		            	  //LOOP THROUGH THE CHILDNODES AND LOOK IF IT HAS THE ATTRIBUT "CORRECT"
		            	  if(nNodeAnswers.getNodeType() == Node.ELEMENT_NODE){
		            		  Element el_answers_deeper = (Element) nNodeAnswers;
		            		  if(el_answers_deeper.hasAttribute("correct")){
		            			  //IF IT HAS ATTRIBUT CORRECT, ADD...
		            			  CorrectAnswers.add(el_answers_deeper.getTextContent().toString());
		            		  }
		            	  }
		              
		              
		         }
	         
	         }
	     }
		 }
		 
		return new Results(QuestionAndAnswers, CorrectAnswers);
	}

	//METHOD FOR GETTING QUESTION AND CORRECT ANSWERS - USED FOR QUESTIONTYPE "FT" AND "G"
	public Results questionAndAnswersForFTAndGQuestions(String questionID){
		//INITIALIZE VARIABLES
		String Question = new String();
		ArrayList<String> CorrectAnswers = new ArrayList<String>();
		
		mDoc.getDocumentElement().normalize();
		
		NodeList nList = mDoc.getElementsByTagName("Question");
		
		for (int j = 0; j < nList.getLength(); j++) {
	         Node nNode = nList.item(j);
	         if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	        	 Element el = (Element) nNode;
	        	 //GET ELEMENT WHO HAS SAME QUESTIONID AS SEARCHED
		         if (el.getElementsByTagName("QuestionId").item(0).getTextContent().equals(questionID)) {
		        	 //GET QUESTION TEXT
		              Question = el.getElementsByTagName("QuestionText").item(0).getTextContent();
		         }
	         }
		}
		
		//GET NODELIST FROM ELEMENTS "ANSWERS"
		NodeList nListAnswers = mDoc.getElementsByTagName("Answers");
		 for (int k = 0; k < nListAnswers.getLength(); k++) {
	         Node nNode = nListAnswers.item(k);
	         if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	        	 Element el_answers = (Element) nNode;
	         
	        	 Node node_answers_parent = el_answers.getParentNode();
	        	 
	        	 Element el_answers_parent = (Element) node_answers_parent;
	        	 //LOOK FOR ELEMENT WHO HAS SAME QUESTIONID AS SEARCHED
		         if (el_answers_parent.getElementsByTagName("QuestionId").item(0).getTextContent().equals(questionID)) {
		        	 
		              NodeList ChildAnswers = el_answers.getChildNodes();
		              for(int l = 0; l < ChildAnswers.getLength(); l++){
		            	  Node nNodeAnswers = ChildAnswers.item(l);
		            	  //LOOK FOR CHILDELEMENTS WHO ARE NODES AND ADD THEM TO ARRAYLIST 
		            	  if(nNodeAnswers.getNodeType() == Node.ELEMENT_NODE){
		            		  Element el_answers_deeper = (Element) nNodeAnswers;
		            		  CorrectAnswers.add(el_answers_deeper.getTextContent().toString());
		            	  }
		              
		              
		         }
	         
		         }
	         }
		 }
		
		
		
		return new Results(Question, CorrectAnswers);
	}
	
	
	
}
