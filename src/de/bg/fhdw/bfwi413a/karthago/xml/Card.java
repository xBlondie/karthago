package de.bg.fhdw.bfwi413a.karthago.xml;

public class Card {
	
	private String questionText;
    private int questionId;
    private String answerType;
    private String answerText;
    
    public Card (){
    	
    }
    
    public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getAnswerType() {
		return answerType;
	}

	public void setAnswerType(String answerType) {
		this.answerType = answerType;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
	
	public String getDetails() {
        String result = questionId + ": " + questionText + "\n" + answerType + "-" 
        		+ answerText;
        return result;
    }

}
