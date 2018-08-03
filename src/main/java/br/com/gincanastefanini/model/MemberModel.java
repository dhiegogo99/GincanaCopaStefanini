package br.com.gincanastefanini.model;

public class MemberModel {
	
	private Integer idMember;
	private String nameMember;
	private TeamModel teamModel;
	
	public Integer getIdMember() {
		return idMember;
	}
	public void setIdMember(Integer idMember) {
		this.idMember = idMember;
	}
	public String getNameMember() {
		return nameMember;
	}
	public void setNameMember(String nameMember) {
		this.nameMember = nameMember;
	}
	
	public TeamModel getTeamModel() {
		return teamModel;
	}
	public void setTeamModel(TeamModel teamModel) {
		this.teamModel = teamModel;
	}
	
	
	

}
