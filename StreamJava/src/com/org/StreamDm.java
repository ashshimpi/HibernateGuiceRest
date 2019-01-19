package com.org;

import java.util.Arrays;
import java.util.List;

public class StreamDm {
	
	public static void main(String args[])
	{
		List<Integer> values = Arrays.asList(5,6,7,8,9);
		
//		for(int i=0;i<values.size();i++)
//		{
//			System.out.println(values.get(i));
//		}
//		
//		for(int i :values)
//		{
//			System.out.println(i);
//		}
//	External loop java 8
	values.forEach( i-> System.out.println(i));  //lambra
		
	}

}
