package com.unifor.estrutura.dados.ordenacaotopologica;

import java.util.ArrayList;
import java.util.List;

public class Node{
		private Integer valor;
		private Integer qtdDependencias;
		private List<Integer> listaDependentes;
		
		public Node() {
		}
		
		public Node(int valor) {
			this.valor=valor;
			this.qtdDependencias = null;
			this.listaDependentes = null;
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
		
		public void decreaseDependence(){
			this.qtdDependencias--;
		}
		
		public void increaseDependence(){
			this.qtdDependencias = qtdDependencias + 1;
		}
		
		public Integer getValor() {
			return valor;
		}

		public void setValor(Integer valor) {
			this.valor = valor;
		}

		public Integer getQtdDependencias() {
			return qtdDependencias;
		}

		public void setQtdDependencias(Integer qtdDependencias) {
			this.qtdDependencias = qtdDependencias;
		}
		
		public void addOnListaDependentes(Integer item) {
			this.listaDependentes.add(item);
		}

		public List<Integer> getListaDependentes() {
			return listaDependentes;
		}

		public void setListaDependentes(List<Integer> listaDependentes) {
			this.listaDependentes = listaDependentes;
		}
		
		
	}