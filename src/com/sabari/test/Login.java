package com.sabari.test;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;


public class Login extends Activity implements OnClickListener {
	private EditText username,password;
	private Button start;
	private ProgressDialog progressDialog;
	
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		username = (EditText)findViewById(R.id.username);
		password=(EditText)findViewById(R.id.pass);
		start = (Button)findViewById(R.id.start);
		
		progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");

        
		start.setOnClickListener(this);
	}
	
	public void CheckConnection(){
		ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo nInfo = cm.getActiveNetworkInfo();
		if(null!=nInfo){
			userLogin();
		}else{
			Toast.makeText(getApplicationContext(), "Please check your Internet connection and Try again! ", Toast.LENGTH_LONG).show();
		}
	}
    
	
	private void userLogin(){
	    final String sUsername = username.getText().toString().trim();
        final String sPassword = password.getText().toString().trim();

        progressDialog.show();

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Constants.URL_STU_LOGIN,
                new Response.Listener<String>() {
                	@Override
                	public void onResponse(String response) {
                		progressDialog.dismiss();
                		try {
                			JSONObject obj = new JSONObject(response);
                			if(!obj.getBoolean("error")){
                				SharePrefManager.getInstance(getApplicationContext())
                				.userLogin(
                                        obj.getInt("id"),
                                        obj.getString("username"),
                                        obj.getString("email")
                						);
                				
                				 SharePrefManager.getInstance(getApplicationContext()).name(obj.getString("username"));
                			
                				
                				
                				Toast.makeText(getApplicationContext(), "Student login successful!!", Toast.LENGTH_LONG).show();
                				
                				boolean isError = obj.getBoolean("error");
            					if(isError){
            						
            					}
            					else{
            						
            						Intent i = new Intent(getBaseContext(),Topics.class);
            			        	Bundle bundle = new Bundle();
            				    	bundle.putInt("teacher",0);
            				    	i.putExtras(bundle);
            						startActivity(i);
            						
            					}
                			
                		}else{
                					Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_LONG).show();
                			}
                			
                			
						} catch (JSONException e) {
							
							e.printStackTrace();
							
						}
      	
                	}
				
                	
				},
				new Response.ErrorListener() {
			

					@Override
					public void onErrorResponse(VolleyError error) {
						Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();							
					};
				}
				){
				
					@Override
					protected Map<String, String> getParams()
							throws AuthFailureError {
							Map<String, String> params = new HashMap<String, String>();
							params.put("username", sUsername);
							params.put("password",sPassword);
						
						return params;
					}
					
					
				};
//				  RequestQueue requestQueue = Volley.newRequestQueue(this);
//			        requestQueue.add(stringRequest);
			        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);

				
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public void onClick(View view) {
		if(view==start)
			CheckConnection();
			
		
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		
			case R.id.action_settings:
				Toast.makeText(this, "You Clicked Settings", Toast.LENGTH_LONG).show();
		
		}
		
		return true;
	}

}
