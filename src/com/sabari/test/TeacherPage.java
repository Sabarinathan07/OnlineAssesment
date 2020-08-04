package com.sabari.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;

public class TeacherPage extends Activity implements OnResultsRetrievedListener {
	ListView listview;
	ResultAdapter resultAdapter;
	ArrayList<ResultInfo> resultlist;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teacher_page);
		listview = (ListView) findViewById(R.id.listView1);
		resultlist = new ArrayList<ResultInfo>();
		
		Bundle bundle = getIntent().getExtras();
		int result = bundle.getInt("result");
		String res = Integer.toString(result);
		
		viewResult(res);
	}

	private void viewResult(String res) {
		
		final String result = res;
		final OnResultsRetrievedListener listener = this;
		
		StringRequest stringrequest = new StringRequest(Request.Method.POST, Constants.GET_RESULT,
				new Response.Listener<String>() {

					@Override
					public void onResponse(String response) {
						try {
							
							JSONArray jsonarray = new JSONArray(response);
														
							for(int i =0; i < jsonarray.length(); i++){
								
								JSONObject jsonobject = jsonarray.getJSONObject(i);
								
								String quizid,username,score,date;
								quizid = jsonobject.getString("quizid");
								username= jsonobject.getString("username");
								score = jsonobject.getString("score");
								date = jsonobject.getString("date");
								
								ResultInfo resultObj = new ResultInfo(quizid, username,score,date);
								
								
								resultlist.add(resultObj);
								
							}
							
							listener.onSuccess2(resultlist);
							
						} catch (Exception e) {
							
							e.printStackTrace();
						}
						
					}
			
			
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						Toast.makeText(getApplicationContext(), error.getLocalizedMessage()+"server error",Toast.LENGTH_LONG).show();
						error.printStackTrace();
						
					}
				}){

					@Override
					protected Map<String, String> getParams()
							throws AuthFailureError {
						Map<String,String> params = new HashMap<String, String>();
						params.put("quizid",result);
						
						
						return params;
					}
					
			
			
			
		};
		
		 RequestHandler.getInstance(this).addToRequestQueue(stringrequest);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.teacher_page, menu);
		return true;
	}



	@Override
	public void onSuccess2(ArrayList<ResultInfo> resulList) {
		ResultAdapter resultAdapter = new ResultAdapter(TeacherPage.this,resulList);
		listview.setAdapter(resultAdapter);
		
	}

}
