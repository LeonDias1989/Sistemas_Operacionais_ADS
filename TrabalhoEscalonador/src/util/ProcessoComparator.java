package util;

import java.util.Comparator;

public class ProcessoComparator implements Comparator<Processo> {

	private ProcessoTipoOrdenacao tipoOrdenacao = null;
	boolean crescente = true;

	public ProcessoComparator(ProcessoTipoOrdenacao tipoOrdenacao) {
		this(tipoOrdenacao,true);
	}
	public ProcessoComparator(ProcessoTipoOrdenacao tipoOrdenacao,boolean crescente) {
		this.tipoOrdenacao = tipoOrdenacao;
		this.crescente = crescente;
	}

	@Override
	public int compare(Processo o1, Processo o2) {
		switch (tipoOrdenacao) {
		case TEMPO_DURACAO:
			return (crescente ? 1 : -1) * Integer.valueOf(o1.getTempoDuracao()).compareTo(o2.getTempoDuracao());
		case TEMPO_CHEGADA:
			return (crescente ? 1 : -1) * Integer.valueOf(o1.getTempoDeChegada()).compareTo(o2.getTempoDeChegada());
		case PRIORIDADE:
			return (crescente ? 1 : -1) * Integer.valueOf(o1.getPrioridade()).compareTo(o2.getPrioridade());
		default:
			return 0;
		}
	}

}
