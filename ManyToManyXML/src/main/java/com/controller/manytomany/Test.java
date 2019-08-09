package com.controller.manytomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test 
{
    public static void main( String[] args )
    {
    	Configuration con = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        Session ses = sf.openSession();
        Transaction tx = ses.beginTransaction();
        
        Item iphone = new Item();
		iphone.setPrice(100); 
		iphone.setDescription("iPhone");
		
		Item ipod = new Item();
		ipod.setPrice(50); 
		ipod.setDescription("iPod");
		
		Set<Item> items1 = new HashSet<Item>();
		items1.add(iphone); 
		items1.add(ipod);
				
		Set<Item> items2 = new HashSet<Item>();
		items2.add(iphone);
		
		Cart cart1 = new Cart();
		cart1.setItems(items1);
		cart1.setTotal(150);
		
		Cart cart2 = new Cart();
		cart2.setItems(items2);
		cart2.setTotal(100);
		
		
		ses.save(cart1);
		ses.save(cart2);
		
		tx.commit();
		sf.close();
		
		System.out.println("success");
		
		}
	}
  

