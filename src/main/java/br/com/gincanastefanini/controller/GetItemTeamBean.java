package br.com.gincanastefanini.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.gincanastefanini.dto.TimeDTO;
import br.com.gincanastefanini.model.Product;
import br.com.gincanastefanini.model.ProductTeam;
import br.com.gincanastefanini.model.Team;
/**
 *  Bean de Lista de times
 * @author Dhiego
 *
 */
@Named
@ViewScoped
public class GetItemTeamBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Team team;
	private Product product;
	private Integer QTD;
	private String uniMed;
	private Date dt_inclusao;
	
	@Inject
	private GincanaCopaService gincanaCopaService;

	@PostConstruct
	public void init() {
 		setListProductTeam(this.gincanaCopaService.findAllProductTeam());
	}

	private List<TimeDTO> listProductTeam;

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQTD() {
		return QTD;
	}

	public void setQTD(Integer qTD) {
		QTD = qTD;
	}

	public String getUniMed() {
		return uniMed;
	}

	public void setUniMed(String uniMed) {
		this.uniMed = uniMed;
	}

	public Date getDt_inclusao() {
		return dt_inclusao;
	}

	public void setDt_inclusao(Date dt_inclusao) {
		this.dt_inclusao = dt_inclusao;
	}

	public GincanaCopaService getGincanaCopaService() {
		return gincanaCopaService;
	}

	public void setGincanaCopaService(GincanaCopaService gincanaCopaService) {
		this.gincanaCopaService = gincanaCopaService;
	}

	public List<TimeDTO> getListProductTeam() {

		return listProductTeam;
	}

	public void setListProductTeam(List<TimeDTO> listProductTeam) {
		this.listProductTeam = listProductTeam;
	}



}
