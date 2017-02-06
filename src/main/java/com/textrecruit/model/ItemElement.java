package com.textrecruit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemElement {
	@JsonProperty("index")
	private java.lang.Integer index;

 	public void setIndex(java.lang.Integer index) {
		this.index = index;
	}

	public java.lang.Integer getIndex() {
		return index;
	}
	
	@JsonProperty("uid")
	private java.lang.String uid;

 	public void setUid(java.lang.String uid) {
		this.uid = uid;
	}

	public java.lang.String getUid() {
		return uid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((index == null) ? 0 : index.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemElement other = (ItemElement) obj;
		if (index == null) {
			if (other.index != null)
				return false;
		} else if (!index.equals(other.index))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemElement [index=" + index + ", uid=" + uid + "]";
	}
	
}