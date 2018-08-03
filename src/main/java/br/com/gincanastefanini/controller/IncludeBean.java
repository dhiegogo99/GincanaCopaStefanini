package br.com.gincanastefanini.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.gincanastefanini.model.Member;
import br.com.gincanastefanini.model.Team;

@Named
@ViewScoped
public class IncludeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Team> listTeam;
	private List<Member> listMembers;

	private Boolean block;
	private Boolean blockMemberInit;

	@Inject
	private GincanaCopaService gincanaCopaService;

	private Team team;

	private Member member;

	@PostConstruct
	public void init() {
		this.setBlockMemberInit(Boolean.TRUE);
		List<Member> members = this.findTeamWithPlayers();
		setListMembers(members);

	}

	/**
	 * Metodo para adicionar o nome do time
	 * 
	 */
	public void addTeam() {

		boolean existe = this.gincanaCopaService.verificaExisteTime(getTeam());

		if (existe) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Ooopss!!",
					"Este Time já existe, favor verifique e tente novamente."));
		} else {
			getTeam();
			this.setBlock(Boolean.TRUE);
			this.setBlockMemberInit(Boolean.FALSE);
		}
	}

	/**
	 * Metodo para adicionar um novo mebro dentro do time
	 */
	public void addMember() {

		if (getTeam().getMember().size() == 6) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção",
					"Somente será permitido 6 membros por equipe!"));
		} else {
			getTeam().getMember().add(getMember());
			setMember(null);
			this.setBlock(Boolean.TRUE);
		}
	}

	public void clean() {
		getTeam().getMember().clear();
		getTeam().setTeamName(null);
		getMember().setNameMember(null);
		this.setBlock(Boolean.FALSE);
		this.setBlockMemberInit(Boolean.TRUE);
		List<Member> members = this.findTeamWithPlayers();
		setListMembers(members);
	}

	public void removeMember(Member member) {

		getTeam().getMember().remove(member);
	}

	public void saveTeam() {
		if (getTeam().getMember().size() <= 4) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Oopss!!",
					"O time contém menos de 5 integrantes para o cadastro, verifique e tente novamente! "));
		} else {
			this.getGincanaCopaService().saveTeam(this.getTeam());
			this.team = new Team();
			clean();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Concluído!", "O time foi cadastrado com sucesso!!"));
		}
	}

	/**
	 * Transacao de paginas xhtml
	 */
	final static String CAMINHO_CADASTRO_TIME = "cadastrarTime.xhtml?faces-redirect=true";

	final static String CAMINHO_CADASTRO_ITEM = "cadastrarItem.xhtml?faces-redirect=true";

	/**
	 * transacao para pagina de cadastro de time
	 * 
	 * @return
	 */
	public String redirectPageEquipe() {
		return CAMINHO_CADASTRO_TIME;
	}

	/**
	 * Transacao para pagina de Cadstro de ITEM
	 * 
	 * @return
	 */
	public String redirectPageItem() {
		return CAMINHO_CADASTRO_ITEM;
	}

	public GincanaCopaService getGincanaCopaService() {
		return gincanaCopaService;
	}

	public void setGincanaCopaService(GincanaCopaService gincanaCopaService) {
		this.gincanaCopaService = gincanaCopaService;
	}

	public Team getTeam() {
		if (team == null) {
			team = new Team();
		}
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Member getMember() {
		if (member == null) {
			member = new Member();
		}
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Boolean getBlock() {
		return block;
	}

	public void setBlock(Boolean block) {
		this.block = block;
	}

	public Boolean getBlockMemberInit() {
		return blockMemberInit;
	}

	public void setBlockMemberInit(Boolean blockMemberInit) {
		this.blockMemberInit = blockMemberInit;
	}

	private List<Team> findAllTime() {
		return this.gincanaCopaService.findAllTime();
	}

	public List<Team> getListTeam() {
		return listTeam;
	}

	public void setListTeam(List<Team> listTeam) {
		this.listTeam = listTeam;
	}

	public List<Member> getListMembers() {
		return listMembers;
	}

	public void setListMembers(List<Member> listMembers) {
		this.listMembers = listMembers;
	}

	private List<Member> findTeamWithPlayers() {
		return this.gincanaCopaService.findAllTeamAndPlayers();

	}
}
