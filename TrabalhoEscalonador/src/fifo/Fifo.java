package fifo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author jandrei masiero
 *
 */
public class Fifo {
	public static void main(String[] args) {
		Queue<Integer> lista = new LinkedList<Integer>();
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		lista.add(5);
		
		Integer valor = lista.peek();
		System.out.println(valor);
		lista.remove(valor);
		
		valor = lista.peek();
		System.out.println(valor);
		lista.remove(valor);
		
		valor = lista.peek();
		System.out.println(valor);
		lista.remove(valor);
		
		valor = lista.peek();
		System.out.println(valor);
		lista.remove(valor);
		
	}
}
