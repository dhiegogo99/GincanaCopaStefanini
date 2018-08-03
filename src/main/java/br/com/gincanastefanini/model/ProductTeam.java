package br.com.gincanastefanini.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Entidade para a pontua��o do time de acordo com o produto
 * 
 * @author eaoliveira5
 *
 */
@Entity
@Table(name = "TB_PRODUCT_TEAM", schema = "public")
public class ProductTeam implements BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3343229073607699335L;

	@Id
	@Column(name = "id_product_team")
	@SequenceGenerator(sequenceName = "sequence_product_team", name = "SEQUENCE_PRODUCT_TEAM", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "SEQUENCE_PRODUCT_TEAM", strategy = GenerationType.SEQUENCE)
	private Integer idProductTeam;

	@ManyToOne
	@JoinColumn(name = "id_team", nullable = false)
	private Team team;

	@ManyToOne
	@JoinColumn(name = "id_product", nullable = false)
	private Product product;

	@Column(name = "qtd_item")
	private Double qtdItem;

	@Column(name = "uni_med")
	private String uniMed;

	@Column(name = "dt_conclusion")
	private Date dtConclusion;

	public Integer getIdProductTeam() {
		return idProductTeam;
	}

	public void setIdProductTeam(Integer idTeamProduct) {
		this.idProductTeam = idTeamProduct;
	}

	public Double getQtdItem() {
		return qtdItem;
	}

	public void setQtdItem(Double qtdItem) {
		this.qtdItem = qtdItem;
	}

	public String getUniMed() {
		return uniMed;
	}

	public void setUniMed(String uniMed) {
		this.uniMed = uniMed;
	}

	public Date getDtConclusion() {
		return dtConclusion;
	}

	public void setDtConclusion(Date dtConclusion) {
		this.dtConclusion = dtConclusion;
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

	@Override
	public Integer getId() {
		return null;
	}

}
