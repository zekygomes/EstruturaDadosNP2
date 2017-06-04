package com.unifor.estrutura.dados.ordenacaotopologica;

import java.util.ArrayList;
import java.util.List;

public class Node{
		Integer valor;
		Integer qtdDependencias;
		List<Integer> listaDependentes;
		
		public Node() {
			
		}
		
		public Node(int valor, int qtdDependencias, List <Integer> listaDependentes) {
			this.valor = valor;
			this.qtdDependencias = qtdDependencias;
			this.listaDependentes = listaDependentes;
		}
		
		public Node clone(Node node){
			Node node2 = new Node();
			int valor = node.valor;
			int qtdDependecies = node.qtdDependencias;
			List<Integer> dependentsList = new ArrayList<Integer>();
			for(int lista: node.listaDependentes){
				dependentsList.add(lista);
			}
			node2.valor =valor;
			node2.qtdDependencias = qtdDependecies;
			node2.listaDependentes = dependentsList;
			return node2;
			
		}
		
		
	}