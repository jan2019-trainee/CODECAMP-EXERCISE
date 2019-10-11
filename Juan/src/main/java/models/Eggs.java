package models;

public class Eggs {
	
	private int eggForToday = 0;
	private int remainingEgg = 0;
	
	public Eggs(){
		eggForToday = 0;
		remainingEgg = 0;
	}
	
	public int getEggForToday() {
		return eggForToday;
	}
	
	public void setEggForToday(int eggForToday) {
		this.eggForToday = eggForToday;
	}
		
	public int getRemainingEgg() {
		return remainingEgg;
	}
	
	public void setRemainingEgg(int remainingEgg) {
		this.remainingEgg = remainingEgg;
	}
	
	public void takeEgg(int requiredEgg) {
		this.eggForToday -= requiredEgg;
    }
	
}
