package com.unifor.estrutura.dados.ordenacaotopologica;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App {
	 private static final String DELIMITADORES = "\\(|\\)";

	public static void main(String[] args) throws IOException {
		// recebe o arquivo via argumentos ou ler o arquivo padrão da sua pasta
		InputStream input = args.length > 0 ? new FileInputStream(args[0])
		: App.class.getResourceAsStream("entrada.in");
		
		processa(new InputStreamReader(input));
		
		System.exit(0);
	}

	/**
	 * Método principal
	 **/
	private static void processa(Reader readerInput) {
		List <Tasks> teste = entrada(readerInput);
		System.out.println(ordena(teste));
		saida();
	}

	/**
	 * Processa a entrada
	 **/
	private static List <Tasks> entrada(Reader readerInput) {
		List <Tasks> tarefas = new ArrayList<Tasks>();
	
		try(BufferedReader br = new BufferedReader(readerInput)){
			Stream<String> linhas = br.lines();
			linhas.forEach((linha) -> {
				StringTokenizer token = new StringTokenizer(linha.replaceAll(" ", ""), DELIMITADORES);
				Integer qtdNodes = Integer.parseInt(token.nextToken());
				Tasks tarefa = new Tasks();
				for (int i = 1; i <= qtdNodes; i++) {
					tarefa.addNode(new Node(i));
				}
				for (int i = 0; i < token.countTokens(); i++) {
					String[] dependencias = token.nextToken().split(",");
					Integer denpendencia = Integer.parseInt(dependencias[0]);
					Integer denpendente = Integer.parseInt(dependencias[1]);
					
					tarefa.getNode(denpendencia).increaseDependence();
					tarefa.getNode(denpendencia).addOnListaDependentes(denpendente);
				}
				tarefas.add(tarefa);
				//token.nextToken()   //pega o próximo token da linha
				//token.countTokens()	//informa quantos tokens existem na linha
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tarefas;
	}
	
	private static String ordena(List <Tasks> teste){
		List <Integer> resultado;
		StringBuilder arquivo  = new StringBuilder();
		
		for(Tasks tarefa : teste){
			resultado = TopologicalSorting.topologicalSort(tarefa);
			for(Integer inter : resultado){
				arquivo.append(inter);
				arquivo.append(" ");
			}
			arquivo.append("\n");
		}
		
		return arquivo.toString();
	}

	/**
	 * Processa a saída
	 **/
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
}
