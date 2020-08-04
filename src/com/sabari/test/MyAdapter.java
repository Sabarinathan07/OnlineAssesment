package com.sabari.test;
import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;

public class MyAdapter extends BaseAdapter {
	
	 Context c = null;
	ArrayList list;
	LayoutInflater inflater;
	//Button Btn;
	ImageView image;
	
	
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
		image = (ImageView)v.findViewById(R.id.imageView1);
		
		TopicNames topicName = (TopicNames) list.get(pos);
		
		Btn.setText(topicName.getTopicName());
		image.setImageResource(Topics.images[pos]);
//		Topics obj;
//		obj = new Topics();
//		String topic = obj.getList(pos);
	
		
		
		Btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {

					Intent i = new Intent(c,QuizActivity.class);
					 Bundle bundle = new Bundle();
			    	  bundle.putInt("topic1",pos+1);
			    	  i.putExtras(bundle);
					c.startActivity(i);
				
			}
		});
		return v;
	};
	

}
