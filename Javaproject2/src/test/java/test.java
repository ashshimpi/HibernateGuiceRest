
import org.junit.Test;

import static org.junit.Assert.*;


public class test {

	@Test
	public void test1(){
		 Myclass mc = new Myclass();
		    int sum1 = mc.evaluate("1+2+3");
		    assertEquals(6, sum1);
	//fail("Not yet implemented");
	}

}
