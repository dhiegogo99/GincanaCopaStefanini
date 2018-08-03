package br.com.gincanastefanini.teste;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.gincanastefanini.model.Team;

@Model
public class TeamBean {

	@Inject
	private TeamService teamService;

	private Team team = new Team();

	public void save() {
		this.teamService.register(this.team);
		this.team = new Team();
		// return "cadastrarEquipe?faces-redirect=true";
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}
