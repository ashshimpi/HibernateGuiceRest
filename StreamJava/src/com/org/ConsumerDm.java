package com.org;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

//class CumImp implements Consumer<Integer>
//{
//
//	@Override
//	public void accept(Integer i) {
//		
//		System.out.println(i);
//	}
//	
//
//}

public class ConsumerDm {
	

	public static void main(String[] args) {
			
			List<Integer> values = Arrays.asList(5,6,7,8,9);
			
//			Consumer<Integer> c=new CumImp();
//			values.forEach(c);
//			Consumer<Integer> c=new Consumer<Integer>() {
//
//				@Override
//				public void accept(Integer i) {
//					System.out.println(i);
//					
//				}
//				
//			};
			
			
			
			//Consumer<Integer> c= i->System.out.println(i);
			//values.forEach(c);
			
			
		
			values.forEach(i->System.out.println(i));
	}
}
