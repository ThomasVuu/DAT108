package oppgave1;

import java.util.*;
import java.util.stream.Collectors;

public class A {

	public static void main(String[] args) {

		List<String> listen = Arrays.asList("10", "1", "20", "110", "21", "12");


		List<Integer> tall = listen.stream()
				.map(a -> Integer.parseInt(a))
				.sorted()		//lurer på om dette ikke er riktig iht til oppgaven
				.collect(Collectors.toList());
	
//		Kan også skrives sånn her?
		Collections.sort(listen,(a,b) -> Integer.compare(Integer.parseInt(a), Integer.parseInt(b)));
		
		System.out.println(listen);

	}

}
