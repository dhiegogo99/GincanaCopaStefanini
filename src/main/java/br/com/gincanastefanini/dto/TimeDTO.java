package br.com.gincanastefanini.dto;

import java.io.Serializable;
import java.util.Date;

public class TimeDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nomeTime;
	private String categoriaItem;
	private String nomeItem;
	private Double qtdUnidade;
	private Double pontos;
	private Date dtConclusion;
	private Double productScore;
	private String uniMed;
	private String QTD_UniMed;
	
	private Double Total;
	
	public String getQTD_UniMed() {
		return QTD_UniMed;
	}

	public void setQTD_UniMed(String qTD_UniMed) {
		QTD_UniMed = qTD_UniMed;
	}

	public String getUniMed() {
		return uniMed;
	}

	public void setUniMed(String uniMed) {
		this.uniMed = uniMed;
	}

	public TimeDTO(String nomeTime, String categoriaItem, String nomeItem, Double qtdUnidade, Double pontos,
			Date dtConclusion, Double productScore, String uniMed) {
		this.nomeTime = nomeTime;
		this.categoriaItem = categoriaItem;
		this.nomeItem = nomeItem;
		this.qtdUnidade = qtdUnidade;
		this.pontos = pontos;
		this.dtConclusion = dtConclusion;
		this.productScore = productScore;
		this.uniMed = uniMed;
		this.QTD_UniMed = ((qtdUnidade.toString()).concat(" ").concat(uniMed));
	}

	public TimeDTO(String nomeTime, String categoriaItem, String nomeItem, Double qtdUnidade, Double pontos) {
		this.nomeTime = nomeTime;
		this.categoriaItem = categoriaItem;
		this.nomeItem = nomeItem;
		this.qtdUnidade = qtdUnidade;
		this.pontos = pontos;
		}
	public Date getDtConclusion() {
		return dtConclusion;
	}

	public void setDtConclusion(Date dtConclusion) {
		this.dtConclusion = dtConclusion;
	}

	public Double getProductScore() {
		return productScore;
	}

	public void setProductScore(Double productScore) {
		this.productScore = productScore;
	}

	public String getNomeTime() {
		return nomeTime;
	}

	public void setNomeTime(String nomeTime) {
		this.nomeTime = nomeTime;
	}

	public String getCategoriaItem() {
		return categoriaItem;
	}

	public void setCategoriaItem(String categoriaItem) {
		this.categoriaItem = categoriaItem;
	}

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public Double getQtdUnidade() {
		return qtdUnidade;
	}

	public void setQtdUnidade(Double qtdUnidade) {
		this.qtdUnidade = qtdUnidade;
	}

	public Double getPontos() {
		return pontos;
	}

	public void setPontos(Double pontos) {
		this.pontos = pontos;
	}

}
