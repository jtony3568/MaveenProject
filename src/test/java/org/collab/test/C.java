package org.collab.test;

import org.junit.Ignore;
import org.junit.Test;

public class C {
	@Test
	public void test1() {
		System.out.println("test C1");
	}
	@Test
	public void test2() {
		System.out.println("tets C2");
	}
	@Ignore
	@Test
	public void test3() {
		System.out.println("test C3");
	}

}
