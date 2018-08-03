package br.com.gincanastefanini.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.gincanastefanini.model.Categoria;
import br.com.gincanastefanini.model.Product;
import br.com.gincanastefanini.model.ProductTeam;
import br.com.gincanastefanini.model.Team;

@Named
@ViewScoped
public class IncludeItemBean implements Serializable {

	private static String KILO = "KILO";
	private static final long serialVersionUID = 1L;

	@Inject
	private GincanaCopaService gincanaCopaService;

	private List<Team> listaTime;
	private List<Categoria> listCategory;
	private List<Product> listProduct;

	private Product product;
	private String item;

	private Team team;

	private Double unitMedida;
	private Integer pontos;

	private String categoria;

	private Integer idCategory;
	private String unidadeMedida;

	private Product produtoSelecionado;
	private ProductTeam productTeam;

	private List<ProductTeam> listProductTeam;

	private String mascara;

	@PostConstruct
	public void init() {
		listaTime = gincanaCopaService.findAllTeam();
		listCategory = gincanaCopaService.findAllCategory();
	}

	public void addItem() {

		getProductTeam().setProduct(produtoSelecionado);
		getProductTeam().setTeam(team);
		getProductTeam().setDtConclusion(new Date());
		getListProductTeam().add(getProductTeam());

		setProductTeam(null);

	}

	public void saveProductTeam() {

		this.gincanaCopaService.saveListProductTeam(listProductTeam);
		this.productTeam = new ProductTeam();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Concluído!",
				"O produto foi inserido com sucesso ao time!!"));
		clearField();

	}

	public void clearField() {
		getListProductTeam().clear();
	}

	public void removeProduct(ProductTeam productTeam) {

		getListProductTeam().remove(productTeam);

	}

	public Product getProduct() {
		if (product == null) {
			product = new Product();
		}

		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void categoriaItemType() {
		if (categoria.equals(KILO)) {
			this.setMascara("999.99Kg");
		} else {
			this.setMascara("999,999 ML");
		}
	}

	public void selectItem() {

		this.setListProduct(gincanaCopaService.buscarItem(idCategory));
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public List<Team> getListaTime() {
		return listaTime;
	}

	public void setListaTime(List<Team> listaTime) {
		this.listaTime = listaTime;
	}

	public List<Categoria> getListCategory() {
		return listCategory;
	}

	public void setListCategory(List<Categoria> listCategory) {
		this.listCategory = listCategory;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Double getUnitMedida() {
		return unitMedida;
	}

	public void setUnitMedida(Double unitMedida) {
		this.unitMedida = unitMedida;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	public String getMascara() {
		return mascara;
	}

	public void setMascara(String mascara) {
		this.mascara = mascara;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}

	public Integer getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}

	public Product getProdutoSelecionado() {
		if (produtoSelecionado == null) {
			produtoSelecionado = new Product();

		}

		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Product produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public ProductTeam getProductTeam() {
		if (productTeam == null) {
			productTeam = new ProductTeam();
		}
		return productTeam;
	}

	public void setProductTeam(ProductTeam productTeam) {
		this.productTeam = productTeam;
	}

	public List<ProductTeam> getListProductTeam() {
		if (listProductTeam == null) {
			listProductTeam = new ArrayList<>();

		}

		return listProductTeam;
	}

	public void setListProductTeam(List<ProductTeam> listProductTeam) {
		this.listProductTeam = listProductTeam;
	}
}
