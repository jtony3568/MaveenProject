package org.collab.test;

import org.junit.Assert;
import org.junit.Test;

public class A {
	@Test
	public void test1() {
		System.out.println("test A1");
	}
	@Test
	public void test2() {
		Assert.assertFalse("varify url",true);
		System.out.println("test A2");
	}

}
