package com.unifor.estrutura.dados.ordenacaotopologica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tarefa{
	//List<No> nos= new ArrayList<No>();
	
	Map<Integer,No> tarefas = new HashMap<Integer,No>();
	
	public Tarefa(ArrayList<No> nos){
		for(No no : nos){
			this.tarefas.put(no.valor, no);
		}
	}
	public static void main(String[] args) {
		ArrayList <No> no = new ArrayList<No>();
		
		List<Integer>teste1 = new ArrayList<Integer>();
		teste1.add(0);
		teste1.add(1);
		
		no.add(new No(1,0,teste1));
		no.add(new No(2,4,teste1));
		
		Tarefa tarefa = new Tarefa(no);
		
		
		System.out.println(tarefa.tarefas.get(2).qtdDependencias);
	}
}
	