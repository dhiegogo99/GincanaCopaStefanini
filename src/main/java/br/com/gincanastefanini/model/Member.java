package br.com.gincanastefanini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_MEMBER",schema = "public")
public class Member implements BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6222592466869433479L;

	@Id
	@SequenceGenerator(sequenceName="sequence_member", name="SEQUENCIA_MEMBRO", initialValue= 1)
	@GeneratedValue(generator="SEQUENCIA_MEMBRO",strategy=GenerationType.SEQUENCE)
	@Column(name="id_member")
	private Integer idMember;
	
	@Column(name="name_member")
	private String nameMember;
	
	@ManyToOne
	@JoinColumn(name="id_team",nullable=false)
	private Team team;
	
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

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

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
