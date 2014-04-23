package OrdemDePrioridade;

import util.Processo;

public class Test {

	public static void main(String[] args) {

		// LinkedList<String> processos = new LinkedList<>();
		//
		// processos.add("A");
		// processos.add("B");
		// processos.add("C");
		// processos.add("D");
		// processos.add("E");
		//
		// System.out.println(processos.toString());
		// System.out.println(processos.pop());
		// System.out.println(processos.toString());

		OrdemDePrioridade procedureOrder = new OrdemDePrioridade();

		Processo a = new Processo("A", 0, 4, 4);
		Processo b = new Processo("B", 0, 2, 5);
		Processo c = new Processo("C", 1, 1, 6);
		Processo d = new Processo("D", 3, 3, 1);

		procedureOrder.addProcess(a);
		procedureOrder.addProcess(b);
		procedureOrder.addProcess(c);
		procedureOrder.addProcess(d);

		System.out.println(procedureOrder.toString());

	}

}
