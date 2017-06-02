package com.unifor.estrutura.dados.ordenacaotopologica;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		List <No> nos=new ArrayList <No>();
		
		List <Integer> dependencia1=new ArrayList <Integer>();
		List <Integer> dependencia2=new ArrayList <Integer>();
		List <Integer> dependencia3=new ArrayList <Integer>();
		List <Integer> dependencia4=new ArrayList <Integer>();
		
		dependencia1.add(2);
		dependencia1.add(2);
	
		nos.add(new No(1, 1, dependencia1));
		nos.add(new No(2, 0, dependencia2));
		nos.add(new No(3, 1, dependencia3));
		nos.add(new No(4, 0, dependencia4));
		
		Tarefa tarefa = new Tarefa(nos);
		
		//imprimeNos(nos);
		System.out.println();
		imprimeLista(ordena(tarefa));	
		
		
		

	}
	
	private static List<Integer> ordena(Tarefa tarefa) {
		Queue<Integer> fila = new LinkedList<Integer>();
		List<Integer> resultado = new ArrayList<Integer>();
		
		for(Map.Entry<Integer,No> no : tarefa.tarefas.entrySet()){
			//verficia se não há dependencias
			if(isDependeciasEmpty(no.getValue().qtdDependencias)){
				//Adiciona o valor na fila
				fila.add(no.getValue().valor);
				//Verficar os sucessores para decrementar dependências e apagar da lista, se houver
				decrementarDependenciasApagandoDaLista(no.getValue().valor, tarefa);
				resultado.add(fila.poll());
			}
		}
		return resultado;
	}

	private static void decrementarDependenciasApagandoDaLista(int valor, Tarefa tarefa){
			//intera cada no da tarefa
			for(Map.Entry<Integer,No> no : tarefa.tarefas.entrySet()){
				//intera cada valor da Lista de Dependencias de cada no
				for(Integer inter : no.getValue().listaDependentes){
					//Verfica se a dependencia é igual ao valor passado
					if(inter.equals(valor));
					//Se for, é preciso decrementar a dependencia Dela 
					tarefa.tarefas.get(valor).qtdDependencias--;
					//e apagar da lista de dependencias
					//no.getValue().listaDependentes.remove(valor);
				}
			}
	}
	
	private static boolean isDependeciasEmpty(int qtdDependencias){
		
		return qtdDependencias==0;
	}
	
	public static void imprimeNos(List<No> nos){
		
		System.out.printf("Valor \t| QtdDepend \t| ListaDependentes\n");
		for(No no : nos){
			int tamanhoLista= no.listaDependentes.size();
			if(tamanhoLista == 0){
				tamanhoLista++;
				for (int i = 0; i < tamanhoLista; i++) {
					System.out.printf("%d \t| %d \t\t|  \n", no.valor, no.qtdDependencias);
				}
			}else{
				for (int i = 0; i < tamanhoLista; i++) {
					System.out.printf("%d \t| %d \t\t| %d \n", no.valor, no.qtdDependencias, no.listaDependentes.get(i));
					
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
