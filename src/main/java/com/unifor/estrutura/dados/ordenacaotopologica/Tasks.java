package com.unifor.estrutura.dados.ordenacaotopologica;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Tasks{
	private Map<Integer,Node> tarefas = new HashMap<Integer,Node>();
	
	public Tasks(){
	}

	public Tasks(List<Node> nos){
		for(Node no : nos){
			this.tarefas.put(no.getValor(), no);
		}
	}
	
	public Map<Integer, Node> getTarefas() {
		return this.tarefas;
	}

	public void setTarefas(List<Node> nos) {
		for(Node no : nos){
			this.tarefas.put(no.getValor(), no);
		}
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
			tarefa2.tarefas.put(node.getValor(), node);
		}
		return tarefa2;
		
	}
	
	public void addNode(Node no){
		this.tarefas.put(no.getValor(), no);
	}
	
	public Integer getDependencies(Node no){
		return no.getQtdDependencias();
	}
	
	public Set<Map.Entry<Integer,Node>> getEachNode(){
		return this.tarefas.entrySet();
	}
	
	
}
	