package OrdemDePrioridade;

import java.util.LinkedList;
import util.Processo;

/**
 * 
 * @author Leon Dias
 * 
 */
public class OrdemDePrioridade {

	private LinkedList<Processo> listProcess = new LinkedList<>();

	public LinkedList<Processo> getLisaDeProcessos() {
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

			x += "Nome: " + p.getName() + " Tempo de Duração: " + p.getTime()
					+ " Prioridade: " + p.getPrioridade() + "\n";
		}
		return x;
	}

}
