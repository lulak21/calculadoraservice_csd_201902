package br.com.k21.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.k21.modelo.Venda;

public class VendaRepository {

	public List<Venda> obterVendasPorMesEAno(int ano , int mes ){	
		List<Venda> lista = new ArrayList<Venda>();
		lista.add(new Venda(1, 1, 1, 2019, 10000));
		
		return lista;

	}

}
