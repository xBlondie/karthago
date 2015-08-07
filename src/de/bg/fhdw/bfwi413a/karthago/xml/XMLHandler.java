package de.bg.fhdw.bfwi413a.karthago.xml;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import de.bg.fhdw.bfwi413a.karthago.xml.Card;

public class XMLHandler extends DefaultHandler{
	
	private List<Card> cards;
    private String tempVal;
    private Card tempCard;
 
    public XMLHandler() {
        cards = new ArrayList<Card>();
    }
 
    public List<Card> getCards() {
        return cards;
    }
 
    // Event Handlers
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        // reset
        tempVal = "";
        if (qName.equalsIgnoreCase("employee")) {
            // create a new instance of employee
            tempCard = new Card();
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
            cards.add(tempCard);
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
