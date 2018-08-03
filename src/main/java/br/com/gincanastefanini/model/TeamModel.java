package br.com.gincanastefanini.model;

public class TeamModel {
	
	
	private Integer idTeam;
	private String teamName;
	private MemberModel memberModel;
	
	
	public Integer getIdTeam() {
		return idTeam;
	}
	public void setIdTeam(Integer idTeam) {
		this.idTeam = idTeam;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public MemberModel getMemberModel() {
		return memberModel;
	}
	public void setMemberModel(MemberModel memberModel) {
		this.memberModel = memberModel;
	}
	
	
	

}
