package com.sabari.test;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignIn extends Activity {
	EditText name,username,pass,cnfmpass;
	Button start;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_in);
		name=(EditText) findViewById(R.id.name);
		username=(EditText) findViewById(R.id.username1);
		pass=(EditText) findViewById(R.id.pass);
		cnfmpass=(EditText) findViewById(R.id.cnfmPass);
		start=(Button)findViewById(R.id.start);
		
		start.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent start = new Intent(getBaseContext(),StudentActivity.class);
				startActivity(start);
			}
		});
	}
		
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sign_in, menu);
		return true;
	}

}
