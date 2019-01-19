package com.org;

import java.util.Arrays;
import java.util.List;

public class MethodRef {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> names= Arrays.asList("ash","poo","nik");
		//names.forEach(str->System.out.println(str)); //Lambra exp
		
		
		names.forEach(System.out::println); // method reference(passing method as argument)
		

	}

}
