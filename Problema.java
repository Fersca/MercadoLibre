import java.util.Arrays;
import java.util.LinkedList;

public class Problema {
	
	public static void main(String[] args) throws Exception {

		//Creo la lista de números
		LinkedList<Integer> numeros = new LinkedList<Integer>(Arrays.asList(null,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,1,1,1,3,4,3,3,3,4,5,3,1,3,8,8,8,8,8,8,8,9,2,2,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,-1,1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,3,4,5,6,7,8,11,9)); 
				
		//Busco el más repetido
		Integer result = mayorRepetido(numeros);
		
		System.out.println("Mayor Repetido: "+ result);
		
	}

    // el costo de esta funcion es:
    // en tiempo:  O(n^2)
    // en espacio: O(1)
    //
	private static Integer mayorRepetidoOld(LinkedList<Integer> numeros) {

		//En esta variable me voy quedando con el más repetido
		Integer repetido=0;
		
		//En esta variable me quedo con la cantidad de repeticiones
		Integer repeticiones=0;
		
		//Por cada número en la lista, recorro la lista y cuento cuantos números son iguales
		for (Integer num : numeros) {
	
			int count=0;
			for (Integer num2 : numeros) {			
				//si el numero es igual cuento una repetición
				if(num==num2)
					count++;
			}
			
			//si las repeticiones son mayores a las que tenía contadas, me lo guardo
			if (count>repeticiones) {
				repeticiones=count;
				repetido=num;
			}
			
		}
			
		//Devuelvo el más repetido
		return repetido;
	}

    // el costo de esta funcion es:
    // en tiempo:  O(n + n log(n))
    // en espacio: O(2n)
    //
    private static Integer mayorRepetido(LinkedList<Integer> numeros) throws Exception {
        // solo si hay datos en el array
        if(numeros.size() > 0) {

            // vamos de LinkedList a Ingeger[] y de ahi a Int[]
            // asi que tenemos O(2n) en uso de espacio de memoria
            //
            int[] numerosA = toPrimitive(numeros.toArray(new Integer[numeros.size()]), -666); // el diablo metio la cola :P

            // the cost of this should be O(n log(n))
            // the documentation about Array.sort states:
            //
            //    http://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html#sort%28int%5B%5D%29
            //
            // 		This algorithm offers O(n log(n)) performance on many data
            //    sets that cause other quicksorts to degrade to quadratic
            //    performance, and is typically faster than traditional
            //    (one-pivot) Quicksort implementations.
            //
            // an interesting explanation in: http://stackoverflow.com/a/15455245
            //
            Arrays.sort(numerosA);

            int numero = numerosA[0];
            int repeticiones = 0;
            int repetido = numero;
            int maxRepeticiones = 0;

            // el costo de esto es O(n)
            //
            for (int i = 1; i < numerosA.length; i++) {
                if(numero == numerosA[i]) {
                    repeticiones++;
                }
                else {
                    if(maxRepeticiones < repeticiones) {
                        repetido = numero;
                        maxRepeticiones = repeticiones;
                    }
                    numero = numerosA[i];
                    repeticiones = 0;
                }
            }
            if(maxRepeticiones < repeticiones) {
                repetido = numero;
                maxRepeticiones = repeticiones;
            }
            return repetido;
        }
        else {
            throw new Exception("Empty list !!!");
        }
    }

    // from org.apache.commons.lang.ArrayUtils
    //
    public static int[] toPrimitive(Integer[] array, int valueForNull) {
        int[] EMPTY_INT_ARRAY = new int[0];
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_INT_ARRAY;
        }
        final int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            Integer b = array[i];
            result[i] = (b == null ? valueForNull : b.intValue());
        }
        return result;
    }
	
}
