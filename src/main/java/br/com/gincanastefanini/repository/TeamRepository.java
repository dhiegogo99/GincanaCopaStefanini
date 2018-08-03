package br.com.gincanastefanini.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.gincanastefanini.model.Member;
import br.com.gincanastefanini.model.Team;
import br.com.gincanastefanini.model.TeamModel;
import br.com.gincanastefanini.uteis.Uteis;
import br.com.gincanastefanini.view.GincanaCopaDTO;

public class TeamRepository {

	@Inject
	private Team team;
	
	private EntityManager entityManager;
	
	public void saveNewRegisterTeam(TeamModel dto){
		entityManager = Uteis.JpaEntityManager();
		
		
	}
	
	
	
}
