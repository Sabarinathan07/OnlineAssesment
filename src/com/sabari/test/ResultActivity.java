package com.sabari.test;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;


import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class ResultActivity extends Activity {
    TextView grade,finalScore;
    Button retry,finish;
    ProgressDialog progressDialog;
  
    int quizid;
    String name;
    String date="25/05/2020";
    String sQuizid,sScore;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		grade = (TextView) findViewById(R.id.grade);
		finalScore = (TextView) findViewById(R.id.outOf);
		retry = (Button) findViewById(R.id.retry);
		finish = (Button) findViewById(R.id.finish);
		progressDialog = new ProgressDialog(this);
		quizid = SharePrefManager.getQuizId(getApplicationContext());
		name = SharePrefManager.getInstance(this).getName();
		
		
		
		
		Bundle bundle = getIntent().getExtras();
		int score = bundle.getInt("finalscore");
		
		sQuizid = Integer.toString(quizid);
		sScore = Integer.toString(score);
		date= getcurrentDateAndTime();
		
		updateResult(sQuizid,name,sScore,date);
		
		finalScore.setText("You Scored "+ score+" out of 25 ");
		
		if(score==25){
			grade.setText("Outstanding! You really an expert in Quiz!");
		}else if(score==24){
			grade.setText("Excellent! You did your Best Man!");
		}else if(score<23 && score>=20){
			grade.setText("Good! Better luck next time!");
		}else if(score<20 && score>=10){
			grade.setText("Your effort is not enough for quiz.");
		}else{
			grade.setText("You really need to work hard!");
		}
		
		retry.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(ResultActivity.this,Topics.class));
				ResultActivity.this.finish();
		
				
			}
		});
		
		finish.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				finish();
				
			}
		});		
	}
	
	
	

	private void updateResult(String quizid,String name,String score,String date ) {
		
		final String sQuizid = quizid;
		final String sName = name;
		final String sScore = score;
		final String sDate = date;
		
		
		
		progressDialog.setMessage("Updating Result...");
        progressDialog.show();
        
        StringRequest stringrequest = new StringRequest(Request.Method.POST,
        	Constants.URL_UPDATE_SCORE,
        	new Response.Listener<String>(){
        	
        	
        	

			@Override
			public void onResponse(String Response) {
				progressDialog.dismiss();
				try {
					
					JSONObject jsonobject = new JSONObject(Response);
					Toast.makeText(getApplicationContext(), jsonobject.getString("message"), Toast.LENGTH_LONG).show();
					
				} catch (JSONException e) {
						e.printStackTrace();
				}
				
				
			}
        }, 
        new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				progressDialog.hide();
    			
				
			}
		
        	
		}){

			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				Map<String, String> params = new HashMap<String, String>();
       		 params.put("quizid", sQuizid );
       		 params.put("username", sName);
               params.put("score",sScore );
               params.put("date", sDate);
               return params;
			}
        	
        	
        	
        	
        };
        
        RequestHandler.getInstance(this).addToRequestQueue(stringrequest);
		
		
	}
	 public static String getcurrentDateAndTime(){
		 
		 
		

	        Date c =  Calendar.getInstance().getTime();
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	        String formattedDate = simpleDateFormat.format(c);
	        return formattedDate;
	    }



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
		return true;
	}

}
