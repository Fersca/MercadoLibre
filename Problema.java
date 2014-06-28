import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Problema {
	
	public static void main(String[] args) {

		//Creo la lista de números
		LinkedList<Integer> numeros = new LinkedList<Integer>(Arrays.asList(1,1,1,3,4,3,3,3,4,5,3,1,3));

		//Busco el más repetido
		Integer result = mayorRepetido(numeros);
		
		System.out.println("Mayor Repetido: "+ result);
		
	}

    // orden: n log(n)
    private static Integer mayorRepetido(LinkedList<Integer> numeros) {
        // se ordena para generar secuencias de rafagas
        // orden: n log(n)
        Collections.sort(numeros);

        // variables para guardar el resultado final
        Integer maxValorRafaga = null;
        int maxLargoRafaga = 0;

        // variables para el calculo temporal en la recorrida
        Integer valorRafagaActual = null;
        int largoRafagaActual = 0;

        // se busca la rafaga de numeros mas larga
        // orden: n
        for (Integer numero : numeros) {
            // caso inicial
            if (valorRafagaActual == null) {
                valorRafagaActual = numero;
                largoRafagaActual ++;

            // se aumenta el tamaño de la rafaga
            } else if (valorRafagaActual.equals(numero)) {
                largoRafagaActual ++;

            // comienza otra rafaga de numero, chequeo si
            // la finalizada es la mayor hasta ahora
            } else {
                if (largoRafagaActual > maxLargoRafaga) {
                    maxLargoRafaga = largoRafagaActual;
                    maxValorRafaga = valorRafagaActual;
                }
                valorRafagaActual = numero;
                largoRafagaActual = 1;
            }
        }
        if (largoRafagaActual > maxLargoRafaga) {
            maxValorRafaga = valorRafagaActual;
        }

        return maxValorRafaga;
    }
}
