import java.util.Arrays;
import java.util.LinkedList;

public class Problema {
	
	public static void main(String[] args) {

		//Creo la lista de números
		LinkedList<Integer> numeros = new LinkedList<Integer>(Arrays.asList(1,1,1,3,4,3,3,3,4,5,3,1,3)); 
				
		//Busco el más repetido
		Integer result = mayorRepetido(numeros);
		
		System.out.println("Mayor Repetido: "+ result);
		
	}

	private static Integer mayorRepetido(LinkedList<Integer> numeros) {

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
	
}
