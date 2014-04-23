package util;

public class Processo {

	private String name;
	private int tempoDeChegada;
	private int tempoDeDuracao;
	private int finishTime;
	private int prioridade;

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

	public int getTime() {
		return tempoDeDuracao;
	}

	public void setTime(int time) {
		this.tempoDeDuracao = time;
	}

	public int getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(int finishTime) {
		this.finishTime = finishTime;
	}

	public int getPrioridade() {
		return prioridade;
	}

	/** Use for Robin Round */
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public int getTempoDeChegada() {
		return tempoDeChegada;
	}

	/** Use for Robin Round ? */
	public void setTempoDeChegada(int tempoDeChegada) {
		this.tempoDeChegada = tempoDeChegada;
	}

	@Override
	public String toString() {
		return "Name: " + this.name + " Time execute: " + this.tempoDeDuracao
				+ "\nTime Finish: " + this.finishTime;
	}

}
