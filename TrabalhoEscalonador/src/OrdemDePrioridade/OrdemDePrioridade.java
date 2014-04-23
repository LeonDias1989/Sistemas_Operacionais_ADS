package OrdemDePrioridade;

import java.util.LinkedList;

import util.Processo;

public class OrdemDePrioridade {

	private LinkedList<Processo> listProcess = new LinkedList<>();

	public LinkedList<Processo> getProcessos() {
		return listProcess;
	}

	public void addProcess(Processo p) {

		listProcess.add(p);
	}

	public void removeProcess() {

		listProcess.pop();
	}

	@Override
	public String toString() {

		String x = "";

		for (Processo p : listProcess) {

			x += "Nome: " + p.getName() + " Tempo de Dura��o: " + p.getTime()
					+ " Prioridade: " + p.getPrioridade() + "\n";
		}

		return x;
	}

}
