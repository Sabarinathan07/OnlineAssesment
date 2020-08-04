package com.sabari.test;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class Topics extends Activity implements OnTopicsRetrievedListener  {
	ListView listView;
	//ArrayList<TopicNames> list = new ArrayList<TopicNames>();
	MyAdapter adapter;
	TeacherAdapter teacherAdapter;
	//private RequestQueue mQueue;
	ArrayList<TopicNames> topicsList;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_topics);
		listView = (ListView) findViewById(R.id.lv);
		topicsList = new ArrayList<TopicNames>();
		
		//mQueue = Volley.newRequestQueue(this);
		Bundle bundle = getIntent().getExtras();
		int teacher = bundle.getInt("teacher");
		
		selectTopics(teacher);
		
	
//		list.add(new TopicNames("Mahabharatham"));
//		list.add(new TopicNames("JAVA"));		
	}
	
	public static int[] images = new int[]{
		R.drawable.mahabharat,R.drawable.java,R.drawable.avengers
	};



private void selectTopics(int teacher) {
	final int teacherId = teacher;
	final OnTopicsRetrievedListener listener = this;
	
	StringRequest stringrequest = new StringRequest(Request.Method.GET, Constants.URL_SELECT_TOPICS, 
			new Response.Listener<String>() {

				@Override
				public void onResponse(String response) {
					try {
						JSONArray jsonarray = new JSONArray(response);
						
						//JSONObject jsonobject = new JSONObject(response);
						
						for(int i =0; i < jsonarray.length(); i++){
							
							JSONObject jsonobject = jsonarray.getJSONObject(i);
							
							String topic,id;
							topic = jsonobject.getString("quizname");
							id= jsonobject.getString("quizid");
							
							TopicNames topicNames = new TopicNames(id, topic);
							
							
							topicsList.add(topicNames);
							
						}
						
						listener.onSuccess(topicsList,teacherId);

						
						
						
					} catch (Exception e) {
							
							e.printStackTrace();
							Log.e("response error", e.getMessage()+"err");

					}
					
				}
			
				}, new Response.ErrorListener() {

				@Override
				public void onErrorResponse(VolleyError error) {
					
					Toast.makeText(getApplicationContext(), error.getLocalizedMessage()+"server error",Toast.LENGTH_LONG).show();
					error.printStackTrace();

					
				}
			
					
			});
	
	
	 RequestHandler.getInstance(this).addToRequestQueue(stringrequest);
	
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.topics, menu);
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
	public void onSuccess(ArrayList<TopicNames> topicsList,int teacher) {
		
		int teacherId = teacher;
		if(teacherId==1){
			TeacherAdapter teacherAdapter = new TeacherAdapter(Topics.this,topicsList);
			listView.setAdapter(teacherAdapter);
			
			
		}else{
		
			
		
		MyAdapter adapter = new MyAdapter(Topics.this,topicsList);
		listView.setAdapter(adapter);
		}
	}

	}









	
	
	






