/* **********************************************************************************************
 * @author Patrick
 * 
 * Diese Klasse dient zur Verwaltung der Config-Optionen durch den Nutzer. Ebenso kann hier der
 * Nutzer gewechselt werden und ggf. auch gelöscht werden, sofern es der User bestatigt.
 * 
 ***********************************************************************************************/
package de.bg.fhdw.bfwi413a.karthago;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import de.bg.fhdw.bfwi413a.karthago.db.DatabaseHandler;

public class ConfigActivity extends Activity  implements AdapterView.OnItemSelectedListener{
	//DECLARATION OF SPINNERS AND ADAPTERS(STRINGS.XML)
	Spinner spn_sorttyper;
    ArrayAdapter<CharSequence> adapter_sort;
    Spinner spn_lernmode;
    ArrayAdapter<CharSequence> adapter_learn;
    Spinner userlist;
    //DECLARATION OF DATABASE-INSTANCE
	DatabaseHandler dbHelper = new DatabaseHandler(this);
	Button changeUser;
	Button deleateUser;
	SessionManagement session;
	Button info;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_config);
		
		initImages();
		
		//INITIALIZE SPINNER ONE (SORT) AND IMPLEMENT LISTENER
		 	spn_sorttyper = (Spinner) findViewById(R.id.spn_sort);
	        adapter_sort = ArrayAdapter.createFromResource(this, R.array.spn_sort, android.R.layout.simple_spinner_item);
	        adapter_sort.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        spn_sorttyper.setAdapter(adapter_sort);
	        spn_sorttyper.setSelection(dbHelper.readConfigOption1());
	        spn_sorttyper.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

	            @Override
	            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
	                dbHelper.updateConfigOption1((int) parent.getItemIdAtPosition(position));
	            }

	            @Override
	            public void onNothingSelected(AdapterView<?> parent) {

	            }
	        });
	        
	        //INITIALIZE SPINNER TWO (LEARNMODE) AND IMPLEMENT LISTENER
	        spn_lernmode = (Spinner) findViewById(R.id.spn_learn);
	        adapter_learn = ArrayAdapter.createFromResource(this, R.array.spn_learn, android.R.layout.simple_spinner_item);
	        adapter_learn.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        spn_lernmode.setAdapter(adapter_learn);
	        spn_lernmode.setSelection(dbHelper.readConfigOption2());
	        spn_lernmode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

	            @Override
	            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
	            	//UPDATE SELECTED OPTION IN DATABASE
	            	dbHelper.updateConfigOption2((int) parent.getItemIdAtPosition(position));
	            }

	            @Override
	            public void onNothingSelected(AdapterView<?> parent) {

	            }
	        });
	       
	     initSpinner();
	     initDatabaseHandler();
	     loadUserlistFromDatabase();
	     initButtons();
	     session = new SessionManagement(getApplicationContext());
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
		
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		
		
	}
	
	private void initSpinner(){
		userlist = (Spinner) findViewById(R.id.spn_userlist_config);
	}
	
	private void initDatabaseHandler(){
		 dbHelper = new DatabaseHandler(getApplicationContext());
	}
	
	private void loadUserlistFromDatabase() {
		 
        // Spinner Drop down elements
        List<String> users = dbHelper.getUserList();
 
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, users);
 
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
 
        // attaching data adapter to spinner
        userlist.setAdapter(dataAdapter);
		
	}
	
	private void initButtons(){
		changeUser = (Button) findViewById(R.id.btn_changeUser);
		deleateUser = (Button) findViewById(R.id.btn_deleateUser);
		
		changeUser.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String choosedUser = userlist.getSelectedItem().toString();
				session.changeUserWithRedirectToMenu(choosedUser);;				
				
			}
		});
		
		deleateUser.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				final String user = userlist.getSelectedItem().toString();
				
					//GET CONFIRMATION OF USER TO DELEATE CHOOSED USER (ONLY IF USERNAME TYPED IN CORRECTLY)
					AlertDialog.Builder builder = new AlertDialog.Builder(ConfigActivity.this);
	            	builder.setTitle("Bitte Namen des zu löschenden Users eingeben:");

	            	// Set up the input
	            	final EditText input = new EditText(ConfigActivity.this);
	            	// Specify the type of input expected; in this case as text
	            	input.setInputType(InputType.TYPE_CLASS_TEXT);
	            	builder.setView(input);

	            	// Set up the buttons
	            	builder.setPositiveButton("Löschen", new DialogInterface.OnClickListener() { 
	            	    @Override
	            	    public void onClick(DialogInterface dialog, int which) {
	            	    	if (input.getText().toString().length() > 0) {
	            	    		if(user.equals("ADMIN")){
	            					Toast.makeText(getApplicationContext(), "User ADMIN kann nicht gelöscht werden", Toast.LENGTH_LONG).show();
	            				}else{
		            				if (user.equals(input.getText().toString())){
		            					//DELEATE ROW IN DATABASE
		            					dbHelper.deleateUser(user);
		            					Toast.makeText(getApplicationContext(), "User wurde erfolgreich gelöscht!",
			                                    Toast.LENGTH_SHORT).show();
		            					if(user.equals(session.getUserDetails())){
		            						//"LOGOUT" TO DELEATE SESSION AND USER FINALLY
			            					session.logoutUser();
		            					}else{
		            						//RELOAD SPINNER
			            					loadUserlistFromDatabase();
		            					}
		            				}else{
		            					Toast.makeText(getApplicationContext(), "Abweichungen im Namen erkannt. User konnte nicht gelöscht werden!",
			                                    Toast.LENGTH_SHORT).show();
		            				}
	            				}
	            	    		
	            	    	}else{
	            	    		Toast.makeText(getApplicationContext(), "Keinen User eingegeben. Löschvorgang abgebrochen.",
	                                    Toast.LENGTH_SHORT).show();
	            	    	}
	            	    	
	            	    }
	            	});
	            	builder.setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {
	            	    @Override
	            	    public void onClick(DialogInterface dialog, int which) {
	            	        dialog.cancel();
	            	    }
	            	});

	            	builder.show();
					
				}
				
			
		});
	}
	
	private void initImages(){
		 info = (Button) findViewById(R.id.info);
		 info.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(ConfigActivity.this);
				builder.setTitle("Über diese App");
				TextView myMsg = new TextView(ConfigActivity.this);
				myMsg.setText("Version 1.0.0 \n \n Diese App wurde programmiert von: \n Leonie Schiburr \n Julia Körvers \n Franziska Plate \n An-Nam Pham \n Vasilij Schneidermann \n Pascal Thronicke \n Fynn-Ole Callsen \n Patrick Künzl");
				myMsg.setGravity(Gravity.CENTER_HORIZONTAL);
				builder.setView(myMsg);
				// Add the buttons
				builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
				           public void onClick(DialogInterface dialog, int id) {
				               dialog.cancel();
				           }
				       });
				
				// Create the AlertDialog
				builder.show();
				
			}
		});
	}
	
	
	
}
