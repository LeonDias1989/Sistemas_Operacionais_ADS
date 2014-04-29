package util;

/**
 * 
 * @author Leon Dias
 * 
 */
public class Processo {

	private String name;
	private int tempoDeChegada;
	private int tempoDeDuracao;
	private int finishTime;
	private int prioridade;
	private boolean acabou = false;

	public Processo() {
		// TODO Auto-generated constructor stub
	}

	public Processo(String name, int tempoDeChegada, int tempoDeDuracao, int prioridade) {
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

	/** Retorna o tempo de dura��o do processo */
	public int getTempoDuracao() {
		return tempoDeDuracao;
	}

	public void setTempoDuracao(int time) {
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
		if (prioridade <0) {
			prioridade = 0;
		}
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
		return "Nome: " + this.name + " Tempo de chegada: " + this.tempoDeChegada + " Tempo de Execucao: " + this.tempoDeDuracao + " Prioridade: " + this.prioridade + "\n";
	}

	public boolean isAcabou() {
		return acabou;
	}

	public void setAcabou(boolean acabou) {
		this.acabou = acabou;
	}

	// não alterar esse codigos abaixo.
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Processo other = (Processo) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
