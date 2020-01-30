package com.class04;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ListenerDemo {
	
    @Test //(groups="regression")
    public void testOne() {
        System.out.println("I am test one");
        Assert.assertTrue(true);
    }
    
    @Test //(groups="regression")
    public void testTwo() {
        System.out.println("I am test two");
        Assert.assertTrue(true);
    }
    
    @Test //(groups="regression")
    public void testThree() {
        System.out.println("I am test three");
        Assert.assertTrue(true);
    }
}