package lampola.task2;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Task2ApplicationTest 
{
	private static class TestData
	{
		private int[] integers;
		private long expectedResult;
		
		public TestData(int[] integers, long expectedResult) {
			this.integers = integers;
			this.expectedResult = expectedResult;
		}
	}
	
	private static TestData[] testData = {
			new TestData(new int[] {}, 0),
			new TestData(new int[] {0}, 0),
			new TestData(new int[] {-1, 1}, 1),
			new TestData(new int[] {3, 1, 2}, 0),
			new TestData(new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE}, (long)Integer.MAX_VALUE - (long)Integer.MIN_VALUE - 1L),
			new TestData(new int[] {2, 4, 6, 8}, 1),
			new TestData(new int[] {4, 8, 16, 32}, 3),
			new TestData(new int[] {16, 4, 32, 8}, 3),
			new TestData(new int[] {16, 4, 32, 8, 16, 4, 32, 8}, 3)
	};
	
	@Test
    public void testApp()
    {
		for (TestData data : testData) {
			long result = Task2Application.task2(data.integers);
			assertEquals("Input: " + Arrays.toString(data.integers) + ",", data.expectedResult, result);
		}
    }
}
