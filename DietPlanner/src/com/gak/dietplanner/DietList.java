package com.gak.dietplanner;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class DietList extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_diet_list);
		
		Intent intent = getIntent();
		String str = intent.getExtras().getString("opis").toString();
		TextView txt =(TextView) findViewById(R.id.text);
		txt.setText(str);
		
		
		String []myStringArray = {"1000Calories","1100Calories","1200Calories","1500Calories"};
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_items, myStringArray);
		
		ListView listView = (ListView) findViewById(R.id.dietlist);
		listView.setAdapter(adapter);
		
		
		 final OnItemClickListener ko = new OnItemClickListener() {
			    public void onItemClick(AdapterView parent, View v, int position, long id) {
			        // Do something in response to the click
			    	Intent intent = new Intent(getBaseContext(),DietActivity.class);
			    	
			    	if(id==0)
			    	{
			    		String dieta = getResources().getString(R.string.kalori);
			    	intent.putExtra("dieta",dieta);
			    	startActivity(intent);
			    	}
			    	if(id==1)
			    	{
			    		String dieta = getResources().getString(R.string.kalorii);
			    	intent.putExtra("dieta",dieta);
			    	startActivity(intent);
			    	}
			    	if(id==2)
			    	{
			    		String dieta = getResources().getString(R.string.kaloriii);
			    	intent.putExtra("dieta",dieta);
			    	startActivity(intent);
			    	}
			    	if(id==3)
			    	{
			    		String dieta = getResources().getString(R.string.kaloriiii);
			    	intent.putExtra("dieta",dieta);
			    	startActivity(intent);
			    	}
			    	
			    }
			};

			listView.setOnItemClickListener(ko); 

		
		// Show the Up button in the action bar.
		setupActionBar();
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.diet_list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
