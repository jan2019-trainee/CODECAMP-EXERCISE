package Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Passenger {
	
	@Id
	@Column(name="passenger_id")
	private int passenger_id;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	public Passenger(int passenger_id, String first_name, String last_name) {
		super();
		this.passenger_id = passenger_id;
		this.first_name = first_name;
		this.last_name = last_name;
	}
	
	public Passenger() {
		
	}

	public int getPassenger_id() {
		return passenger_id;
	}
	public void setPassenger_id(int passenger_id) {
		this.passenger_id = passenger_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

}
