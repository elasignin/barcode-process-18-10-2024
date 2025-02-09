package com.ingramcontent.consolidated.labels.model;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class CopyLabelSignal implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	private java.lang.Integer copyId;
	private java.lang.Integer sequence;
	private java.lang.Integer labelSetId;
	private java.lang.Integer status;
	private boolean doNotPrint;
	private java.lang.String isbn;
	private java.lang.Integer itemId;

	private com.ingramcontent.consolidated.labels.model.MetadataSignal metadata;

	public CopyLabelSignal() {
	}

	public java.lang.Integer getCopyId() {
		return this.copyId;
	}

	public void setCopyId(java.lang.Integer copyId) {
		this.copyId = copyId;
	}

	public java.lang.Integer getSequence() {
		return this.sequence;
	}

	public void setSequence(java.lang.Integer sequence) {
		this.sequence = sequence;
	}

	public java.lang.Integer getLabelSetId() {
		return this.labelSetId;
	}

	public void setLabelSetId(java.lang.Integer labelSetId) {
		this.labelSetId = labelSetId;
	}

	public java.lang.Integer getStatus() {
		return this.status;
	}

	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}

	public boolean isDoNotPrint() {
		return this.doNotPrint;
	}

	public void setDoNotPrint(boolean doNotPrint) {
		this.doNotPrint = doNotPrint;
	}

	public java.lang.String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(java.lang.String isbn) {
		this.isbn = isbn;
	}

	public java.lang.Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(java.lang.Integer itemId) {
		this.itemId = itemId;
	}

	public com.ingramcontent.consolidated.labels.model.MetadataSignal getMetadata() {
		return this.metadata;
	}

	public void setMetadata(
			com.ingramcontent.consolidated.labels.model.MetadataSignal metadata) {
		this.metadata = metadata;
	}

	public CopyLabelSignal(java.lang.Integer copyId,
			java.lang.Integer sequence, java.lang.Integer labelSetId,
			java.lang.Integer status, boolean doNotPrint,
			java.lang.String isbn, java.lang.Integer itemId,
			com.ingramcontent.consolidated.labels.model.MetadataSignal metadata) {
		this.copyId = copyId;
		this.sequence = sequence;
		this.labelSetId = labelSetId;
		this.status = status;
		this.doNotPrint = doNotPrint;
		this.isbn = isbn;
		this.itemId = itemId;
		this.metadata = metadata;
	}

}