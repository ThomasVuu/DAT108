package oppgave1;

import java.util.Comparator;
import java.util.function.BiFunction;

public class B {

	public static void main(String[] args) {

		BiFunction<Integer, Integer, Integer> sum = (t, u) -> (t + u);
		BiFunction<Integer, Integer, Integer> max = (t, u) -> Math.max(t, u);
		BiFunction<Integer, Integer, Integer> diff = (t, u) -> Math.abs(u - t);

		System.out.println("Sum : " + beregn(12, 13, sum));
		System.out.println("Max : " + beregn(-5, 3, max));
		System.out.println("Diff : " + beregn(54, 45, diff));

	}

	public static int beregn(int a, int b, BiFunction<Integer, Integer, Integer> bi) {

		return bi.apply(a, b);

	}

}
