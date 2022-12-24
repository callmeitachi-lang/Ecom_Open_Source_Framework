package com.demo.opencart.qa.constants;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	
	public final static String lOGINPAGE_TITLE="Account Login";
	public final static String EmptyCart_PopUp="Your shopping cart is empty!";
	public final static String ACCOUNTSPAGE_TITLE="My Account";
	public final static String ShoppingCart_Title="Shopping Cart";
	public final static String Register_Account_Title="Register Account";

	

 public static List<String> pageheaderlist()
{
	List<String> list=new ArrayList<String>();
	list.add("My Account");
	list.add("My Orders");
	list.add("My Affiliate Account");
	list.add("Newsletter");
return list;
}

public static List<String> shoppingCartDetails()
{
	List<String> list=new ArrayList<String>();
	list.add("shopping cart");
	list.add("MacBook Pro ***");
	list.add("Reward Points: 10400");
	list.add("Product 18");
	return list;
/*
MacBook Pro ***
Reward Points: 9600
Product 18

*/
}

}
