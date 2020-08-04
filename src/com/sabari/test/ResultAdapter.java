package com.sabari.test;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ResultAdapter extends BaseAdapter {
	TextView name,score;
	 Context c = null;
	ArrayList list;
	LayoutInflater inflater;
	
	

	

	public ResultAdapter(Context c,	ArrayList<ResultInfo> resulList) {
		this.list = resulList;
		inflater=LayoutInflater.from(c);
		this.c=c;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(final int pos, View arg1, ViewGroup arg2) {
		View v = inflater.inflate(R.layout.result_item,arg2,false);
		
		
		name = (TextView) v.findViewById(R.id.rUsername);
		score = (TextView)v.findViewById(R.id.rScore);

		
		ResultInfo resultinfo = (ResultInfo) list.get(pos);
		
		
		name.setText(resultinfo.getUsername());
		score.setText(resultinfo.getScore());
		
		
		return v;
	}

}
