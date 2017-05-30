package com.unifor.estrutura.dados.ordenacaotopologica;

import java.util.List;

public class Tarefa{
		int valor;
		int qtdDependencias;
		List <Integer> listaDependencias;
		
		
		public Tarefa(int valor, int qtdDependencias, List<Integer> listaDependencias) {
			super();
			this.valor = valor;
			this.qtdDependencias = qtdDependencias;
			this.listaDependencias = listaDependencias;
		}
		
		
	}