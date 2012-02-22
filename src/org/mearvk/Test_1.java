package org.mearvk;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.TestOrderingComputer;
import org.junit.runner.notification.Failure;

public class Test_1
{
	public static void main(String[] args)
	{
		try
		{
			JUnitCore core = new JUnitCore();
			
			//Result result = core.run(new TestOrderingComputer(), MyTestClass1.class, MyTestClass2.class);

            Result result = core.run(MyTestClass1.class, MyTestClass2.class);
			
			List<Failure> failures = result.getFailures();
			
			for(Failure failure : failures)
			{
				System.out.println(failure.getMessage());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
