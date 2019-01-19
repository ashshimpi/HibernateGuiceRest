package com.org;

interface A
{
 void show(int i);	

}
//class Test implements A
//{
//
//	@Override
//	public void show() {
//		// TODO Auto-generated method stub
//		System.out.println("hello");
//		
//	}
//	
//}
public class LmbraDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A obj;
		
//		obj= new A()//	Anonymous Inner Class
//		{
//			public void show() {
//				
//				System.out.println("hello");
//			}
//		};

//		
//		obj= ()-> {
//				
//				System.out.println("hello java");
//			};
//		
			//with Parameters
		obj= (i)->	System.out.println("hello java" + i);
				
		
		
		//obj.show();
		obj.show(6);
					
		

	}

}
