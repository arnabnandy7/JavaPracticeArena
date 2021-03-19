package test.oldCompetitivePrograms;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.TimeUnit;

public class OptimizJavaCodeBigDec {

	public static void main(String[] args) {
		long start = TimeUnit.MILLISECONDS
				.toSeconds(System.currentTimeMillis());
		double a = 0;
		for (int i = 0; i < 10000000; i++) {

			a = new BigDecimal(a).add(
					new BigDecimal(1).divide(new BigDecimal(216), 8,
							RoundingMode.HALF_EVEN)).doubleValue();
			a = new BigDecimal(a).add(
					new BigDecimal(1).divide(new BigDecimal(216), 8,
							RoundingMode.HALF_EVEN)).doubleValue();
			a = new BigDecimal(a).add(
					new BigDecimal(1).divide(new BigDecimal(216), 8,
							RoundingMode.HALF_EVEN)).doubleValue();
			a = new BigDecimal(a).add(
					new BigDecimal(1).divide(new BigDecimal(216), 8,
							RoundingMode.HALF_EVEN)).doubleValue();
		}
		System.out.println("BigDecimal::" + a);
		long end = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());

		System.out.println(start + "::" + end + "->" + (end - start));

		start = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
		double ar = 0;
		for (int i = 0; i < 10000000; i++) {
			ar = ar + 1 / Double.parseDouble("216");
			ar = ar + 1 / Double.parseDouble("216");
			ar = ar + 1 / Double.parseDouble("216");
			ar = ar + 1 / Double.parseDouble("216");

		}
		System.out.println("Double::" + a);
		end = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());

		System.out.println(start + "::" + end + "->" + (end - start));

	}

}
