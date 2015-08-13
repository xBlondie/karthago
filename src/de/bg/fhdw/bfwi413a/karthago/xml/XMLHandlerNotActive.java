package de.bg.fhdw.bfwi413a.karthago.xml;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import de.bg.fhdw.bfwi413a.karthago.xml.CardNotActive;

public class XMLHandlerNotActive extends DefaultHandler{
	
	private List<CardNotActive> cardNotActives;
    private String tempVal;
    private CardNotActive tempCard;
 
    public XMLHandlerNotActive() {
        cardNotActives = new ArrayList<CardNotActive>();
    }
 
    public List<CardNotActive> getCards() {
        return cardNotActives;
    }
 
    // Event Handlers
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        // reset
        tempVal = "";
        if (qName.equalsIgnoreCase("employee")) {
            // create a new instance of employee
            tempCard = new CardNotActive();
        }
    }
 
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        tempVal = new String(ch, start, length);
    }
 
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("employee")) {
            // add it to the list
            cardNotActives.add(tempCard);
        } else if (qName.equalsIgnoreCase("id")) {
            tempCard.setQuestionId(Integer.parseInt(tempVal));
        } else if (qName.equalsIgnoreCase("name")) {
            tempCard.setQuestionText(tempVal);
        } else if (qName.equalsIgnoreCase("department")) {
            tempCard.setAnswerType(tempVal);
        } else if (qName.equalsIgnoreCase("type")) {
            tempCard.setAnswerText(tempVal);
    }
    }


}
