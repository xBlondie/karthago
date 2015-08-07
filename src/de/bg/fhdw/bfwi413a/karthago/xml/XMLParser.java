package de.bg.fhdw.bfwi413a.karthago.xml;

import java.io.InputStream;
import java.util.List;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import de.bg.fhdw.bfwi413a.karthago.xml.Card;
import android.util.Log;

public class XMLParser {
	
	public static List<Card> parse(InputStream is) {
        List<Card> cards = null;
        try {
            // create a XMLReader from SAXParser
            XMLReader xmlReader = SAXParserFactory.newInstance().newSAXParser()
                    .getXMLReader();
            // create a SAXXMLHandler
            XMLHandler saxHandler = new XMLHandler();
            // store handler in XMLReader
            xmlReader.setContentHandler(saxHandler);
            // the process starts
            xmlReader.parse(new InputSource(is));
            // get the `Employee list`
            cards = saxHandler.getCards();
 
        } catch (Exception ex) {
            Log.d("XML", "XMLParser: parse() failed");
        }
 
        // return Employee list
        return cards;
    }
}
