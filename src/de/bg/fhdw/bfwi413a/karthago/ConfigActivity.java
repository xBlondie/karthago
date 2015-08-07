//created by Patrick
package de.bg.fhdw.bfwi413a.karthago;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import de.bg.fhdw.bfwi413a.karthago.ku.db.DatabaseHandlerConfig;

public class ConfigActivity extends Activity  implements AdapterView.OnItemSelectedListener{
	//Declaration of Spinner and ArrayAdapters (strings.xml);
	Spinner spn_sorttyper;
    ArrayAdapter<CharSequence> adapter_sort;
    Spinner spn_lernmode;
    ArrayAdapter<CharSequence> adapter_learn;
	SQLiteDatabase configDB;
	DatabaseHandlerConfig dbHelper = new DatabaseHandlerConfig(this);
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_config);
		
		//Initialize Spinner One (Sorttyp) and Implemented SelectedListener
		 	spn_sorttyper = (Spinner) findViewById(R.id.spn_sort);
	        adapter_sort = ArrayAdapter.createFromResource(this, R.array.spn_sort, android.R.layout.simple_spinner_item);
	        adapter_sort.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        spn_sorttyper.setAdapter(adapter_sort);
	        spn_sorttyper.setSelection(dbHelper.readConfigOption1());
	        spn_sorttyper.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

	            @Override
	            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
	                dbHelper.updateConfigOption1(configDB, (int) parent.getItemIdAtPosition(position));
	            }

	            @Override
	            public void onNothingSelected(AdapterView<?> parent) {

	            }
	        });
	        
	        //Initialize Spinner Two (Learntyp) and Implemented SelectedListener
	        spn_lernmode = (Spinner) findViewById(R.id.spn_learn);
	        adapter_learn = ArrayAdapter.createFromResource(this, R.array.spn_learn, android.R.layout.simple_spinner_item);
	        adapter_learn.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        spn_lernmode.setAdapter(adapter_learn);
	        spn_lernmode.setSelection(dbHelper.readConfigOption2());
	        spn_lernmode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

	            @Override
	            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
	            	dbHelper.updateConfigOption2(configDB, (int) parent.getItemIdAtPosition(position));
	            }

	            @Override
	            public void onNothingSelected(AdapterView<?> parent) {

	            }
	        });
	        
	        //DB-Manager
	        configDB = dbHelper.getWritableDatabase();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.config, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
