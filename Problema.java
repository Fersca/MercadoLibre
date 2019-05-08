import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Problema {
	
	public static void main(String[] args) {

			//Creo la lista de números
		final List<Integer> integers = Arrays.asList(1, 1, 1, 3, 4, 3, 3, 3, 4, 5, 3, 1, 3);
		LinkedList<Integer> numeros = new LinkedList<Integer>(integers);

		//Busco el más repetido
		Integer result = mayorRepetido(numeros);

		System.out.println("Mayor Repetido: "+ result);
		System.out.println("Intenta esto: "+ mostFreqent(integers));
		System.out.println("O esto: "+ mostFreqent2(integers));

	}

	public static Integer mostFreqent(List<Integer> integers) {
		return integers.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().max(Comparator.comparing(Entry::getValue)).get().getKey();
	}

	public static Integer mostFreqent2(List<Integer> givenArray) {
		Integer maxCount = -1;
		Integer maxItem = null;

		Map<Integer, Integer> map = new HashMap<>();
		for (Integer e : givenArray) {
			final Integer compute = map.compute(e, (k, v) -> v == null ? 1 : v + 1);
			if (compute > maxCount) {
				maxCount = compute;
				maxItem = e;
			}
		}
		return maxItem;
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
