package com.textrecruit.product;

public enum Constants {
	AGGREGATIONURI(
			"https://gist.githubusercontent.com/anonymous/8f60e8f49158efdd2e8fed6fa97373a4/raw/01add7ea44ed12f5d90180dc1367915af331492e/java-data2.json");

	private final String uri;

	Constants(final String uri) {
		this.uri = uri;
	}

	public String getURI() {
		return this.uri;
	}
}
