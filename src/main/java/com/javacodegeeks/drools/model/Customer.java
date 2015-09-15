package com.javacodegeeks.drools.model;

public class Customer {
	private Cart cart;
	private String coupon;
	private boolean isNew;
	
	private CustomerMembershipStatus memberShip;
	
	public CustomerMembershipStatus getMemberShip() {
		return memberShip;
	}

	public void setMemberShip(CustomerMembershipStatus memberShip) {
		this.memberShip = memberShip;
	}

	public static Customer newCustomer() {
		Customer customer = new Customer();
		customer.isNew = true;
		return customer;
	}
	
	public boolean getIsNew() {
		return isNew;
	}

	public void addItem(Product product, int qty) {
		if (cart == null) {
			cart = new Cart(this);			
		}
		cart.addItem(product, qty);
	}

	public String getCoupon() {
		return coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public Cart getCart() {
		return cart;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Customer new? ")
		   .append(isNew)
		   .append("\nCoupon: ")
		   .append(coupon)
		   .append("\n")
		   .append(memberShip)
		   .append("\n")
		   .append(cart);
		return sb.toString();
	}
}
