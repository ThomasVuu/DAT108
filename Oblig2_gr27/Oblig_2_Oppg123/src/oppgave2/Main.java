package oppgave2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		List<Ansatt> ansatte = Arrays.asList(
				new Ansatt("Erlend", "Aas", Kjonn.MANN, "Sjef", 1_000_000),
				new Ansatt("Sondre", "Salbu", Kjonn.MANN, "Vaskegutt", 231_000),
				new Ansatt("Thomas", "Vu", Kjonn.MANN, "Assistent", 456_000),
				new Ansatt("Anita", "Skamvik", Kjonn.DAME, "Økonomi", 717_000),
				new Ansatt("Celine", "Kopperud", Kjonn.DAME, "Trivsel", 519_000));

//		Et fast kronetillegg
		Function<Ansatt, Integer> f1 = a -> (a.getAarslonn() + 10_000);
//		lonnsoppgjor(ansatte, f1);
		
//		Et fast prosenttillegg
		Function<Ansatt, Integer> f2 = a -> Math.round((a.getAarslonn() * 125 / 100));
//		lonnsoppgjor(ansatte, f2);
		
//		Et fast kronetillegg hvis du har lav lønn
		Function<Ansatt, Integer> f3 = a -> {
			if (a.getAarslonn() < 500_000)
				return a.getAarslonn() + 10_000;

			return a.getAarslonn();
		};
//		lonnsoppgjor(ansatte, f3);
		
//		Et fast prosenttillegg hvis du er mann
		Function<Ansatt, Integer> f4 = a -> {
			if (a.getKjonn() == Kjonn.MANN)
				return a.getAarslonn() * 125/100;

			return a.getAarslonn();
		};
		lonnsoppgjor(ansatte, f4);

		skrivUtAlle(ansatte);

	}

	private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> metode) {

		for (Ansatt a : ansatte) {
			a.setAarslonn(metode.apply(a));
		}

	}

	private static void skrivUtAlle(List<Ansatt> ansatte) {
		System.out.println(ansatte.toString());
	}

}
