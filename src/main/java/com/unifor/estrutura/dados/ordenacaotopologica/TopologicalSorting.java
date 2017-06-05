package com.unifor.estrutura.dados.ordenacaotopologica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.unifor.estrutura.dados.ordenacaotopologica.Queue;

/** Trabalho da disciplina de Estrutura de Dados - Unifor - 2017.2
 * 	Professor: 
 *		- Adriano Patrick do Nascimento Cunha - adriano.cunha@unifor.br
 *	Equipe:
 *		- nome - email
 *		- nome - email
 *	Problema:
 * 		QUESTÃO ÚNICA: 
 *			Implementar um algoritmo de utilizando uma estrutura de dados do tipo FILA para solucionar o problema
 *			da ordenação topológica. A Ordenação topológica é um grafo acíclico orientado, onde cada vértice 
 *			esteja ordenado pela dependência existente entre os vértices. (https://www.youtube.com/watch?v=URdtNUdxU3o)
 *			Conceitos:
 *			- Uma permutação dos vértices de um digrafo é uma sequência em que cada vértice aparece uma só vez
 *			- Uma ordenação topológica é uma permutação dos vértices v1, ..., vn,
 *				de um digrafo acíclico, de forma que para qualquer aresta (vi ; vj ), i < j .
 *				- qualquer caminho entre vi e vj não passa por vk se k < i ou k > j . 
 *			- Digrafos com ciclos não admitem ordenação topológica.
 *		ENTRADA: 
 *			O arquivo de entrada contém várias instâncias do problema. Cada linha inicia com o número de tarefas, 
 *			seguido da lista de dependências entre estas tarefas, as dependências são representas como vértices do
 *			tipo: (a, b), onde "a" representa a tarefa a qual "b" depende, ou seja, para que "b" seja executado é 
 *			necessário que "a" tenha terminado. Não será inserido digrafo cíclico.
 *		SAIDA: 
 *			A saída consiste de tantas linhas quantas instâncias do problema houver. Em cada linha, devem ser
 *		impressos a lista de tarefas ordenadas topologicamente, ou seja, com base na dependência das tarefas.
 *		EXEMPLO:
 *			Entrada:
 *				1 
 *				4 (2,1) (2,3)
 *				5 (2,1) (2,3) (3,1) (1,5)
 *			Saída:
 *				1
 *				4, 2, 1, 3
 *				4, 2, 3, 1, 5
**/
/**
 * @author patrick.cunha
 * @since 24/05/2017 - Ordenação Topológica
 */
public class TopologicalSorting {

	/**
	 * Método que realiza a ordenação topológica.
	 */
	public static List<Integer> topologicalSort(Tasks tarefa) {
		Queue<Integer> fila = new Queue<Integer>();
		List<Integer> resultado = new ArrayList<Integer>();
		Tasks temporario = Tasks.clone(tarefa);
		// intera cada linha(nó) da tarefa
		Iterator<Map.Entry<Integer, Node>> Node = temporario.getEachNode().iterator();
		
		
		while (resultado.size() < tarefa.size()) {
			while (Node.hasNext()) {
				Map.Entry<Integer, Node> node = Node.next();
				if (isDependenceEmpty(node.getValue().getQtdDependencias())) {
					// verfica se não há dependencias e Adiciona o valor na fila
					fila.add(node.getValue().getValor());
					Node.remove();
				}
			}
			while (fila.size() != 0) {
				Integer valor = fila.peek();
				// Verficar os sucessores para decrementar dependências de todos
				// na Lista de Dependentes
				if (!isDependentsListEmpty(tarefa.getNode(valor).getListaDependentes())) {
					decreaseDependenceFromDependentsList(valor, tarefa);
					// e apagar a lista de dependentes
					clearDependentsList(tarefa.getNode(valor).getListaDependentes());
				}
				// Adiciona o valor na lista
				resultado.add(fila.poll());
			} 
			Node = temporario.getEachNode().iterator();
		}
		return resultado;
	}

	private static void decreaseDependenceFromDependentsList(Integer valor, Tasks tarefa) {
		for (Integer index : tarefa.getTarefas().get(valor).getListaDependentes()) {
			// Decrementa a qtd de dependencias dos nós encontrados na lista de
			// dependentes(pelo keySet do Map)
			tarefa.getNode(index).decreaseDependence();
		}
	}

	private static boolean isDependenceEmpty(Integer qtdDependencias) {
		return qtdDependencias == 0;
	}

	private static boolean isDependentsListEmpty(List<Integer> listaDependentes) {
		return listaDependentes.size() == 0 ? true : false;
	}

	private static void clearDependentsList(List<Integer> listaDependentes) {
		listaDependentes.clear();
	}

}