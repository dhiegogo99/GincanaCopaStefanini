package br.com.gincanastefanini.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Entidade de produto
 * 
 * @author eaoliveira5
 *
 */
@Entity
@Table(name = "TB_PRODUCT", schema = "public")
public class Product implements BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8728506685175178846L;

	@Id
	@Column(name = "id_product")
	@SequenceGenerator(sequenceName = "sequencia_produto", name = "SEQUENCIA_PRODUTO", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "SEQUENCIA_PRODUTO", strategy = GenerationType.SEQUENCE)
	private Integer idProduct;

	@Column(name = "product_descr")
	private String productDescr;

	@Column(name = "product_score")
	private double productScore;

	@OneToMany(mappedBy = "product")
	private List<ProductTeam> productTeam;

	@ManyToOne
	@JoinColumn(name = "id_category", nullable = false)
	private Categoria categoria;

	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public String getProductDescr() {
		return productDescr;
	}

	public void setProductDescr(String productDescr) {
		this.productDescr = productDescr;
	}

	public double getProductScore() {
		return productScore;
	}

	public void setProductScore(double productScore) {
		this.productScore = productScore;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<ProductTeam> getProductTeam() {
		if (productTeam == null) {
			productTeam = new ArrayList<>();

		}

		return productTeam;
	}

	public void setProductTeam(List<ProductTeam> productTeam) {
		this.productTeam = productTeam;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProduct == null) ? 0 : idProduct.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (idProduct == null) {
			if (other.idProduct != null)
				return false;
		} else if (!idProduct.equals(other.idProduct))
			return false;
		return true;
	}

	@Override
	public Integer getId() {

		return this.idProduct;
	}

}
