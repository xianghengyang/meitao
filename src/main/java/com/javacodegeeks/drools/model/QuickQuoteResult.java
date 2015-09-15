package com.javacodegeeks.drools.model;


public class QuickQuoteResult {
    
    public boolean isEligible() {
		return eligible;
	}

	public void setEligible(boolean eligible) {
		this.eligible = eligible;
	}

	private boolean eligible = false;
    
}
