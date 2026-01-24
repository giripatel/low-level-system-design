package main.java.org.giri.Basics.OOPS;

import javax.xml.namespace.QName;

public class CreditCard extends Card{
    public CreditCard(String id, String name) {
        super(id, name);
    }

    public void pay() {
        System.out.println("Paying from ");
    }
}
