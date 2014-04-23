package util;

public class Process {

	private String name;
	private int time;
	private int finishTime;
	private int prioridade;

	public Process() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
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
	
	/*user for Robin Round **/
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	@Override
	public String toString() {
		return "Name: " + this.name + " Time execute: " + this.time
				+ "Time Finish: " + this.finishTime;
	}

}
