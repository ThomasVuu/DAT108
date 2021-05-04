package Oppgave3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import oppgave2.*;

public class Main {

	public static void main(String[] args) {

		List<Ansatt> ansatte = Arrays.asList(new Ansatt("Erlend", "Aas", Kjonn.MANN, "Sjef", 1_000_000),
				new Ansatt("Sondre", "Salbu", Kjonn.MANN, "Vaskegutt", 231_000),
				new Ansatt("Thomas", "Vu", Kjonn.MANN, "Assistent", 456_000),
				new Ansatt("Anita", "Skamvik", Kjonn.DAME, "ØkonomiSjef", 717_000),
				new Ansatt("Celine", "Kopperud", Kjonn.DAME, "Trivsel", 519_000));

		
//		a)
		List<String> etternavn = ansatte.stream()
				.map(Ansatt::getEtternavn) // samme som "a -> a.getEtternavn"
				.collect(Collectors.toList());
		
		System.out.println("a)");
		System.out.println(etternavn + "\n");
		
//		b)
		int antallChicks =  (int) ansatte.stream()
				.filter(a -> a.getKjonn() == Kjonn.DAME)
				.count();
		
		System.out.println("b)");
		System.out.println(antallChicks + "\n");
		
//		c)
		OptionalDouble gjLonnKvinne = ansatte.stream()
				.filter(a -> a.getKjonn() == Kjonn.DAME)
				.mapToInt(a -> a.getAarslonn())
				.average();

		System.out.println("c)");
		System.out.println(gjLonnKvinne + "\n");
		
//		d)
		ansatte.stream()
			.filter(a -> a.getStilling().toUpperCase().contains("SJEF"))
			.forEach(a -> a.setAarslonn(a.getAarslonn()*107/100));
		
		System.out.println("d)");
		System.out.println(ansatte + "\n");
		
//		e)
		boolean sjekk = ansatte.stream()
				.anyMatch(a -> a.getAarslonn() > 800_000);
		
		System.out.println("e)");
		System.out.println(sjekk + "\n");
		
//		f)
		System.out.println("f)");

		ansatte.stream()
			.forEach(System.out::print); // Samme som " a -> System.out.print(a)"
		
		System.out.println();
		
//		g)
		Ansatt lavest = ansatte.stream()
				.min(Comparator.comparing(a -> a.getAarslonn()))
				.get();
				
		List<Ansatt> lavestLonn = ansatte.stream()
				.filter(a -> a.getAarslonn() == lavest.getAarslonn())
				.collect(Collectors.toList());
		
		System.out.println("g)");
		System.out.println(lavestLonn + "\n");

		
//		h)
		int sum = IntStream.range(1,1000)
				.filter(a -> a%3 == 0 || a%5 == 0)
				.sum();
		
		System.out.println("h)");
		System.out.println(sum);

		}	
	
	}
































