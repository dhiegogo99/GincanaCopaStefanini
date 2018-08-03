package br.com.gincanastefanini.teste;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.gincanastefanini.model.Team;

public class TeamDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void register(Team team) {
//		this.entityManager.persist(team);
		System.out.println(team);
	}

}
