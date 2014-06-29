package com.mercadolibre.problemajava;

import java.util.Arrays;
import java.util.LinkedList;

public class Problema {

	
	public static void main(String[] args) {
		ContadorDeRepeticiones counter = new ContadorOptimo();
		
		//Creo la lista de nœmeros
		LinkedList<Integer> numeros = new LinkedList<Integer>(Arrays.asList(1,1,1,3,4,3,3,3,4,5,3,1,3)); 

		//Busco el m‡s repetido
		Integer result = counter.mayorRepetido(numeros);

		System.out.println("Mayor Repetido: "+ result);

	}

}
