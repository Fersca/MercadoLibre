package com.mercadolibre.problemajava;

import java.util.Arrays;
import java.util.LinkedList;

import junit.framework.TestCase;

import org.junit.Test;

public class MayorRepetidoTest extends TestCase {
    
	private ContadorDeRepeticiones counter;
	//Creo la lista de nœmeros
	private LinkedList<Integer> numeros = new LinkedList<Integer>(Arrays.asList(1,1,1,3,4,3,3,3,4,5,3,1,3));
	
	@Test
	public void test1() {
		Integer expectedValue = 3;
		counter = new ContadorOriginal(); 
		assertEquals(expectedValue, counter.mayorRepetido(numeros));
	}
	
	@Test
	public void test2() {
		Integer expectedValue = 3;
		counter = new ContadorQueRecorreUnaVez(); 
		assertEquals(expectedValue, counter.mayorRepetido(numeros));
	}
	
	@Test
	public void test3() {
		Integer expectedValue = 3;
		counter = new ContadorOptimo(); 
		assertEquals(expectedValue, counter.mayorRepetido(numeros));
	}
}
