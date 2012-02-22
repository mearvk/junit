package org.junit.runners;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.junit.MethodRunOrder;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

public class OrderedTestRunner extends Runner
{
	private Class<?> testClass=null;
	
	public OrderedTestRunner(Class<?> testClass) throws InitializationError
	{
		this.testClass = testClass;

        OrderedSuite.registerOrderedClass(testClass);
	}

	@Override
	public Description getDescription()
	{
		return Description.createSuiteDescription(testClass);
	}

	@Override
	public void run(RunNotifier notifier)
	{
		notifier.fireTestStarted(getDescription());
		
		//System.err.println("OrderedTestRunner should be running the tests now...");

        OrderedSuite.runNext(notifier);
		
		notifier.fireTestFinished(getDescription());
	}
}
