import java.util.Arrays;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Problema {

	public static void main(String[] args) {

		//Creo la lista de números
		LinkedList<Integer> numeros = new LinkedList<Integer>(Arrays.asList(1,1,1,3,4,3,3,3,4,5,3,1,3)); 

		//Busco el más repetido
		ArrayList<Integer> result = mayorRepetido(numeros);

		System.out.println("Mayor Repetido: "+ result);

	}

	public static ArrayList<Integer> mayorRepetido(LinkedList<Integer> numeros) {

		//En esta variable me voy quedando con el más repetido
		ArrayList<Integer> repetido = new ArrayList<Integer>();

		//En esta variable me quedo con la cantidad de repeticiones
		Integer repeticiones=0;
		Map map = new HashMap();
		//Por cada número en la lista, recorro la lista y cuento cuantos números son iguales
		for (Integer num : numeros) {

			int count=0;
	
			if(map.containsKey(num))
			{
				count = (Integer) map.get(num) + 1;

				map.put(num, count);
						
			}
			else
			{
				map.put(num, 1);
				count++;
			}
			
			if (count>=repeticiones) {
				//Si en vez de compartir la cantidad de repeticiones, el nuevo num tiene más
				//Entonces vacío todos los valores anteriores
				if(count>repeticiones)
						repetido.clear();

				repeticiones=count;
				
				//Si ya existe, no lo agrega
				if(!repetido.contains(num))
					repetido.add(num);
			}	
		}

		//Devuelvo los más repetidos
		return repetido;
	}

}