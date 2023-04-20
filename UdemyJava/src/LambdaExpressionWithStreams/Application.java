package LambdaExpressionWithStreams;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * Streams is a pipeline that contains source, intermediate operations
 * and terminal operation
 * 
 * -intermediate operations(IO) return stream so can chain multiple
 * operations together
 * -zero or more IO allowed
 * -order matters: Filter first, then sort or map etc
 * -for very large datasets, can use ParallelStream to enable multiple 
 * threads to perform operations.
 * -example of IO
 * -filter()
 * -distinct()
 * -mao()
 * -skip()
 * -sorted()
 * 
 * 
 * -terminal operations(TO) return void or non-stream result
 * such as list or single value
 * 
 * -forEach()applies same function to each element
 * -collect() saves the elements into a collection
 * -other options reduces the stream to a single summary or no element element such as:
 * count()
 * max()
 * min()
 * sum()
 * summaryStatistics()
 * 
 * 
 * 
 * Stream example:
 * source(collections, files and data) --> intermediate operations(filter-sort-map) -->collect(terminal operations)
 * 
 * 
 * to configure files folder to project, right click project, click build path, click
 * configure build path, go to source and click add folder then check file folder and then click apply
 * make sure it appears in order and export apply and close
 */
public class Application {

	public static void main(String[] args) {
		
		IntStream //source , there is no intermediate operation
		.range(1, 10)//it print 1 to 9 because it dont include last one
		.skip(5) //integer stream with skip, skip 5 elements of the stream we get 6789
		.forEach((x) -> System.out.print(x));//terminal operation
		System.out.println();
		
		//integer with sum
		int val = IntStream
				.range(1, 5)
				.sum();
		System.out.println(val);
		
		//stream.of sorted and find first
		Stream.of("Hell","bottle","Africa")//source
		.sorted()//Intermediate operation
		.findFirst()//terminal operation
		.ifPresent((x) -> System.out.println(x));
		
		//stream from Array, sort, filter and print
		String[] items = {"car","computer","toothpaste","box",
				"pencil","tent","toy","door"};
		Stream.of(items)
		.filter((x) -> x.startsWith("t"))
		.sorted()
		.forEach(x -> System.out.print(x + " ,"));
		System.out.println();
		
		//average of squares of an int array
		Arrays.stream(new int[] {2,5,6,8,10})
		.map((x) -> x*x)
		.average()
		.ifPresent(n-> System.out.print(n));//prevent null pointer exception
		System.out.println();
		
		
		
		
		
		}
	
	

	}


