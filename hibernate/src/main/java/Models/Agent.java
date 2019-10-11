package Models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Agent {
	@Id
	private int agent_id;
	private String name;
	
	
	public Agent() {
	}

	public Agent(int agent_id, String name) {
		super();
		this.agent_id = agent_id;
		this.name = name;
	}
	
	public int getAgent_id() {
		return agent_id;
	}
	public void setAgent_id(int agent_id) {
		this.agent_id = agent_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
