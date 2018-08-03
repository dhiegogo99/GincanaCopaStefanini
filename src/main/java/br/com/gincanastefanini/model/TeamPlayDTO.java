package br.com.gincanastefanini.model;

import java.util.List;

public class TeamPlayDTO {
	
	private Team team;
	private List<Member> members;
	
	
	public TeamPlayDTO(Team team, List<Member> members) {
		super();
		this.team = team;
		this.members = members;
	}
	
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public List<Member> getMembers() {
		return members;
	}
	public void setMembers(List<Member> members) {
		this.members = members;
	}
	
}
