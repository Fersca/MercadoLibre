import static org.junit.Assert.assertEquals;

import org.junit.Test;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

class ProblemaTests {

    @Test
    public void threeIsRepeatedTheMost() {

		LinkedList<Integer> numeros = new LinkedList<Integer>(Arrays.asList(1,1,1,3,4,3,3,3,4,5,3,1,3)); 

    	Problema prob = new Problema();

    	ArrayList<Integer> i = prob.mayorRepetido(numeros);

    	assert [3] == i;
    }

    @Test
    public void onlyOneElementOnArray() {

		LinkedList<Integer> numeros = new LinkedList<Integer>(Arrays.asList(1)); 

    	Problema prob = new Problema();

    	ArrayList<Integer> i = prob.mayorRepetido(numeros);

    	assert [1] == i;
    }

    @Test
    public void twoDifferentElementsOnArray() {

		LinkedList<Integer> numeros = new LinkedList<Integer>(Arrays.asList(1,2)); 

    	Problema prob = new Problema();

    	ArrayList<Integer> i = prob.mayorRepetido(numeros);

    	assert [1,2] == i;
    }

    @Test
    public void twoEqualElementsOnArray() {

		LinkedList<Integer> numeros = new LinkedList<Integer>(Arrays.asList(1,1)); 

    	Problema prob = new Problema();

    	ArrayList<Integer> i = prob.mayorRepetido(numeros);

    	assert [1] == i;
    }

    @Test
    public void oneIsRepeatedTheMost() {

		LinkedList<Integer> numeros = new LinkedList<Integer>(Arrays.asList(1,1,1,0,99999,1,3,4,3,3,3,4,5,3,1,1,1,3)); 

    	Problema prob = new Problema();

    	ArrayList<Integer> i = prob.mayorRepetido(numeros);

    	assert [1] == i;
    }
}
