package br.com.k21;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.k21.dao.VendaRepository;
import br.com.k21.modelo.Venda;

public class TestCalculadoraRoyalties {

	private VendaRepository marionete;

	@Before
	public void marioneteFactory()
	{
		marionete = Mockito.mock(VendaRepository.class);
	}
	
	@Test
	public void teste_mes_sem_vendas_retorna_0() {

		int mes = 7;
		int ano = 2018;
		int royaltiesEsperado = 0;


		CalculadoraRoyalties calculadora = new CalculadoraRoyalties(marionete);

		double royaltiesCalculado = calculadora.calcularRoyalties(mes, ano);

		assertEquals(royaltiesEsperado, royaltiesCalculado, 0);
	}

	@Test
	public void teste_mes_com_uma_venda_de_dez_mil_retorna_1900() {

		int mes = 1;
		int ano = 2019;
		int royaltiesEsperado = 1900;


		// conectar cabos
		List<Venda> vendas = new ArrayList<Venda>();
		Venda venda = new Venda(1, 1, mes, ano, 10000);
		vendas.add(venda);
		Mockito.when(marionete.obterVendasPorMesEAno(ano, mes)).thenReturn(vendas);

		CalculadoraRoyalties calculadora = new CalculadoraRoyalties(marionete);

		double royaltiesCalculado = calculadora.calcularRoyalties(mes, ano);

		assertEquals(royaltiesEsperado, royaltiesCalculado, 0);
	}

	@Test
	public void teste_mes_com_uma_venda_de_dez_mil_retorna_2360_56() {

		int mes = 2;
		int ano = 2019;
		double royaltiesEsperado = 2360.56;

		
		// conectar cabos
		List<Venda> vendas = new ArrayList<Venda>();
		vendas.add(new Venda(1, 1, mes, ano, 55.59));
		vendas.add(new Venda(2, 1, mes, ano, 12500));
		Mockito.when(marionete.obterVendasPorMesEAno(ano, mes)).thenReturn(vendas);

		CalculadoraRoyalties calculadora = new CalculadoraRoyalties(marionete);

		double royaltiesCalculado = calculadora.calcularRoyalties(mes, ano);

		assertEquals(royaltiesEsperado, royaltiesCalculado, 0);
	}

}
