package com.org;

interface Parser
{
	String parse(String str);
}
class StringCon{
	
	public static String convert(String s)
	{
		if(s.length()>=3)
			s=s.toLowerCase();
		else 
			s=s.toUpperCase();
		return s;
	}
	
}
class MyPrinter
{
	public void print(String str,Parser p)
	{
		str=p.parse(str);
		System.out.println(str);
	}
}
public class FirstCode {
	public static void main(String[] args)
	{
		String str="ashu";
		MyPrinter mp=new MyPrinter();
		mp.print(str,new Parser() {
			
			@Override
			public String parse(String str) {
				// TODO Auto-generated method stub
				return StringCon.convert(str);
				
			}
		});
		
	}

}
