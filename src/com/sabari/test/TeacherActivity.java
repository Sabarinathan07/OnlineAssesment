package com.sabari.test;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.json.JSONException;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TeacherActivity extends Activity implements OnClickListener {
	EditText name,password;
	Button login;
	ProgressDialog progressDialog;
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teacher);
		name = (EditText)findViewById(R.id.tUsername);
		password = (EditText)findViewById(R.id.tPass);
		login=(Button)findViewById(R.id.tLogin);
		
		progressDialog = new ProgressDialog(this);
		
		login.setOnClickListener(this);
		

	}
	
	private void registerUser(){
		final String sName = name.getText().toString().trim();
		final String sPassword = password.getText().toString().trim();
		
        progressDialog.setMessage("Registering user...");
        progressDialog.show();
        
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
        	Constants.URL_STAFF_REGISTER,
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
						Intent i = new Intent(getBaseContext(),StudentActivity.class);
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
                params.put("username", sName);
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
		getMenuInflater().inflate(R.menu.teacher, menu);
		return true;
	}

	@Override
	public void onClick(View view) {
		if (view == login)
			registerUser();
//		Intent i = new Intent(getBaseContext(),StudentActivity.class);
//		startActivity(i);

		
		
	}

}
