package com.unifor.estrutura.dados.ordenacaotopologica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Tasks{
	//List<No> nos= new ArrayList<No>();
	
	Map<Integer,Node> tarefas = new HashMap<Integer,Node>();
	
	public Tasks(){
		
	}

	public Tasks(List<Node> nos){
		for(Node no : nos){
			this.tarefas.put(no.valor, no);
		}
	}
	
	
	public Map<Integer, Node> getTarefas() {
		return tarefas;
	}

	public void setTarefas(Map<Integer, Node> tarefas) {
		this.tarefas = tarefas;
	}
	public static void main(String[] args) {
		ArrayList <Node> no = new ArrayList<Node>();
		
		List<Integer>teste1 = new ArrayList<Integer>();
		teste1.add(0);
		teste1.add(1);
		
		no.add(new Node(1,0,teste1));
		no.add(new Node(2,4,teste1));
		
		Tasks tarefa = new Tasks(no);
		
		
		System.out.println(tarefa.tarefas.get(2).qtdDependencias);
	}
	
	public int size(){
		return this.tarefas.size();
	}
	
	public Node getNode(Integer Key){
		
		return this.tarefas.get(Key);
	}
	
	public static Tasks clone(Tasks tarefa){
		Tasks tarefa2 = new Tasks();
		for (Node node: tarefa.tarefas.values()) {
			tarefa2.tarefas.put(node.valor, node);
		}
		return tarefa2;
		
	}
	
	public void getDependentsList(){
		
	}
	
	public Integer getDependencies(Node no){
		return no.qtdDependencias;
	}
	
	public Set<Map.Entry<Integer,Node>> getEachNode(){
		return this.tarefas.entrySet();
	}
}
	