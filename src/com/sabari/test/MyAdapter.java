package com.sabari.test;
import android.app.Activity;
import android.content.Intent;
import java.util.ArrayList;





import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

public class MyAdapter extends BaseAdapter {
	
	 Context c = null;
	ArrayList list;
	LayoutInflater inflater;
	Button Btn;
	
	
	public MyAdapter(Context c,ArrayList<TopicNames> topicsList){
		
		this.list=topicsList;
		inflater=LayoutInflater.from(c);
		this.c=c;
		
	}
	
	@Override
	public int getCount() {
		return list.size();
	}
	@Override
	public Object getItem(int arg0) {
		return null;
	}
	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public View getView(final int pos, View arg1, ViewGroup arg2) {
		
		View v=inflater.inflate(R.layout.item,arg2,false);
		Button Btn;
		Btn = (Button) v.findViewById(R.id.submit);
		
		TopicNames topicName = (TopicNames) list.get(pos);
		
		Btn.setText(topicName.getTopicName());
//		Topics obj;
//		obj = new Topics();
//		String topic = obj.getList(pos);
	
		
		
		Btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {

				if(pos==0){
					Intent i = new Intent(c,QuizActivity.class);
					 Bundle bundle = new Bundle();
			    	  bundle.putInt("topic1",pos+1);
			    	  i.putExtras(bundle);
			    	  
					
					c.startActivity(i);
					}
				if(pos==1){
					Intent i = new Intent(c,QuizActivity.class);
					 Bundle bundle = new Bundle();
			    	  bundle.putInt("topic1",pos+1);
			    	  i.putExtras(bundle);
			    	 
					
					c.startActivity(i);
					}
				
				if(pos==2){
					Intent i = new Intent(c,QuizActivity.class);
					 Bundle bundle = new Bundle();
			    	  bundle.putInt("topic1",pos+1);
			    	  i.putExtras(bundle);
			    	 
					
					c.startActivity(i);
					}
				if(pos==3){
					Intent i = new Intent(c,QuizActivity.class);
					 Bundle bundle = new Bundle();
			    	  bundle.putInt("topic1",pos+1);
			    	  i.putExtras(bundle);
			    	 
					
					c.startActivity(i);
					}
				if(pos==4){
					Intent i = new Intent(c,QuizActivity.class);
					 Bundle bundle = new Bundle();
			    	  bundle.putInt("topic1",pos+1);
			    	  i.putExtras(bundle);
			    	 
					
					c.startActivity(i);
					}
				
			}
		});
		return v;
	};
	

}
