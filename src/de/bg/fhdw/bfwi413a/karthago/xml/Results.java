package de.bg.fhdw.bfwi413a.karthago.xml;

import java.util.ArrayList;

public class Results {
	
		private ArrayList<String> list_ids = new ArrayList<String>();
		private ArrayList<String> list_cardfile_id = new ArrayList<String>();
		private ArrayList<String> list_answer_type = new ArrayList<String>();
		private ArrayList<String> list_Question_and_Answers = new ArrayList<String>();
		private ArrayList<String> list_correct_answers = new ArrayList<String>();
		
		public Results(ArrayList<String> list_ids, ArrayList <String> list_cardfile_id, ArrayList<String> list_answer_type){
			this.list_ids = list_ids;
			this.list_cardfile_id = list_cardfile_id;
			this.list_answer_type = list_answer_type;
		}
		
		public Results(ArrayList<String> list_Question_and_Answers, ArrayList<String> list_correct_answers){
			this.list_Question_and_Answers = list_Question_and_Answers;
			this.list_correct_answers = list_correct_answers;
		}

		public Results() {
			// TODO Auto-generated constructor stub
		}


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
	
}
