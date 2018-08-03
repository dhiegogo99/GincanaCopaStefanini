package br.com.gincanastefanini.view;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import org.primefaces.model.LazyDataModel;

/**
 *
 * 
 * @author eaoliveira5
 *
 */
public class GincanaCopaDTO {

	// Team
	private Integer idTeam;
	private String teamName;
	
	// Member
	private Integer idMember;
	private String memberName;
	private Integer teamFK;

	//Item
	private Integer idProduct;
	private String productCategory;
	private String productDescr;
	private double productScore;
	
	//Product Team
	private Integer id;
	private Double qtdItem;
	private Double uniMed;
	private Date dtConclusion;
	
	
	
	// Get and Set Team

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

	// Get and Set Member Team
	public Integer getIdMember() {
		return idMember;
	}

	public void setIdMember(Integer idMember) {
		this.idMember = idMember;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Integer getTeamFK() {
		return teamFK;
	}

	public void setTeamFK(Integer teamFK) {
		this.teamFK = teamFK;
	}

	
	
	
}
