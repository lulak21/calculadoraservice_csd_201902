package br.com.k21;

public class CalculadoraComissao {

	private static final double LIMITE_INFERIOR = 0.05;
	private static final int VALOR_LIMITE_VENDA_FAIXA = 10000;

	public static double calcular(double venda) {

		if (venda <= VALOR_LIMITE_VENDA_FAIXA) {
			double comissao = truncar(venda, LIMITE_INFERIOR);
			return comissao;
		} else {
			return truncar(venda, 0.06);
		}
	}

	private static double truncar(double venda, double percentual) {
		return Math.floor(venda * percentual * 100.0) / 100.0;
	}

}
