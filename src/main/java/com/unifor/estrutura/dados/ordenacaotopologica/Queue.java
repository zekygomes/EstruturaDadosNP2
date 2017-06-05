package com.unifor.estrutura.dados.ordenacaotopologica;

import java.util.ArrayList;
import java.util.List;

public class Queue<E> {

	private List<E> fila = new ArrayList<>();
	
	public void add(E e) {
		this.fila.add(e);
	}

	@SuppressWarnings("unchecked")
	public E poll() {
		Integer retorno= null;
		if(!this.fila.isEmpty()){
			if(this.fila.get(0).getClass().equals(Integer.class) ){
				int e = (int) this.fila.get(0);
				retorno =e;
				this.fila.remove(0);
				return (E) retorno;
			}
			
		}
		
		return null;
	}

	public E peek() {
		return this.fila.get(0);
	}

	public boolean isEmpty() {
		return this.fila.isEmpty();
	}
	
	public int size(){
		return this.fila.size();
	}
}