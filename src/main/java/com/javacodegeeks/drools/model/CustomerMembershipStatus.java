package com.javacodegeeks.drools.model;

public class CustomerMembershipStatus {
	private double memberFeePaid;
	private int accumulatedPoints;
	private int numberOfYearMembership;
	
	
	public int getNumberOfYearMembership() {
		return numberOfYearMembership;
	}
	public void setNumberOfYearMembership(int numberOfYearMembership) {
		this.numberOfYearMembership = numberOfYearMembership;
	}
	public int getAccumulatedPoints() {
		return accumulatedPoints;
	}
	public void setAccumulatedPoints(int accumulatedPoints) {
		this.accumulatedPoints = accumulatedPoints;
	}

	private double markupRate;
	

	public double getMemberFeePaid() {
		return memberFeePaid;
	}
	public void setMemberFeePaid(double memberFeePaied) {
		this.memberFeePaid = memberFeePaied;
	}

	public double getMarkupRate() {
		return markupRate;
	}
	public void setMarkupRate(double markupRate) {
		this.markupRate = markupRate;
	}
	
	public String toString() {
		return "memberFeePaid: " + memberFeePaid + " ,accumulatedPoints: " + accumulatedPoints +" , numberOfYearMembership: " + numberOfYearMembership + ", markup rate: " + markupRate;
	}
}
