package org.collab.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestResult {
	
	@Test
	public void result() {
		Result r = JUnitCore.runClasses(A.class,B.class,C.class);
		System.out.println("run count "+r.getRunCount());
		System.out.println("ignore count  "+r.getIgnoreCount());
		System.out.println("run time  "+r.getRunTime());
		System.out.println("failure count   "+r.getFailureCount());
		
		System.out.println("Sutir=e resukt   "+r.wasSuccessful());
		
		List<Failure> failures = r.getFailures();
		for(Failure x:failures) {
		System.out.println(x);
		System.out.println(x.getTestHeader());
		System.out.println(x.getMessage());
		System.out.println(x.getException());
		}
	}
}
