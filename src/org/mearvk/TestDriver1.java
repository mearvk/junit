package org.mearvk;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * A simple, ordered test class used during development
 * 
 * @see <a href="http://code.google.com/p/junit-test-orderer">Licensing, code source, etc.</a>
 * 
 * @author Max Rupplin
 */
public class TestDriver1
{
	public static void main(String[] args)
	{
		try
		{
			JUnitCore core = new JUnitCore();

			// Result result = core.run(new TestOrderingComputer(),
			// MyTestClass1.class, MyTestClass2.class);

			Result result = core.run(MyTestClass1.class, MyTestClass2.class,
					MyTestClass3.class);

			List<Failure> failures = result.getFailures();

			for (Failure failure : failures)
			{
				System.err.println("Failure messages: " + failure.getMessage());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
