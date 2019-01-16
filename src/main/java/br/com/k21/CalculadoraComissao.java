package br.com.k21;

public class CalculadoraComissao {

	public static double calcular(int venda) {
		if (venda <= 10000)
			return venda * 0.05;

		return venda * 0.06;
	}

	public static double calcular(double venda) {
		if (venda <= 10000)
			return Math.floor((venda * 0.05) * 100) / 100;

		return venda * 0.06;
	}

}
