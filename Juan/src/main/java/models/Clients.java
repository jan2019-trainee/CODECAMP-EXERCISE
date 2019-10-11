package models;

public class Clients{
	
	private String name;
	private int RequiredEgg;
	private int dueEggs;
	private int totalEggsRequired;
	private int priorNum = 0;
	
	public Clients(String name, int RequiredEgg) {
		this.name = name;
		this.RequiredEgg = RequiredEgg;
		this.totalEggsRequired = RequiredEgg;
	}
	
	public String getClientName() {
		return name;
	}
	public void setClientName(String name) {
		this.name = name;
	}
	public int getRequriedEgg() {
		return RequiredEgg;
	}
	public void setRequriedEgg(int RequiredEgg) {
		this.RequiredEgg = RequiredEgg;
	}

	public int getDueEggs() {
		return dueEggs;
	}

	public void setDueEggs(int dueEggs) {
		this.dueEggs = dueEggs;
	}
	
	public void setPriorNum(int priorNum) {
		this.priorNum = priorNum;
	}
	
	public int getPriorNum() {
		return priorNum;
	}
	
	public void clearDueEggs() {
		this.dueEggs = 0;	
	}

	public int getTotalEggsRequired() {
		return totalEggsRequired;
	}

	public void setTotalEggsRequired(int totalEggsRequired) {
		this.totalEggsRequired = totalEggsRequired;
	}

}
