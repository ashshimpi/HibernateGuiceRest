package java8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class JavaFeture {
	public static void main(String[] args) {
		
		List<Integer> myList = new ArrayList<Integer>();
		for(int me=0; me<10; me++)
		{ 
			myList.add(me);
			System.out.println("data "+me);
		}
		
		Iterator<Integer> it=myList.iterator();
		while(it.hasNext())
		{
			Integer me =it.next();
			System.out.println("Iterrator value is"+me);
			
		}
		
		myList.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				// TODO Auto-generated method stub
				System.out.println("foreach value"+t);
				
			}
			
		});
		
		
		
	}
}

