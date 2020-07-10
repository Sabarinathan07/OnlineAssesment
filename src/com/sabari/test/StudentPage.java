package com.sabari.test;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class StudentPage extends Activity {

	Button btSignIn,btLogin;
	ImageView img;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_page);
		btLogin = (Button) findViewById(R.id.btLogin);
		btSignIn = (Button) findViewById(R.id.btSign);
		img = (ImageView) findViewById(R.id.imageView1);
		
		btLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent loginIntent = new Intent(getBaseContext(),Login.class);
				startActivity(loginIntent);
				
				
			}
		});
		
		btSignIn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent SignIntent =new Intent(getBaseContext(),SignIn.class);
				startActivity(SignIntent);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.student_page, menu);
		return true;
	}

}
