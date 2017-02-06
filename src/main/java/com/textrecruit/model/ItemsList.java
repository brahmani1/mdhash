package com.textrecruit.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemsList {
	@JsonProperty("items")
	private ItemElement[] items;

 	public void setItems(ItemElement[] items) {
		this.items = items;
	}

	public ItemElement[] getItems() {
		return items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(items);
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
		ItemsList other = (ItemsList) obj;
		if (!Arrays.equals(items, other.items))
			return false;
		return true;
	}
	
}