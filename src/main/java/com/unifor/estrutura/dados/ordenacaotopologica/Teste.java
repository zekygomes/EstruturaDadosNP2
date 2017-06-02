package com.unifor.estrutura.dados.ordenacaotopologica;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List <Integer> dependencia1=new ArrayList <Integer>();
		List <Integer> dependencia2=new ArrayList <Integer>();
		List <Integer> dependencia3=new ArrayList <Integer>();
		
		dependencia2.add(1);
		dependencia3.add(1);
		dependencia1.add(3);
		
		
		List <Tarefa> testando;
		Tarefa um = new Tarefa(1, 2, dependencia1);
		Tarefa dois = new Tarefa(1, 2, dependencia2);
		Tarefa tres = new Tarefa(1, 2, dependencia3);
		
		ordena(tarefas);
		

	}
	
	private static void ordena(List<Tarefa> tarefas) {
		Stack<Integer> resultado = new Stack<Integer>();
		for(Tarefa tarefa : tarefas){
			if(isQtdDependeciasZero(tarefa.qtdDependencias)){
				resultado.push(tarefa.valor);
				tarefas.remove(tarefa);
				for(int i = 0; i < tarefas.size(); i++){
					int dependencia = resultado.pop();
					int qtdDependencia = tarefas.get(i).qtdDependencias;
					List<Integer> lista = tarefas.get(i).listaDependencias;
					apagarDependencia(qtdDependencia, lista, dependencia);
				}
				
				
			}
		}
		
		
	}
	
	private static boolean isQtdDependeciasZero(int qtdDependencias){
		
		return qtdDependencias==0;
	}
	
	private static void apagarDependencia(int qtdDependencia, List <Integer> listas, int dependencia ){
		for(Integer lista: listas){
			if(lista == dependencia){
				listas.remove(lista);
				dependencia--;
			}
		}
		
	}


}
