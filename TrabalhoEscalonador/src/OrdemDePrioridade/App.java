package OrdemDePrioridade;

import util.Processo;

public class App {

	public static void main(String[] args) {

		Processo p0 = new Processo("A", 0, 4, 1);
		Processo p1 = new Processo("B", 1, 1, 4);
		Processo p2 = new Processo("C", 0, 2, 5);
		Processo p3 = new Processo("D", 2, 3, 3);
		Processo p4 = new Processo("E", 0, 2, 1);

		Prioridade filaProcessos = new Prioridade();

		filaProcessos.adicionarProcesso(p0);
		filaProcessos.adicionarProcesso(p1);
		filaProcessos.adicionarProcesso(p2);
		filaProcessos.adicionarProcesso(p3);
		filaProcessos.adicionarProcesso(p4);

		 System.out.println(filaProcessos.getLisaDeProcessos().toString());

	}

}
