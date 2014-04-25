package util;

/**
 * 
 * @author Leon Dias
 * 
 */
public class Processo implements Comparable<Processo> {

	private String name;
	private int tempoDeChegada;
	private int tempoDeDuracao;
	private int finishTime;
	private int prioridade;

	public Processo() {
		// TODO Auto-generated constructor stub
	}

	public Processo(String name, int tempoDeChegada, int tempoDeDuracao,
			int prioridade) {
		super();
		this.name = name;
		this.tempoDeChegada = tempoDeChegada;
		this.tempoDeDuracao = tempoDeDuracao;
		this.prioridade = prioridade;
		this.finishTime = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/** Retorna o tempo de duração do processo */
	public int getTime() {
		return tempoDeDuracao;
	}

	public void setTime(int time) {
		this.tempoDeDuracao = time;
	}

	/** Retorna o tempo final do processo */
	public int getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(int finishTime) {
		this.finishTime = finishTime;
	}

	/** Retorna a prioridade do processo */
	public int getPrioridade() {
		return prioridade;
	}

	/** Use for Robin Round */
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	/** Retorna o tempo em que o processo chegou para ser executado */
	public int getTempoDeChegada() {
		return tempoDeChegada;
	}

	/** Use for Robin Round ? */
	public void setTempoDeChegada(int tempoDeChegada) {
		this.tempoDeChegada = tempoDeChegada;
	}

	@Override
	public String toString() {
		return "Nome: " + this.name + " Tempo de chegada: "
				+ this.tempoDeChegada + " Tempo de Execução: "
				+ this.tempoDeDuracao + " Prioridade: " + this.prioridade
				+ "\n";
	}

	@Override
	public int compareTo(Processo o) {

		if (this.tempoDeChegada > o.tempoDeChegada)

			return +1;

		else if (this.tempoDeChegada < o.tempoDeChegada)

			return -1;

		else
			return 0;
	}

}
