package com.mercadolibre.problemajava;
import java.util.LinkedList;

public class ContadorOriginal implements ContadorDeRepeticiones {

	@Override
	public Integer mayorRepetido(LinkedList<Integer> numeros) {
	
		//En esta variable me voy quedando con el m‡s repetido
		Integer repetido=0;
	
		//En esta variable me quedo con la cantidad de repeticiones
		Integer repeticiones=0;
	
		//Por cada nœmero en la lista, recorro la lista y cuento cuantos nœmeros son iguales
		for (Integer num : numeros) {
	
			int count=0;
			for (Integer num2 : numeros) {			
				//si el numero es igual cuento una repetici—n
				if(num==num2)
					count++;
			}
	
			//si las repeticiones son mayores a las que ten’a contadas, me lo guardo
			if (count>repeticiones) {
				repeticiones=count;
				repetido=num;
			}
	
		}
	
		//Devuelvo el m‡s repetido
		return repetido;
	}

}
