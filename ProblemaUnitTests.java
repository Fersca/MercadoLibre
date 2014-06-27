import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class ProblemaUnitTests {

	@Before
	public void setUp() throws Exception {

	}

	private void mostrarResultados(Integer masRepetido) {
		System.out.println("Mayor Repetido: " + masRepetido);
	}

	@Test
	public void testUno() throws NoRepeatedNumbersInListException, SeveralRepeatedNumbersInListException {
		
		this.mostrarResultados( Problema.mayorRepetido(new LinkedList<Integer>(Arrays.asList(1,1,1,1,1,1,2,2,3,3,3,4,4,4,5,5,5,5,5))) );

	}
	
	@Test
	public void testDos() throws NoRepeatedNumbersInListException, SeveralRepeatedNumbersInListException {
		
		this.mostrarResultados( Problema.mayorRepetido(new LinkedList<Integer>(Arrays.asList(1,2,2,2,2,2,2,2,3,3,3,4,4,4,4,5,5,5,5,5))) );

	}
	
	@Test
	public void testTres() throws NoRepeatedNumbersInListException, SeveralRepeatedNumbersInListException {
		
		this.mostrarResultados( Problema.mayorRepetido(new LinkedList<Integer>(Arrays.asList(1,2,2,3,3,3,3,3,4,4,5,5,6,6,6,6))) );

	}
	
	//El test pasará solo si la excepción correspondiente al caso de no haber repetidos es arrojada
	@Test(expected=NoRepeatedNumbersInListException.class)
	public void testNoRepetidos() throws NoRepeatedNumbersInListException, SeveralRepeatedNumbersInListException {
		
		this.mostrarResultados( Problema.mayorRepetido(new LinkedList<Integer>(Arrays.asList(1,2,3))) );

	}
	
	//El test pasará solo si la excepción correspondiente al caso de haber la misma cantidad de ocurrencias repetidas de mas de un número es arrojada
	@Test(expected=SeveralRepeatedNumbersInListException.class)
	public void testMismasOcurenciasDeVariosRepetidos() throws SeveralRepeatedNumbersInListException, NoRepeatedNumbersInListException {
		
		this.mostrarResultados( Problema.mayorRepetido(new LinkedList<Integer>(Arrays.asList(1,1,2,2,3,4,5,6))) );

	}
	
	@Test
	public void testTresNightmare() throws SeveralRepeatedNumbersInListException, NoRepeatedNumbersInListException {
		
		this.mostrarResultados( Problema.mayorRepetido(new LinkedList<Integer>(Arrays.asList(1,1,2,2,3,3,3,4,5,6))) );

	}
	


}
