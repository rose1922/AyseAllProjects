package com.class01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Class01_Task_1 {
	
    @Test (groups="regression")
    public void testOne() {
        System.out.println("Hello");
        Assert.assertTrue(false);
    }
    
    @Test (groups="regression")
    public void testTwo() {
        System.out.println("Hello from test 2");
        Assert.assertTrue(true);
    }
    
    @Test (groups="regression")
    public void testThree() {
        System.out.println("Hello from test 3");
        Assert.assertTrue(true);
    }
}