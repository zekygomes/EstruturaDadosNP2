package com.unifor.estrutura.dados.ordenacaotopologica;

import java.util.List;

public class No{
		Integer valor;
		Integer qtdDependencias;
		List<Integer> listaDependentes;
		
		
		public No(int valor, int qtdDependencias, List <Integer> listaDependentes) {
			this.valor = valor;
			this.qtdDependencias = qtdDependencias;
			this.listaDependentes = listaDependentes;
		}
		
		
	}