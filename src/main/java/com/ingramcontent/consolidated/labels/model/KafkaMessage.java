package com.ingramcontent.consolidated.labels.model;


/**
 * This class was automatically generated by the data modeler tool.
 */

public class KafkaMessage implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	private java.lang.String topic;
	private java.lang.String key;
	private java.lang.String message;

	public KafkaMessage() {
	}

	public java.lang.String getTopic() {
		return this.topic;
	}

	public void setTopic(java.lang.String topic) {
		this.topic = topic;
	}

	public java.lang.String getKey() {
		return this.key;
	}

	public void setKey(java.lang.String key) {
		this.key = key;
	}

	public java.lang.String getMessage() {
		return this.message;
	}

	public void setMessage(java.lang.String message) {
		this.message = message;
	}

	public KafkaMessage(java.lang.String topic, java.lang.String key,
			java.lang.String message) {
		this.topic = topic;
		this.key = key;
		this.message = message;
	}

}