package procedure_order;

import java.util.LinkedList;

public class Test {
	
	public static void main(String[] args) {

		LinkedList<String> processos = new LinkedList<>();
		
		processos.add("A");
		processos.add("B");
		processos.add("C");
		processos.add("D");
		processos.add("E");
		
		System.out.println(processos.toString());
		System.out.println(processos.pop());
		System.out.println(processos.toString());

	}

}
