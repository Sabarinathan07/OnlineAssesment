package com.sabari.test;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.toolbox.JsonObjectRequest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    Button btStudent,btTeacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btStudent = (Button) findViewById(R.id.btStudent);
        btTeacher = (Button) findViewById(R.id.btTeacher);
        
        if(SharePrefManager.getId(getApplicationContext())!=0){
        	Intent studentIntent = new Intent(getBaseContext(),Topics.class);
			startActivity(studentIntent);
        }
        
        btStudent.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent studentIntent = new Intent(getBaseContext(),StudentPage.class);
				startActivity(studentIntent);
				
				
			}
		});
        
        btTeacher.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent teacherIntent = new Intent(getBaseContext(),TeacherActivity.class);
				startActivity(teacherIntent);
				
			}
		});
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
//    private void getQuestions(String response){
//    	JsonObjectRequest
//    	
//    	ArrayList<Question> list = new ArrayList<Question>();
//    	try {
//			JSONArray array = new JSONArray(response);
//			for(int i = 0; i<array.length(); i++){
//				JSONObject questionJSonObj = array.getJSONObject(i);
//				String question,choice1,choice2,choice3,answer;
//				Question question = new Question(question,choice1,choice2,choice3,answer);
//				list.add(question);
//			}
//			
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    }
    
}
