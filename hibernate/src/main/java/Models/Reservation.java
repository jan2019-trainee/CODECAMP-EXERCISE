package Models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Reservation {
	@Id
	private int reservation_code;
	
	@JoinColumn(name = "flight_no")
    @OneToOne(cascade = CascadeType.ALL)
	private Flight flight_no;
	
	@JoinColumn(name = "passenger_id")
    @OneToOne(cascade = CascadeType.ALL)
	private Passenger passenger_id;
	
	
	private int seat_no;
	
	@JoinColumn(name = "agent_id")
    @OneToOne(cascade = CascadeType.ALL)
	private Agent agent_id;

	public Reservation() {
	}

	public Reservation(int reservation_code, Flight flight_no, Passenger passenger_id, int seat_no, Agent agent_id) {
		super();
		this.reservation_code = reservation_code;
		this.flight_no = flight_no;
		this.passenger_id = passenger_id;
		this.seat_no = seat_no;
		this.agent_id = agent_id;
	}

	public int getReservation_code() {
		return reservation_code;
	}

	public void setReservation_code(int reservation_code) {
		this.reservation_code = reservation_code;
	}

	public Flight getFlight_no() {
		return flight_no;
	}

	public void setFlight_no(Flight flight_no) {
		this.flight_no = flight_no;
	}

	public Passenger getPassenger_id() {
		return passenger_id;
	}

	public void setPassenger_id(Passenger passenger_id) {
		this.passenger_id = passenger_id;
	}

	public int getSeat_no() {
		return seat_no;
	}

	public void setSeat_no(int seat_no) {
		this.seat_no = seat_no;
	}

	public Agent getAgent_id() {
		return agent_id;
	}

	public void setAgent_id(Agent agent_id) {
		this.agent_id = agent_id;
	}
	
}
