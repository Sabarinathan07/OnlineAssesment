
package com.sabari.test;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class StudentActivity extends Activity {
	
	private QuestionLibrary mQuestionLibrary = new QuestionLibrary();
	TextView scoreView,questionView;
	Button choice1,choice2,choice3;
	
	String answer;
	int score,qnNumber;
	
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student);
		scoreView = (TextView)findViewById(R.id.score);
		questionView = (TextView)findViewById(R.id.question);
		choice1 = (Button)findViewById(R.id.choice1);
		choice2 = (Button)findViewById(R.id.choice2);
		choice3 = (Button)findViewById(R.id.choice3);
		updateQuestion();
		
		choice1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				if(choice1.getText()== answer){
					score = score+1;
					updateScore(score);
					Toast.makeText(StudentActivity.this,"correct",Toast.LENGTH_SHORT).show();
					
				      if(qnNumber == mQuestionLibrary.mQuestions.length){
				    	  Intent i =new Intent(StudentActivity.this,ResultActivity.class);
				    	  Bundle bundle = new Bundle();
				    	  bundle.putInt("finalscore",score);
				    	  i.putExtras(bundle);
				    	  StudentActivity.this.finish();
				    	  startActivity(i);
				      }else{
				    	  updateQuestion();
				      }
					
					
					
					
				}else{
					Toast.makeText(StudentActivity.this,"wrong",Toast.LENGTH_SHORT).show();
					if(qnNumber == mQuestionLibrary.mQuestions.length){
				    	  Intent i =new Intent(StudentActivity.this,ResultActivity.class);
				    	  Bundle bundle = new Bundle();
				    	  bundle.putInt("finalscore",score);
				    	  i.putExtras(bundle);
				    	  StudentActivity.this.finish();
				    	  startActivity(i);
				      }else{
				    	  updateQuestion();
				      }
					
				}
				
			}
		});
		
		
			choice2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				if(choice2.getText()== answer){
					score = score+1;
					updateScore(score);
					Toast.makeText(StudentActivity.this,"correct",Toast.LENGTH_SHORT).show();
					
				      if(qnNumber == mQuestionLibrary.mQuestions.length){
				    	  Intent i =new Intent(StudentActivity.this,ResultActivity.class);
				    	  Bundle bundle = new Bundle();
				    	  bundle.putInt("finalscore",score);
				    	  i.putExtras(bundle);
				    	  StudentActivity.this.finish();
				    	  startActivity(i);
				      }else{
				    	  updateQuestion();
				      }
					
					
					
					
				}else{
					Toast.makeText(StudentActivity.this,"wrong",Toast.LENGTH_SHORT).show();
					if(qnNumber == mQuestionLibrary.mQuestions.length){
				    	  Intent i =new Intent(StudentActivity.this,ResultActivity.class);
				    	  Bundle bundle = new Bundle();
				    	  bundle.putInt("finalscore",score);
				    	  i.putExtras(bundle);
				    	  StudentActivity.this.finish();
				    	  startActivity(i);
				      }else{
				    	  updateQuestion();
				      }
					
				}
				
			}
		});
			
			choice3.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View view) {
					if(choice3.getText()== answer){
						score = score+1;
						updateScore(score);
						Toast.makeText(StudentActivity.this,"correct",Toast.LENGTH_SHORT).show();
						
					      if(qnNumber == mQuestionLibrary.mQuestions.length){
					    	  Intent i =new Intent(StudentActivity.this,ResultActivity.class);
					    	  Bundle bundle = new Bundle();
					    	  bundle.putInt("finalscore",score);
					    	  i.putExtras(bundle);
					    	  StudentActivity.this.finish();
					    	  startActivity(i);
					      }else{
					    	  updateQuestion();
					      }
						
						
						
						
					}else{
						Toast.makeText(StudentActivity.this,"wrong",Toast.LENGTH_SHORT).show();
						if(qnNumber == mQuestionLibrary.mQuestions.length){
					    	  Intent i =new Intent(StudentActivity.this,ResultActivity.class);
					    	  Bundle bundle = new Bundle();
					    	  bundle.putInt("finalscore",score);
					    	  i.putExtras(bundle);
					    	  StudentActivity.this.finish();
					    	  startActivity(i);
					      }else{
					    	  updateQuestion();
					      }
						
					}
					
				}
			});
			
		

		
		
				
	}

	private void updateQuestion() {
		questionView.setText(mQuestionLibrary.getQuestion(qnNumber));
		choice1.setText(mQuestionLibrary.getChoice1(qnNumber));
		choice2.setText(mQuestionLibrary.getChoice2(qnNumber));
		choice3.setText(mQuestionLibrary.getChoice3(qnNumber));
		
		answer = mQuestionLibrary.getCorrectAnswer(qnNumber);
		qnNumber++;
	}
	
	private void updateScore(int a){
		scoreView.setText(""+score);
	}
		
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.student, menu);
		return true;
	}

}
