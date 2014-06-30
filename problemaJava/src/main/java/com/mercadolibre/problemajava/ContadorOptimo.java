package com.mercadolibre.problemajava;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import com.mercadolibre.problemajava.*;
/**
 * Esta clase resuelve el problema sin necesidad de realizar una pasada completa por todos los items del array.
 * Debugeando se puede ver que en el anteœltimo lugar del array (en el caso de ejemplo) ya se da cuenta cu‡l 
 * va a ser el m‡s repetido.  
 * 
 * @author afalvella
 *
 */
public class ContadorOptimo implements ContadorDeRepeticiones {

	@Override
	public Integer mayorRepetido(LinkedList<Integer> numeros) {
		Integer tama–oDeLaLista = numeros.size();
		
		//En este map la clave es cada item del array, el value la cantidad de repeticiones
		Map<Integer, Integer> repeticionesPorNumero = new HashMap<Integer, Integer>();

		//En esta variable me voy quedando con el m‡s repetido
		Integer repetido=0;

		//En esta variable me quedo con la cantidad de repeticiones
		Integer repeticiones=0;
		
		//En este indice guardo la posici—n dentro de la lista
		Integer index = 0; 
		
		//En esta variable guardo el segundo m‡s repetido (las repeticiones, no el nœmero)
		Integer segundoLugarRepeticiones=0; 
		
		for(Integer numero : numeros) {
			index++;
			
			Integer cantidadDeRepeticionesDelNumeroActual = seteoLaCantidadDeRepeticionesDelNumeroActual(repeticionesPorNumero, numero);
			
			if(cantidadDeRepeticionesDelNumeroActual > repeticiones) {
				repetido = numero;
				segundoLugarRepeticiones = repeticiones; 
				repeticiones = cantidadDeRepeticionesDelNumeroActual; 
			}
			
			if(puedoTerminarDeIterar(tama–oDeLaLista,repeticiones, index, segundoLugarRepeticiones))
				return repetido; 
			
		}
		return repetido; 
	}

	private Integer seteoLaCantidadDeRepeticionesDelNumeroActual(Map<Integer, Integer> repeticionesPorNumero, Integer numero) {
		Integer value = repeticionesPorNumero.get(numero);
		if (value == null) value = 0; 
		repeticionesPorNumero.put(numero, ++value);
		return value;
	}

	private boolean puedoTerminarDeIterar(Integer listSize, Integer repeticiones, Integer index, Integer segundoLugarRepeticiones) {
		int cuantosFaltanParaTerminar = listSize - index;
		boolean estoyMasRepetidoQueCualquieraNuevoQuePuedaAparecer = repeticiones >= cuantosFaltanParaTerminar;
		boolean elSegundoMasRepetidoTampocoMePuedeAlcanzar = repeticiones >= (segundoLugarRepeticiones + cuantosFaltanParaTerminar);
		return estoyMasRepetidoQueCualquieraNuevoQuePuedaAparecer && elSegundoMasRepetidoTampocoMePuedeAlcanzar;
	}

}
