package com.sabari.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;



public class QuizActivity extends Activity implements onQuestionsRetrievedListener {
	TextView scoreView,questionView;
	Button choice1,choice2,choice3,quit;
	//private RequestQueue mQueue;
	ArrayList<Question> qnlist;
	int score,qnNumber;
	String answer;
	String quizid;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);
		scoreView = (TextView)findViewById(R.id.score);
		questionView = (TextView)findViewById(R.id.question);
		choice1 = (Button)findViewById(R.id.choice1);
		choice2 = (Button)findViewById(R.id.choice2);
		choice3 = (Button)findViewById(R.id.choice3);
		quit = (Button)findViewById(R.id.quit);
		//mQueue = Volley.newRequestQueue(this);
		qnlist = new ArrayList<Question>();
		
		Bundle bundle = getIntent().getExtras();
		int id = bundle.getInt("topic1");
		
		SharePrefManager.getInstance(getApplicationContext()).quizid(id);
		
		quizid = Integer.toString(id);
		
		CheckConnection();
		
		
		

	}
	
	public void CheckConnection(){
		ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo nInfo = cm.getActiveNetworkInfo();
		if(null!=nInfo){
			updateQuestion();
		}else{
			Toast.makeText(getApplicationContext(), "Please check your Internet connection and Try again! ", Toast.LENGTH_LONG).show();
		}
	}
	


	private void updateQuestion() {
		
		final onQuestionsRetrievedListener listener = this;
		StringRequest stringrequest = new StringRequest(Request.Method.POST, Constants.URL_QUESTIONS , 
				new Response.Listener<String>() {

					@Override
					public void onResponse(String response) {
						try {
							JSONArray jsonarray = new JSONArray(response);
							
							
							 for (int i = 0; i < jsonarray.length(); i++){
								 
								 
								JSONObject questionObject = jsonarray.getJSONObject(i);
								String question,questionid,answers,choice1,choice2,choice3;
								question = questionObject.getString("question");
								questionid = questionObject.getString("questionid");
								answers = questionObject.getString("answer");
								//quizid = questionObject.getString("quizid");
								choice1 = questionObject.getString("choice1");
								choice2 = questionObject.getString("choice2");
								choice3 = questionObject.getString("choice3");
								
								Question question1 = new Question(question, questionid, answers, choice1, choice2, choice3);
								
								qnlist.add(question1);
								//listener.onSucess1(qnlist);
								
							 
							 }	
								
							 listener.onSucess1(qnlist);
							
	                				
	                				
	                                        
	                                       
	                						
							
						              
							 
						}	
					
						 catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						  
						
						
					}
			
				}, new  Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
					 error.printStackTrace();
						
					}
					
					
				}){

					@Override
					protected Map<String, String> getParams()
							throws AuthFailureError {
						
								Map<String,String> params = new HashMap<String, String>();
								params.put("quizid",quizid);
						
						
						return params;
					}
			
			
			
					
					
					
			
			
			
		};
		
		//mQueue.add(stringrequest);
		 RequestHandler.getInstance(this).addToRequestQueue(stringrequest);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		getMenuInflater().inflate(R.menu.quiz, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
			case R.id.menuLogout:
				SharePrefManager.getInstance(this).logout();
				finish();
				startActivity(new Intent(this,MainActivity.class ));
				Toast.makeText(this, "Your Account is Succesfully logged out", Toast.LENGTH_LONG).show();
				break;
			case R.id.action_settings:
				Toast.makeText(this, "You Clicked Settings", Toast.LENGTH_LONG).show();
		
		}
		
		return true;
	}

	@Override
	public void onSucess1(ArrayList<Question> questionList) {
//		int i = 0;
//		while(i<qnlist.size()){
//		Question qns = qnlist.get(i);
//		}	
		nextQuestion();
		
		
		
		choice1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				if(choice1.getText().equals(answer)){
					score = score+1;
					updateScore(score);
					
						
							
					  if(qnNumber == qnlist.size()){
				    	  Intent i =new Intent(QuizActivity.this,ResultActivity.class);
				    	  Bundle bundle = new Bundle();
				    	  bundle.putInt("finalscore",score);
				    	  i.putExtras(bundle);
				    	  QuizActivity.this.finish();
				    	  startActivity(i);
				      }else{
				    	  nextQuestion();
				      }
					
					
					
					
				}else{
					
					
					
					 if(qnNumber == qnlist.size()){
				    	  Intent i =new Intent(QuizActivity.this,ResultActivity.class);
				    	  Bundle bundle = new Bundle();
				    	  bundle.putInt("finalscore",score);
				    	  i.putExtras(bundle);
				    	  QuizActivity.this.finish();
				    	  startActivity(i);
				      }else{
				    	  nextQuestion();
				      }
					
					
					
					
					
				}
				
			}
		});
		
		
	   
		
	
		
		choice2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				if(choice2.getText().equals(answer)){
					score = score+1;
					updateScore(score);
					
						
							
					  if(qnNumber == qnlist.size()){
				    	  Intent i =new Intent(QuizActivity.this,ResultActivity.class);
				    	  Bundle bundle = new Bundle();
				    	  bundle.putInt("finalscore",score);
				    	  i.putExtras(bundle);
				    	  QuizActivity.this.finish();
				    	  startActivity(i);
				      }else{
				    	  nextQuestion();
				      }
					
					
					
					
				}else{
					
				
					
					 if(qnNumber == qnlist.size()){
				    	  Intent i =new Intent(QuizActivity.this,ResultActivity.class);
				    	  Bundle bundle = new Bundle();
				    	  bundle.putInt("finalscore",score);
				    	  i.putExtras(bundle);
				    	  QuizActivity.this.finish();
				    	  startActivity(i);
				      }else{
				    	  nextQuestion();
				      }
					
					
					
					
					
				}
				
			}
		});
		
		
		choice3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				if(choice3.getText().equals(answer)){
					score = score+1;
					updateScore(score);
					
						
							
					  if(qnNumber == qnlist.size()){
				    	  Intent i =new Intent(QuizActivity.this,ResultActivity.class);
				    	  Bundle bundle = new Bundle();
				    	  bundle.putInt("finalscore",score);
				    	  i.putExtras(bundle);
				    	  QuizActivity.this.finish();
				    	  startActivity(i);
				      }else{
				    	  nextQuestion();
				      }
					
					
					
					
				}else{
					
					
					
					 if(qnNumber == qnlist.size()){
				    	  Intent i =new Intent(QuizActivity.this,ResultActivity.class);
				    	  Bundle bundle = new Bundle();
				    	  bundle.putInt("finalscore",score);
				    	  i.putExtras(bundle);
				    	  QuizActivity.this.finish();
				    	  startActivity(i);
				      }else{
				    	  nextQuestion();
				      }
					
					
					
					
					
				}
				
			}
		});
		
		
		quit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
								
				  Intent i =new Intent(QuizActivity.this,ResultActivity.class);
		    	  Bundle bundle = new Bundle();
		    	  bundle.putInt("finalscore",score);
		    	  i.putExtras(bundle);
		    	  QuizActivity.this.finish();
		    	  startActivity(i);
						
			}
		});
		
	}
	
	private void nextQuestion(){
	    questionView.setText(qnNumber+1 +". "+qnlist.get(qnNumber).getQuestion());
		choice1.setText(qnlist.get(qnNumber).getChoice1());
		choice2.setText(qnlist.get(qnNumber).getChoice2());
		choice3.setText(qnlist.get(qnNumber).getChoice3());
		
		answer = qnlist.get(qnNumber).getAnswers();
		
		qnNumber++;
						
		}
	
	private void updateScore(int a){
		scoreView.setText(score+"/25");
	}



}
