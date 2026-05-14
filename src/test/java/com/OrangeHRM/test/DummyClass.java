package com.OrangeHRM.test;

import org.testng.annotations.Test;

import com.OrangeHRM.base.BaseClass;

public class DummyClass extends BaseClass {
	
	@Test
    public void dummyTest() {
    	String title= driver.getTitle();
    	assert title.equals("OrangeHRM"):"Test Failed -Title is not matching";
       System.out.println("Test passed -Title is matching");
    }
}
