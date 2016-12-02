package com.enumtest;

public enum WhoisRIR {

	ARIN("whois.arin.net", 2),
    RIPE("whois.ripe.net", 3),
    UNKNOWN("", 0);

	private String url;
	private int number;
	
	WhoisRIR(String url, int number) {
		this.url = url;
		this.number = number;
	}

	public String url() {
		return url;
	}
	
	public int number() {
		return number;
	}
}
