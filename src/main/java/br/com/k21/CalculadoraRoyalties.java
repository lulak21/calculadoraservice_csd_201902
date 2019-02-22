package br.com.k21;

import java.util.List;

import br.com.k21.dao.VendaRepository;
import br.com.k21.modelo.Venda;

public class CalculadoraRoyalties {

	VendaRepository vendaRepository = new VendaRepository();
	
	public CalculadoraRoyalties() {
		this.vendaRepository = new VendaRepository();
	}
	
	public CalculadoraRoyalties(VendaRepository marionete) {
		// TODO Auto-generated constructor stub
		this.vendaRepository = marionete;
	}

	public double calcularRoyalties(int mes, int ano) {
		
		List<Venda> vendas = vendaRepository.obterVendasPorMesEAno(ano, mes);
		
		double vendasTotal    = 0;
		double comissoesTotal = 0;
		double faturamento    = 0;
		for (Venda venda : vendas) {
			double comissao = CalculadoraComissao.calcular(venda.getValor());
			vendasTotal += venda.getValor();
			comissoesTotal += comissao;
			
			
		}
		faturamento = vendasTotal - comissoesTotal;
		double royalties  = truncar(faturamento * 0.2);
		return royalties;
		
	}

	private static double truncar(double venda) {
		return Math.floor(venda  * 100.0) / 100.0;
	}
}
