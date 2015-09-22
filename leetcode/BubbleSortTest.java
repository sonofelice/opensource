package leetcode;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BubbleSortTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testBubbleSort() {
		int[] values = {2,1,3,5,3,0,9,7,8};
		BubbleSort bs = new BubbleSort();
		bs.bubbleSort(values);
		for(int i=0;i<values.length;i++){
			System.out.println(values[i]);
		}
	}

}
