package com.unifor.estrutura.dados.ordenacaotopologica;

import java.util.ArrayList;
import java.util.List;

public class GeneralTest {
	public static void main(String[] args) {
		List <Node> nos=new ArrayList <Node>();
		
		List <Integer> dependencia1=new ArrayList <Integer>();
		List <Integer> dependencia2=new ArrayList <Integer>();
		List <Integer> dependencia3=new ArrayList <Integer>();
		List <Integer> dependencia4=new ArrayList <Integer>();
		
		dependencia2.add(1);
		dependencia2.add(3);
	
		nos.add(new Node(1, 1, dependencia1));
		nos.add(new Node(2, 0, dependencia2));
		nos.add(new Node(3, 1, dependencia3));
		nos.add(new Node(4, 0, dependencia4));
		
		Tasks tarefa = new Tasks(nos);
		
		imprimeNos(nos);
		System.out.println();
		imprimeLista(TopologicalSorting.topologicalSort(tarefa));	
		

	}
	
	public static void imprimeNos(List<Node> nos){
		System.out.printf("Valor \t| QtdDepencias \t| ListaDependentes\n");
		for(Node no : nos){
			int tamanhoLista= no.getListaDependentes().size();
			if(tamanhoLista == 0){
				tamanhoLista++;
				for (int i = 0; i < tamanhoLista; i++) {
					System.out.printf("%d \t| %d \t\t|  \n", no.getValor(), no.getQtdDependencias());
				}
			}else{
				for (int i = 0; i < tamanhoLista; i++) {
					System.out.printf("%d \t| %d \t\t| %d \n", no.getValor(), no.getQtdDependencias(), no.getListaDependentes().get(i));
					
				}
			}
		}
		
	}
	
	private static void imprimeLista(List<Integer> fila){
		for(Integer inte: fila){
			System.out.printf("%d ",inte);
		}
	}
	
	
}
