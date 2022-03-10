package org.collab.test;

import org.junit.Assert;
import org.junit.Test;

public class B {
	@Test
	public void test1() {
		System.out.println("test B1");
	}
	@Test
	public void test2() {
		Assert.assertTrue("varify b",false);
		System.out.println("test B2");
	}

}
