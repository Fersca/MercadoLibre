package com.mercadolibre.problemajava;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Esta strategy resuelve el problema a partir de la utilizaci—n de un map, solo necesita 1 pasada por el array. 
 * 
 * @author afalvella
 *
 */
public class ContadorQueRecorreUnaVez implements ContadorDeRepeticiones {

	@Override
	public Integer mayorRepetido(LinkedList<Integer> numeros) {
		//En este map la clave es cada item del array, el value la cantidad de repeticiones
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		//En esta variable me voy quedando con el m‡s repetido
		Integer repetido=0;

		//En esta variable me quedo con la cantidad de repeticiones
		Integer repeticiones=0;

		for(Integer numero : numeros) {
			Integer value = map.get(numero);
			if (value == null) value = 0; 
			map.put(numero, ++value);

			if(value > repeticiones) {
				repetido = numero; 
				repeticiones = value; 
			}
		}
		return repetido;
	}

}
