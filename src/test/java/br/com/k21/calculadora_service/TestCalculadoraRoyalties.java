package br.com.k21.calculadora_service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.k21.CalculadoraRoyalties;
import br.com.k21.dao.VendaRepository;
import br.com.k21.modelo.Venda;

public class TestCalculadoraRoyalties {
	
	VendaRepository marionete;
	List<Venda> listaVendas;
	
	@Before
	public void criarMarionete()
	{
		marionete = Mockito.mock(VendaRepository.class);	
		listaVendas = new ArrayList<Venda>();
	}

	@Test
	public void teste_mes_1_ano_2019_retorna_10000() {

		int mes = 1;
		int ano = 2019;
		int result = 1900;

		double royaltiesCalculado = new CalculadoraRoyalties().calcularRoyalties(mes, ano);

		assertEquals(result, royaltiesCalculado, 0);
	}
	
	@Test
	public void teste_mes_sem_vendas_retorna_0() {

		int mes = 7;
		int ano = 2018;
		int result = 0;

		double royaltiesCalculado = new CalculadoraRoyalties(marionete).calcularRoyalties(mes, ano);

		assertEquals(result, royaltiesCalculado, 0);
	}
	@Test
	public void teste_mes_com_vendas_retorna_2820() {

		//Arrange
		int mes = 2;
		int ano = 2019;
		int result = 2820;

		
		listaVendas.add(new Venda(1, 1, mes, ano, 15000));
		Mockito.when(marionete.obterVendasPorMesEAno(ano, mes)).thenReturn(listaVendas);
		
		//Act
		double royaltiesCalculado = new CalculadoraRoyalties(marionete).calcularRoyalties(mes, ano);

		//Assert
		assertEquals(result, royaltiesCalculado,0);
	}
	
	@Test
	public void teste_mes_com_vendas_retorna_29_56() {

		int mes = 1;
		int ano = 2019;
		double result = 29.56;
		
		listaVendas.add(new Venda(1, 1, mes, ano, 55.59));
		listaVendas.add(new Venda(2, 1, mes, ano, 100));
		
		Mockito.when(marionete.obterVendasPorMesEAno(ano, mes)).thenReturn(listaVendas);
		
		//Act
		double royaltiesCalculado = new CalculadoraRoyalties(marionete).calcularRoyalties(mes, ano);

		assertEquals(result, royaltiesCalculado,0);
	}
}