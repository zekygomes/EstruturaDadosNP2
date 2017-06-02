package com.unifor.estrutura.dados.ordenacaotopologica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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
public class OrdenacaoTopologica {

	//private static final String DELIMITADORES = "\\(|\\)";

	public static void main(String[] args) throws IOException {
		// recebe o arquivo via argumentos ou ler o arquivo padrão da sua pasta
		//InputStream input = args.length > 0 ? new FileInputStream(args[0])
		//		: OrdenacaoTopologica.class.getResourceAsStream("entrada.in");
		//processa(new java.io.InputStreamReader(input));
		//System.exit(0);
	}

	/**
	 * Método principal
	 
	private static void processa(Reader readerInput) {
		entrada(readerInput);
		ordena();
		saida();
	}*/

	/**
	 * Processa a entrada
	
	private static void entrada(Reader readerInput) {
		try (BufferedReader br = new BufferedReader(readerInput)) {
			Stream<String> linhas = br.lines();
			linhas.forEach((linha) -> {
				StringTokenizer token = new StringTokenizer(linha.replaceAll(" ", ""), DELIMITADORES));
				//token.nextToken()   //pega o próximo token da linha
				//token.countTokens()	//informa quantos tokens existem na linha
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 */
	/**
	 * Método que realiza a ordenação topológica.
	 */
	private static void ordena(Tarefa tarefa) {
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
					no.getValue().listaDependentes.remove(valor);
				}
			}
	}
	
	private static boolean isDependeciasEmpty(int qtdDependencias){
		
		return qtdDependencias==0;
	}
	
	//private static void apagarDependencia(int qtdDependencia, List <Integer> listas, int dependencia ){
	//		for(Integer lista: listas){
	//			if(lista == dependencia){
	//			listas.remove(lista);
	//			dependencia--;
	//		}
	//	}
	//	
	//}


	/**
	 * Processa a saída
	
	private static void saida() {
		try (PrintWriter arquivo = new PrintWriter(
				new FileWriter("saida.out", true))) {
			

				//arquivo.append(string) //adiciona linha ao arquivo
				
				//arquivo.printf("\r\n");   //quebra de linha
			}
		 catch (IOException e) {
			System.out.println("deu erro");
		}
	}
	 */

}