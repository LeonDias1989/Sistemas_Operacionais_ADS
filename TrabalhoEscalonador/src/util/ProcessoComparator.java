
package util;

import java.util.Comparator;

public class ProcessoComparator implements Comparator<Processo> {

	@Override
	public int compare(Processo o1, Processo o2) {
		return Integer.valueOf(o1.getTime()).compareTo(o2.getTime());
	}

}
