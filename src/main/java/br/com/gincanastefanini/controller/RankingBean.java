package br.com.gincanastefanini.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.gincanastefanini.dto.TimeDTO;
import br.com.gincanastefanini.model.Product;
import br.com.gincanastefanini.model.Team;
@Model
public class RankingBean {

	private static final long serialVersionUID = 1L;
	private Team team;
	private Product product;
	private Integer QTD;
	private String uniMed;
	private Date dt_inclusao;
	private Double productScore;
	private List<TimeDTO> listProductTeam;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Inject
	private GincanaCopaService gincanaCopaService;

	@PostConstruct
	public void init() {
		
		setListProductTeam(this.gincanaCopaService.getRanking());
	}

	

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

	public Double getProductScore() {
		return productScore;
	}

	public void setProductScore(Double productScore) {
		this.productScore = productScore;
	}

}
