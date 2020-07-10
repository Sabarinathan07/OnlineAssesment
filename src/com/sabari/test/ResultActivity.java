package com.sabari.test;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends Activity {
    TextView grade,finalScore;
    Button retry;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		grade = (TextView) findViewById(R.id.grade);
		finalScore = (TextView) findViewById(R.id.outOf);
		retry = (Button) findViewById(R.id.retry);
		
		Bundle bundle = getIntent().getExtras();
		int score = bundle.getInt("finalscore");
		
		finalScore.setText("You Scored "+ score+" out of 25 ");
		
		if(score==25){
			grade.setText("Outstanding! You really an expert in Mahabhrata!");
		}else if(score==24){
			grade.setText("Excellent! You did your Best!");
		}else if(score==23){
			grade.setText("Good! Better luck next time!");
		}else{
			grade.setText("You really need to work hard!");
		}
		
		retry.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(ResultActivity.this,StudentActivity.class));
				ResultActivity.this.finish();
				
			}
		});
		
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
		return true;
	}

}
