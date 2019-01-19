package java8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class java8example {
	public static void main(String[] args) {
		
		
		List<Integer> myList =new ArrayList<Integer>();
		
		
		for(int me=0; me<=10; me++)myList.add(me);
		
		Iterator<Integer> it= myList.iterator();
		
		/*while(it.hasNext()) {
			Integer me= it.next();
			System.out.println("Iterator Value::"+me);
		}*/
		/*myList.forEach(new Consumer<Integer>() {
			public void accept(Integer t) {
				System.out.println("forEach anonymous class Value::"+t);
			}
		});*/
		
		MyConsumer action = new MyConsumer();
		myList.forEach(action);
		
		
	}

}
class MyConsumer implements Consumer<Integer>{

	public void accept(Integer t) {
		System.out.println("Consumer impl Value::"+t);
		
	}
}
