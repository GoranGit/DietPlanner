package com.gak.dietplanner;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.RadioButton;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
	}
	
	public void submitFunction(View view)
	{
		float idealresult = 0;
		String opis="" ;
		float kalorii = 0;
		
		EditText height = (EditText)findViewById(R.id.height);
		String he =height.getText().toString();
		if(he.equals(""))
		{
			alertMessage();
			return;
			
		}
		
		
		int h = Integer.parseInt(he);
		
		
		EditText weight = (EditText)findViewById(R.id.weight);
		String we =weight.getText().toString();
		if(we.equals(""))
		{
			alertMessage();
			return;
				
		}
		int w = Integer.parseInt(we);
		
		
		
		kalorii=w*24;	
		
		RadioButton rbm = (RadioButton)findViewById(R.id.male);
		RadioButton rbf = (RadioButton)findViewById(R.id.female);
		
		if(rbm.isChecked())
		{
			idealresult = h-100;
			float slab = idealresult/10;
			if(idealresult - w > slab)
			{
				
			
			opis="Vasata dnevna potrosuvacka na kalorii e "+kalorii+" za da se popravite potrebno e da vnesuvate poveke kalorii";
			
			
			}
			if(slab*2 < w-idealresult)
				
			{
			opis="Vie imate visok kilogrami, za da se oslobodite od niv koristete nekoja dieta so pomalku od "+kalorii+" kalorii dnevno";
			}
			
			if(slab*2 > w-idealresult && idealresult - w < slab )
				
			{
			opis="Vie nemate problem so kilogramite.Vasata dnevna potrosuvacka na kalorii e "+kalorii+"cal";
			}
			
		}
		else 
		if(rbf.isChecked())
		{
			idealresult = h-110;
			float slab = idealresult/10;
			if(idealresult - w > slab)
			{
				
			
				opis="Vasata dnevna potrosuvacka na kalorii e "+kalorii+" za da se popravite potrebno e da vnesuvate poveke kalorii";
				
			
			}
			if(slab*2 < w-idealresult)
				
			{
				opis="Vie imate visok kilogrami, za da se oslobodite od niv koristete nekoja dieta so pomalku od "+kalorii+" kalorii dnevno";
				}
			
			if(slab*2 > w-idealresult && idealresult - w < slab )
				
			{
				opis="Vie nemate problem so kilogramite.Vasata dnevna potrosuvacka na kalorii e "+kalorii+"cal";
				}
			
		}
		else
		{
			alertMessage();
			return;
		}
		
		Intent intent = new Intent(this,DietList.class);
		intent.putExtra("opis", opis);
		startActivity(intent);
		
		
		
	}
	
	public void alertMessage()
	{
		AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
		alt_bld.setMessage("Please fill all fields")
		.setCancelable(false)
		
		.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int id) {
		//  Action for 'NO' Button
		dialog.cancel();
		}
		});
		AlertDialog alert = alt_bld.create();
		// Title for AlertDialog
		alert.setTitle("Error!");
		// Icon for AlertDialog
		
		alert.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
}
