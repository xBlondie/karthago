package de.bg.fhdw.bfwi413a.karthago.xml;

import java.io.IOException;
import java.util.List;


import de.bg.fhdw.bfwi413a.karthago.R;
import de.bg.fhdw.bfwi413a.karthago.xml.Card;
import de.bg.fhdw.bfwi413a.karthago.xml.XMLParser;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class XMLActivity extends Activity implements
OnClickListener, OnItemSelectedListener{
	
	Button button;
    Spinner spinner;
    List<Card> cards = null;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
 
        findViewsById();
        button.setOnClickListener(this);
    }
 
    private void findViewsById() {
        button = (Button) findViewById(R.id.button);
        spinner = (Spinner) findViewById(R.id.spinner);
    }
 
    public void onClick(View v) {
        try {
            cards = XMLParser.parse(getAssets().open("FrageXML.xml"));
            ArrayAdapter<Card> adapter = new ArrayAdapter<Card>(this,
                    R.layout.list_item, cards);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos,
            long id) {
        Card card = (Card) parent.getItemAtPosition(pos);
        Toast.makeText(parent.getContext(), card.getDetails(),
                Toast.LENGTH_LONG).show();
    }
 
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    }

}
