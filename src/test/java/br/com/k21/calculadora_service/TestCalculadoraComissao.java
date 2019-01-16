package br.com.k21.calculadora_service;

import org.junit.Assert;
import org.junit.Test;

import br.com.k21.CalculadoraComissao;

public class TestCalculadoraComissao {

	@Test
	public void UmaVendaDe5000TemComissaoDe250() {
		int venda = 5000;
		int saida = 250;
		double retorno;
		retorno = CalculadoraComissao.calcular(venda);
		Assert.assertEquals(saida, retorno, 0.001);
	}

	@Test
	public void UmaVendaDe12000TemComissaoDe720() {
		int venda = 12000;
		int saida = 720;
		double retorno;

		retorno = CalculadoraComissao.calcular(venda);
		Assert.assertEquals(saida, retorno, 0.001);
	}

	@Test
	public void UmaVendaDe10000TemComissaoDe500() {
		int totalVenda = 10000;
		int comissaoEsperada = 500;

		double comissaoCalculada = CalculadoraComissao.calcular(totalVenda);
		Assert.assertEquals(comissaoEsperada, comissaoCalculada, 0.001);
	}

	@Test
	public void UmaVendaDe11000TemComissaoDe660() {
		int totalVenda = 11000;
		int comissaoEsperada = 660;

		double comissaoCalculada = CalculadoraComissao.calcular(totalVenda);
		Assert.assertEquals(comissaoEsperada, comissaoCalculada, 0.001);
	}

	@Test
	public void UmaVendaDe10001TemComissaoDe600_06() {
		int totalVenda = 10001;
		double comissaoEsperada = 600.06;

		double comissaoCalculada = CalculadoraComissao.calcular(totalVenda);
		Assert.assertEquals(comissaoEsperada, comissaoCalculada, 0.001);
	}

	@Test
	public void UmaVendaDe5559TemComissaoDe() {
		double totalVenda = 55.59;
		double comissaoEsperada = 2.77;

		double comissaoCalculada = CalculadoraComissao.calcular(totalVenda);
		Assert.assertEquals(comissaoEsperada, comissaoCalculada, 0.00);
	}
	@Test
	public void UmaVendaDe9999_99TemComissaoDe499_99() {
		double totalVenda = 9999.99;
		double comissaoEsperada = 499.99;

		double comissaoCalculada = CalculadoraComissao.calcular(totalVenda);
		Assert.assertEquals(comissaoEsperada, comissaoCalculada, 0.00);
	}
}