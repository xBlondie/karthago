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
import de.bg.fhdw.bfwi413a.karthago.SessionManagement;


public class XMLDomParserAndHandler{ //SCHAUEN OB ES AUCH OHNE EXTENDS GEHT!!!! Wichtig, Klasse muss von Activity erben für AssetManager
	
	DocumentBuilderFactory mFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder mBuilder;
	Document mDoc;
	
	//@auhtor Patrick
	private AssetManager am;
	SessionManagement session;
	ArrayList<String> list_ids;
	ArrayList<String> list_cardfile_id;
	ArrayList<String> list_answer_type;
	
	
	// END @author Patrick
	
	public XMLDomParserAndHandler (Context context){ // immer schön auf den Context aufpassen!!!! ;-) am besten übergeben wo der Construktor gestartet wird
		//@author Patrick
		
		session = new SessionManagement(context);
		am = context.getAssets();
		ifXMLFileExist();
		list_ids = new ArrayList<String>();
		list_cardfile_id = new ArrayList<String>();
		list_answer_type = new ArrayList<String>();
		// END @ author Patrick
		
	}

//	public Document getmDoc() {
//		return mDoc;
//	}
	
	//@author Patrick
	
	
	public void ifXMLFileExist(){
		try{
			mBuilder = mFactory.newDocumentBuilder();
			mDoc = mBuilder.parse(am.open("FrageXML.xml")); //Wir benutzen nur 1! XML-File, das hier als Dateinamen angegeben wird.
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
	
	
	
	public ArrayList<String> getCardFileNames(){
		ArrayList<String> cardfile_names = new ArrayList<String>();
		
		mDoc.getDocumentElement().normalize();
		
		NodeList nList = mDoc.getElementsByTagName("Cards");
		
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
					
					
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;
				cardfile_names.add(eElement.getElementsByTagName("CardFile").item(0).getTextContent());
			}
		}
		
		return cardfile_names;
	}
	
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
				list_cardfile_id.add(eElementParent.getElementsByTagName("CardFile").item(0).getTextContent());
				
			}
		}
		
		return new Results(list_ids, list_cardfile_id, list_answer_type);
	}
	
	public ArrayList<String> getQuestionTypes(ArrayList<String> requieredQuestionsID){
		ArrayList<String> questionTypes = new ArrayList<String>();
		
		
		
		return questionTypes;
	}
	
	public Results getRequiredQuestionAnswersAndCorrectAnswers(String questionID) {
		ArrayList<String> QuestionAndAnswers = new ArrayList<String>();
		ArrayList<String> CorrectAnswers = new ArrayList<String>();
		
		mDoc.getDocumentElement().normalize();
		
		NodeList nList = mDoc.getElementsByTagName("Question");
		
		 for (int j = 0; j < nList.getLength(); j++) {
	         Node nNode = nList.item(j);
	         if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	        	 Element el = (Element) nNode;
	         
		         if (el.getElementsByTagName("QuestionId").item(0).getTextContent().equals(questionID)) {
		        	 
		        	 Node nNodeParent = el.getParentNode();
		        	 Element el_new = (Element) nNodeParent;
		        	 
		              QuestionAndAnswers.add(el_new.getElementsByTagName("QuestionText").item(0).getTextContent());
		              QuestionAndAnswers.add(el_new.getElementsByTagName("Answer1").item(0).getTextContent());
		              QuestionAndAnswers.add(el_new.getElementsByTagName("Answer2").item(0).getTextContent());
		              QuestionAndAnswers.add(el_new.getElementsByTagName("Answer3").item(0).getTextContent());
		              QuestionAndAnswers.add(el_new.getElementsByTagName("Answer4").item(0).getTextContent());
		              
		         }
	         
	         }
	     }
		 //author: Leonie
		 //Da wir die Kindsknoten(Answer1 usw) von Answers brauchen wird ein Knoten mit der
		 //ersten Frage erzeugt
		 // über getNextSibling wird über alle Antwortmöglichkeiten iteriert
		 // bevor wir mit dem Kindsknoten weiterarbeiten können, müssen wir prüfen, ob es sich wirklich um
		 // ein ELEMENT_NODE handelt
		 // danach kann die richtige Antwort über das Attribut "correct" ermittelt und zugewiesen
		 NodeList nListAnswers = mDoc.getElementsByTagName("Answers");
		 Node nNodePossible = nListAnswers.item(0);
		 Element e_possible = (Element) nNodePossible;
		 Node childNode = e_possible.getFirstChild();       
		        
		 while(childNode.getNextSibling()!=null ){          
		        childNode = childNode.getNextSibling();         
		        if (childNode.getNodeType() == Node.ELEMENT_NODE) {
		        	int k = 0;
		            Element childElement = (Element) childNode;             
		            if(childElement.hasAttribute("correct")){
		            	CorrectAnswers.add(childElement.getTextContent());
		            	k++;
		            	System.out.println("Durchlauf IF-Bedingung: " + k);
		            }
		     }       
		 }
		 
		return new Results(QuestionAndAnswers, CorrectAnswers);
	}
	
	// ---- END @author Patrick ----

	
}
