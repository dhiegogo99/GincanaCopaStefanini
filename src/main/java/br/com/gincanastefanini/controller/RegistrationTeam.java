package br.com.gincanastefanini.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.gincanastefanini.model.Team;
import br.com.gincanastefanini.model.TeamModel;
import br.com.gincanastefanini.repository.TeamRepository;
import br.com.gincanastefanini.uteis.Uteis;


@Named(value="cadastrarTeamController")
@RequestScoped
public class RegistrationTeam {

	@Inject
	private TeamModel teamModel;
	
	@Inject
	private TeamRepository teamRepository;
	
	public TeamModel getTeamModel() {
		return teamModel;
	}
	public void setTeamModel(TeamModel teamModel) {
		this.teamModel = teamModel;
	}
	
	public void RegistrationTeam(){
	
		
	}
	
	
	
}
