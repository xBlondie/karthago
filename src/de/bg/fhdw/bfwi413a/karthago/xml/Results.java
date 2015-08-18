/**********************************************************************************
 * ----------       LOGIN-ACTIVITY - WRITTEN BY: FRANZISKA PLATE         ----------
 * 
 * Diese Activity dient als Helferklasse zur Rückgabe von mehreren Variablen. Sie 
 * bietet dafür verschiedene Konstruktoren, die meist nur aus der XMLDomParserAnd-
 * Handler Klasse aufgerufen werden. Zusätzlich gibt es noch Setter und Getter der
 * einzelnen Variablen.
 * 
 * Klassen, mit die diese App kommuniziert sind:
 * 	 - keine
 * 
 * Nähere Informationen zu den Methoden siehe im Quellcode!
 * 
 *********************************************************************************/

package de.bg.fhdw.bfwi413a.karthago.xml;

import java.util.ArrayList;

public class Results {
		
		//INITIALIZE NECESSARY VARIABLES
		private ArrayList<String> list_ids = new ArrayList<String>();
		private ArrayList<String> list_cardfile_id = new ArrayList<String>();
		private ArrayList<String> list_answer_type = new ArrayList<String>();
		private ArrayList<String> list_Question_and_Answers = new ArrayList<String>();
		private ArrayList<String> list_correct_answers = new ArrayList<String>();
		
		private String questionForFT = new String();
		private ArrayList<String> correctAnswersForFT = new ArrayList<String>();
		
		//CONSRUCTOR FOR 3 VALUES
		public Results(ArrayList<String> list_ids, ArrayList <String> list_cardfile_id, ArrayList<String> list_answer_type){
			this.list_ids = list_ids;
			this.list_cardfile_id = list_cardfile_id;
			this.list_answer_type = list_answer_type;
		}
		
		//CONSTRUCTOR FOR 2 VALUES
		public Results(ArrayList<String> list_Question_and_Answers, ArrayList<String> list_correct_answers){
			this.list_Question_and_Answers = list_Question_and_Answers;
			this.list_correct_answers = list_correct_answers;
		}

		//CONSTRUCTOR WHEN INITIALIZING OBJECTS
		public Results() {
			// TODO Auto-generated constructor stub
		}

		// CONSTRUCTOR FOR 2 VALUES WITH DIFFERENT TYPES
		public Results(String question, ArrayList<String> correctAnswers) {
			this.questionForFT = question;
			this.correctAnswersForFT = correctAnswers;
		}

		//GETTERS FOR ALL VARIABLES
		public ArrayList<String> get_list_ids(){
			return list_ids;
			
		}
		
		public ArrayList<String> get_list_cardfile_id(){
			return list_cardfile_id;
		}
		
		public ArrayList<String> get_list_answer_type(){
			return list_answer_type;
		}
		
		public ArrayList<String> get_list_Question_and_Answers(){
			return list_Question_and_Answers;
		}
		
		public ArrayList<String> get_list_correct_answers(){
			return list_correct_answers;
		}

		public String getQuestionForFT() {
			return questionForFT;
		}

		public ArrayList<String> getCorrectAnswersForFT() {
			return correctAnswersForFT;
		}
	
}
