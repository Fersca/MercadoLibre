import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Problema {

	public static void main(String[] args) throws NoRepeatedNumbersInListException, SeveralRepeatedNumbersInListException {

		//Creo la lista de números
		LinkedList<Integer> numeros = new LinkedList<Integer>(Arrays.asList(1,1,1,3,4,3,3,3,4,5,3,1,3)); 

		//Busco el más repetido
		Integer result = mayorRepetido(numeros);

		System.out.println("Mayor Repetido: "+ result);

	}
	
	/**
	 * Devuelve el número con mayor cantidad de ocurrencias.
	 *
	 * @param	numeros  Lista de números, no necesariamente ordenada.
	 * @return	El número con mayor cantidad de ocurrencias.
	 * @throws NoRepeatedNumbersInListException 
	 * @throws SeveralRepeatedNumbersInListException 
	 */
	static Integer mayorRepetido(LinkedList<Integer> numeros) throws NoRepeatedNumbersInListException, SeveralRepeatedNumbersInListException {

		//En esta variable me voy quedando con el más repetido
		Integer repetido = null;

		//En esta variable me quedo con la cantidad de repeticiones
		Integer repeticiones = 0;
		
		Integer variosRepetidos = null;

		//Instancio un mapa que contendrá por cada numero de la lista una key con su cantidad de repeticiones como value
		Map<Integer, Integer> mapaNumeros = new HashMap<Integer, Integer>();
		
		//Recorro la lista para popular el mapa
		for ( Integer num : numeros ) {
		    Integer contador = mapaNumeros.get( num );
		    mapaNumeros.put( num, contador != null ? contador+1 : 0 );
		}
		
		//Recorro el mapa para encontrar el número (key) con mayor cantidad de repeticiones (value)
		for (Map.Entry<Integer, Integer> entrada : mapaNumeros.entrySet()) {

			Integer valorEntradaActual = entrada.getValue();
			Integer claveEntradaActual = entrada.getKey();

			if (valorEntradaActual > repeticiones) {
				repetido = claveEntradaActual;
				repeticiones = valorEntradaActual;
			} else if (valorEntradaActual != 0
					&& valorEntradaActual.equals(repeticiones)) {
				variosRepetidos = valorEntradaActual;
			}

		}
		
		//Si hay varios números repetidos una máxima cantidad de veces se arroja la excepción correspondiente
		if( variosRepetidos != null && variosRepetidos >= repeticiones )
		{
			throw new SeveralRepeatedNumbersInListException( "Hay mas de un numero repetido en la lista dada." );
		}
		//Si no hay repetidos se arroja la excepción acorde al caso
		if( repetido == null )
		{
			throw new NoRepeatedNumbersInListException( "No hay repetidos en la lista dada." );
		}

		//Devuelvo el más repetido
		return repetido;
	}

}