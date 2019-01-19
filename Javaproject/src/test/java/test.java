
import org.junit.Test;


import static org.junit.Assert.*;


public class test {

	@Test
	public void test1(){
		 Myclass mc=new Myclass();
		 int sum=mc.add(2,3);
		 assertEquals(5,sum);
		   
	//fail("Not yet implemented");
	}
	@Test
	public void test2(){
		Myclass mc=new Myclass();
		int sum=mc.add(5,6);
		assertEquals(11,sum);
		
	//fail("Not yet implemented");
	}

}
