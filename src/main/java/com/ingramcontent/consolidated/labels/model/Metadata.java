package com.ingramcontent.consolidated.labels.model;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class Metadata implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	private java.lang.String key;
	private java.lang.String value;

	public Metadata() {
	}

	public java.lang.String getKey() {
		return this.key;
	}

	public void setKey(java.lang.String key) {
		this.key = key;
	}

	public java.lang.String getValue() {
		return this.value;
	}

	public void setValue(java.lang.String value) {
		this.value = value;
	}

	public Metadata(java.lang.String key, java.lang.String value) {
		this.key = key;
		this.value = value;
	}

}