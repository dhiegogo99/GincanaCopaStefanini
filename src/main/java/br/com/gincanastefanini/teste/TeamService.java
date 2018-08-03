package br.com.gincanastefanini.teste;

import javax.inject.Inject;

import br.com.gincanastefanini.model.Team;

public class TeamService {

	@Inject
	private TeamDAO teamDAO;
	
	public void register(Team team) {
		this.teamDAO.register(team);
	}

}
