package com.sabari.test;

public class ResultInfo {
	
	private String quizid,username,score,date;


	public ResultInfo(String quizid, String username, String score, String date) {
		this.quizid= quizid;
		this.username=username;
		this.score=score;
		this.date=date;
	
		
	}
	public String getQuizid() {
		return quizid;
	}

	public String getUsername() {
		return username;
	}

	public String getScore() {
		return score;
	}

	public String getDate() {
		return date;
	}




}
