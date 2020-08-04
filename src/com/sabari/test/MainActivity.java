package com.sabari.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    Button btStudent,btTeacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btStudent = (Button) findViewById(R.id.btStudent);
        btTeacher = (Button) findViewById(R.id.btTeacher);
       
        
        if(SharePrefManager.getId(getApplicationContext())!=0){
        	Intent i = new Intent(getBaseContext(),Topics.class);
        	Bundle bundle = new Bundle();
	    	bundle.putInt("teacher",0);
	    	i.putExtras(bundle);
			startActivity(i);
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
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		
			case R.id.action_settings:
				Toast.makeText(this, "You Clicked Settings", Toast.LENGTH_LONG).show();
		
		}
		
		return true;
	}

}
