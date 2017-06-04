package com.unifor.estrutura.dados.ordenacaotopologica;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
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
