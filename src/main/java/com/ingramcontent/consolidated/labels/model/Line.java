package com.ingramcontent.consolidated.labels.model;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class Line implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	private int lineSequence;
	private java.lang.String lineText;

	public Line() {
	}

	public int getLineSequence() {
		return this.lineSequence;
	}

	public void setLineSequence(int lineSequence) {
		this.lineSequence = lineSequence;
	}

	public java.lang.String getLineText() {
		return this.lineText;
	}

	public void setLineText(java.lang.String lineText) {
		this.lineText = lineText;
	}

	public Line(int lineSequence, java.lang.String lineText) {
		this.lineSequence = lineSequence;
		this.lineText = lineText;
	}

}