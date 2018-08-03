package br.com.gincanastefanini.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import br.com.gincanastefanini.dto.TimeDTO;
import br.com.gincanastefanini.model.Categoria;
import br.com.gincanastefanini.model.GincanaCopaDAO;
import br.com.gincanastefanini.model.Member;
import br.com.gincanastefanini.model.Product;
import br.com.gincanastefanini.model.ProductTeam;
import br.com.gincanastefanini.model.Team;

@RequestScoped
public class GincanaCopaService {

	@Inject
	private GincanaCopaDAO gincanaCopaDAO;

	public List<Member> findAllTeamAndPlayers() {

		return this.gincanaCopaDAO.findAllTeamAndPlayers();
	}

	public List<Team> findAllTime() {

		return this.gincanaCopaDAO.findAllTimes();
	}

	@Transactional(value = TxType.REQUIRES_NEW)
	public void saveTeam(Team team) {
		try {

			this.gincanaCopaDAO.registerTeam(team);

			for (Member member : team.getMember()) {
				member.setTeam(team);
				this.gincanaCopaDAO.insertMembro(member);
			}

		} catch (EntityNotFoundException ef) {
			ef.printStackTrace();
		}
	}

	@Transactional(value = TxType.REQUIRES_NEW)
	public void saveListProductTeam(List<ProductTeam> listProductTeam) {
		this.gincanaCopaDAO.saveListProductTeam(listProductTeam);
	}

	public boolean verificaExisteTime(Team team) {
		return this.gincanaCopaDAO.verificaExisteTime(team);
	}

	public List<TimeDTO> findAllProductTeam() {

		return this.gincanaCopaDAO.findAllProductTeam();
	}

	public List<TimeDTO> getRanking() {

		return this.gincanaCopaDAO.getRanking();
	}

	public List<Team> findAllTeam() {
		return this.gincanaCopaDAO.listAllTeam();
	}

	public List<Categoria> findAllCategory() {
		return this.gincanaCopaDAO.listAllCategory();
	}

	public List<Product> buscarItem(Integer idCategory) {

		return this.gincanaCopaDAO.buscarItem(idCategory);
	}

}
