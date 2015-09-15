package com.javacodegeeks.drools;

import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.DecisionTableConfiguration;
import org.kie.internal.builder.DecisionTableInputType;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatelessKnowledgeSession;

import com.javacodegeeks.drools.model.Customer;
import com.javacodegeeks.drools.model.Product;
import com.javacodegeeks.drools.model.CustomerMembershipStatus;
import java.util.Date;

public class DroolsDecisionTableExample {
	private static StatelessKnowledgeSession session;

	public static void main(String[] args) throws Exception {
		KnowledgeBase knowledgeBase = createKnowledgeBaseFromSpreadsheet();
		session = knowledgeBase.newStatelessKnowledgeSession();

		Customer customer = new Customer();
		Product p1 = new Product("Laptop", 15000);
		Product p2 = new Product("Mobile", 5000);
		Product p3 = new Product("Books", 2000);
		customer.addItem(p1, 1);
		customer.addItem(p2, 2);
		customer.addItem(p3, 5);
		customer.setCoupon("DISC01");
		CustomerMembershipStatus memberShip = new CustomerMembershipStatus();
		memberShip.setMemberFeePaid(400);
		//memberShip.setMemberShipStarted(new Date());
		customer.setMemberShip(memberShip);
	
		session.execute(memberShip);
		session.execute(customer);

		System.out.println("First Customer\n" + customer);

		Customer newCustomer = Customer.newCustomer();
		newCustomer.addItem(p1, 1);
		newCustomer.addItem(p2, 2);
		
		memberShip = new CustomerMembershipStatus();
		memberShip.setAccumulatedPoints(5000);
		newCustomer.setMemberShip(memberShip);
		
		session.execute(memberShip);
		session.execute(newCustomer);

		System.out.println("*********************************");
		System.out.println("Second Customer\n" + newCustomer);
		
		Customer newCustomer2 = Customer.newCustomer();
		newCustomer2.addItem(p1, 1);
		newCustomer2.addItem(p2, 2);
		
		memberShip = new CustomerMembershipStatus();
		newCustomer2.setMemberShip(memberShip);
		
		session.execute(memberShip);
		session.execute(newCustomer2);
		System.out.println("*********************************");
		System.out.println("Third Customer\n" + newCustomer2);
		
		
		Customer newCustomer3 = Customer.newCustomer();
		newCustomer3.addItem(p1, 1);
		newCustomer3.addItem(p2, 2);
		
		memberShip = new CustomerMembershipStatus();
		memberShip.setAccumulatedPoints(4000);
		memberShip.setMemberFeePaid(100);
		newCustomer3.setMemberShip(memberShip);
		
		session.execute(memberShip);
		session.execute(newCustomer3);
		System.out.println("*********************************");
		System.out.println("Fourth Customer\n" + newCustomer3);
		
		
		Customer newCustomer4 = Customer.newCustomer();
		newCustomer4.addItem(p1, 1);
		newCustomer4.addItem(p2, 2);
		
		memberShip = new CustomerMembershipStatus();
		memberShip.setNumberOfYearMembership(10);
		newCustomer4.setMemberShip(memberShip);
		
		session.execute(memberShip);
		session.execute(newCustomer4);
		System.out.println("*********************************");
		System.out.println("Fifth Customer\n" + newCustomer4);
		
		//
	}

	private static KnowledgeBase createKnowledgeBaseFromSpreadsheet()
			throws Exception {
		DecisionTableConfiguration dtconf = KnowledgeBuilderFactory
				.newDecisionTableConfiguration();
		dtconf.setInputType(DecisionTableInputType.XLS);

		KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();
		knowledgeBuilder.add(ResourceFactory
				.newClassPathResource("shopping_cart_customer.xls"),
				ResourceType.DTABLE, dtconf);
		
		knowledgeBuilder.add(ResourceFactory
				.newClassPathResource("customer_membership1.xls"),
				ResourceType.DTABLE, dtconf);
//		knowledgeBuilder.add(ResourceFactory
//				.newClassPathResource("quickQuoteExample.xls"),
//				ResourceType.DTABLE, dtconf);
		
		if (knowledgeBuilder.hasErrors()) {
			throw new RuntimeException(knowledgeBuilder.getErrors().toString());
		}		

		KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
		knowledgeBase.addKnowledgePackages(knowledgeBuilder
				.getKnowledgePackages());
		return knowledgeBase;
	}
}
