package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExamp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> myList= new ArrayList<>();
		
		for(int i=0;i<100;i++)
			myList.add(i);
		
		Stream<Integer> sequentialStream =myList.stream();
		Stream<Integer> parellelStream=myList.parallelStream();
		
		Stream<Integer> highNums = parellelStream.filter(p->p>90);

		highNums.forEach(p->System.out.println("High Nums="+p));
		
		Stream<Integer> highNumsSeq = sequentialStream.filter(p->p>90);
		
		highNumsSeq.forEach(p->System.out.println("High Nums="+p));
		
		
		
	}

}
