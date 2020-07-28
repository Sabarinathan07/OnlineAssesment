package com.sabari.test;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;





import android.os.Bundle;
import android.app.Activity;

import android.util.Log;
import android.view.Menu;


import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Topics extends Activity implements OnTopicsRetrievedListener  {
	ListView listView;
	//ArrayList<TopicNames> list = new ArrayList<TopicNames>();
	MyAdapter adapter;
	//private RequestQueue mQueue;
	ArrayList<TopicNames> topicsList;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_topics);
		listView = (ListView) findViewById(R.id.lv);
		topicsList = new ArrayList<TopicNames>();
		selectTopics();
		//mQueue = Volley.newRequestQueue(this);
		

		
	
//		list.add(new TopicNames("Mahabharatham"));
//		list.add(new TopicNames("JAVA"));		
	}



private void selectTopics() {
	
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
						
						listener.onSuccess(topicsList);
//						MyAdapter adapter = new MyAdapter(Topics.this,topicsList);
//						listView.setAdapter(adapter);
						
						
						
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
	
	//mQueue.add(stringrequest);
	 RequestHandler.getInstance(this).addToRequestQueue(stringrequest);
	
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.topics, menu);
		return true;
	}





	@Override
	public void onSuccess(ArrayList<TopicNames> topicList) {
		
		MyAdapter adapter = new MyAdapter(Topics.this,topicsList);
		listView.setAdapter(adapter);
		
	}
	







	
	
	





}
