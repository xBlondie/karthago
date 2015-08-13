package de.bg.fhdw.bfwi413a.karthago.xml;

import java.io.InputStream;
import java.util.List;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import de.bg.fhdw.bfwi413a.karthago.xml.CardNotActive;
import android.util.Log;

public class XMLParserNotActive {
	
	public static List<CardNotActive> parse(InputStream is) {
        List<CardNotActive> cardNotActives = null;
        try {
            // create a XMLReader from SAXParser
            XMLReader xmlReader = SAXParserFactory.newInstance().newSAXParser()
                    .getXMLReader();
            // create a SAXXMLHandler
            XMLHandlerNotActive saxHandler = new XMLHandlerNotActive();
            // store handler in XMLReader
            xmlReader.setContentHandler(saxHandler);
            // the process starts
            xmlReader.parse(new InputSource(is));
            // get the `Employee list`
            cardNotActives = saxHandler.getCards();
 
        } catch (Exception ex) {
            Log.d("XML", "XMLParser: parse() failed");
        }
 
        // return Employee list
        return cardNotActives;
    }
}
