package com.ingramcontent.consolidated.labels.model;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class BarcodeActionSignal implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	private java.lang.String topic;
	private ToteInformation toteInformation;

	public BarcodeActionSignal() {
	}

	public java.lang.String getTopic() {
		return this.topic;
	}

	public void setTopic(java.lang.String topic) {
		this.topic = topic;
	}

	public com.ingramcontent.consolidated.labels.model.ToteInformation getToteInformation() {
		return this.toteInformation;
	}

	public void setToteInformation(
			com.ingramcontent.consolidated.labels.model.ToteInformation toteInformation) {
		this.toteInformation = toteInformation;
	}

	public BarcodeActionSignal(
			java.lang.String topic,
			com.ingramcontent.consolidated.labels.model.ToteInformation toteInformation) {
		this.topic = topic;
		this.toteInformation = toteInformation;
	}

}