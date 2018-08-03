package br.com.gincanastefanini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CATEGORY", schema = "public")
public class Categoria implements BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6922813639257741941L;

	@Id
	@Column(name = "id_category")
	@SequenceGenerator(sequenceName = "sequencia_categoria", name = "SEQUENCIA_CATEGORIA", initialValue = 1)
	@GeneratedValue(generator = "SEQUENCIA_CATEGORIA", strategy = GenerationType.SEQUENCE)
	private Integer idCategory;

	@Column(name = "desc_category")
	private String descCategory;
	
	public Integer getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}

	public String getDescCategory() {
		return descCategory;
	}

	public void setDescCategory(String descCategory) {
		this.descCategory = descCategory;
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
