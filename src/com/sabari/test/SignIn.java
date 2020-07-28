package com.sabari.test;

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
import android.util.Patterns;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends Activity implements OnClickListener {
	EditText name,username,password,email;
	Button start;
	ProgressDialog progressDialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_in);
		name=(EditText) findViewById(R.id.name);
		email=(EditText) findViewById(R.id.email1);
		username=(EditText) findViewById(R.id.username1);
		password=(EditText) findViewById(R.id.password1);
		
		start=(Button)findViewById(R.id.start);
		
		progressDialog = new ProgressDialog(this);
		
		start.setOnClickListener(this);
			
		
	}
	
	private void registerUser(){
		final String sName = name.getText().toString().trim();
		final String sEmail = email.getText().toString().trim();
		final String sUserName = username.getText().toString().trim();
		final String sPassword = password.getText().toString().trim();
		
		
		SharePrefManager.getInstance(getApplicationContext()).name(sUserName);

        progressDialog.setMessage("Registering user...");
        progressDialog.show();
        
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
        	Constants.URL_STU_REGISTER,
        	new Response.Listener<String>() {
        	
        	@Override
        	public void onResponse(String Response){
        		progressDialog.dismiss();
        		try {
        			JSONObject jsonObject = new JSONObject(Response);
        			
					Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_LONG).show();
					boolean isError = jsonObject.getBoolean("error");
					if(isError){
						
					}
					else{
						Intent i = new Intent(getBaseContext(),Topics.class);
						startActivity(i);
					}

					
				} catch (JSONException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
	
			}},
			new Response.ErrorListener() {
				@Override
        		public void onErrorResponse(VolleyError error){
        			progressDialog.hide();
        			Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show() ;
			}
			}	
			
        
        	){
        	@Override
        	protected Map<String, String> getParams()throws AuthFailureError {
        		Map<String, String> params = new HashMap<String, String>();
        		 params.put("name", sName);
        		 params.put("email", sEmail);
                params.put("username", sUserName);
                params.put("password", sPassword);
                return params;
        	
        }
		
		
	};
	
    RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
//	 RequestQueue requestQueue = Volley.newRequestQueue(this);
//     requestQueue.add(stringRequest);
     
	};
		
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sign_in, menu);
		return true;
	}

	@Override
	public void onClick(View view) {
		if(view == start){
			if(!validateDetails(name.getText().toString(),email.getText().toString(),username.getText().toString()))
			{
				Toast.makeText(getApplicationContext(), "Enter valid details and try again!", Toast.LENGTH_LONG).show();
			}else{	
				    if(!validateEmail(email.getText().toString())){
					     email.setError("Invalid Email");
					     email.requestFocus();
					     
				    }else{
					 
					if (!validatePassword(password.getText().toString())){
						password.setError("Invalid Password");
						password.requestFocus();
						
					}else{
						registerUser();
					}
					
					
					
					
					
				}
				
				
				
				
				
			}
			
			
			
			
		}
		
	}
	




	private boolean validateEmail(String email) {
		if(email!=null && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
			return true;
		}else{
			return false;
		}
		
	}

	protected boolean validateDetails(String name, String email,String username) {
		if(name!=null && username!=null && name.length()>3 && username.length()>3 ){
			return true;
		}else{
			return false;
		}
	}

	protected boolean validatePassword(String password) {
		if(password!=null && password.length()>7){
			return true;
		}else{
			return false;
		}
		
	}


}
