package com.junit.demo;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculateTest {

	@Test
	public void testAdd(){
		assertEquals(6, new Calculate().add(3,3));
	}
	
	@Test
	public void testSubtract(){
		assertEquals(0, new Calculate().subtract(3, 3));
	}
	
	@Test
	public void testMultiply(){
		assertEquals(9, new Calculate().multiply(3, 3));
	}
	
	@Test
	public void testDivide(){
		assertEquals(1, new Calculate().divide(3, 3));
	}
	
}
