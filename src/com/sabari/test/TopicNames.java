package com.sabari.test;

public class TopicNames {
	
	private String questionid , topicName;
	
	public TopicNames(String questionid, String topicName){
		this.questionid=questionid;
		this.topicName=topicName;
	}

	public String getQuestionid() {
		return questionid;
	}

	public void setQuestionid(String questionid) {
		this.questionid = questionid;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	

}
