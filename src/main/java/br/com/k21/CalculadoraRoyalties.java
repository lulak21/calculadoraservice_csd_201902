package br.com.k21;

import java.util.List;

import br.com.k21.dao.VendaRepository;
import br.com.k21.modelo.Venda;

public class CalculadoraRoyalties {

	private VendaRepository _repository;
	public CalculadoraRoyalties(VendaRepository repository) {
		
		_repository = repository;
		// TODO Auto-generated constructor stub
	}
	
	public CalculadoraRoyalties() {
		_repository = new VendaRepository();
	}

	public double calcularRoyalties(int mes, int ano) {
		CalculadoraComissao calculadoraComissao = new CalculadoraComissao();
		List<Venda> vendas = _repository.obterVendasPorMesEAno(ano,  mes);
		
		//Comissao por vendas
		double valorComissao = 0;
		double valorFaturamento = 0;
		
		for (int i = 0; i < vendas.size(); i++) {
			double valorVenda = vendas.get(i).getValor();
			
			valorComissao += calculadoraComissao.calcular(valorVenda);
			valorFaturamento += valorVenda;
		}
				
		double valorRoyalties = (valorFaturamento - valorComissao) * 0.2;
		
		return Math.floor(valorRoyalties * 100)/100;
		
	}
}
