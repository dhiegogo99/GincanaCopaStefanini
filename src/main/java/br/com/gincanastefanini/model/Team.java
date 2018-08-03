package br.com.gincanastefanini.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * entidade para o time
 * 
 * @author eaoliveira5
 *
 */

@Entity
@Table(name = "TB_TEAM", schema = "public")
public class Team implements BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 952996267288368256L;

	@Id
	@Column(name = "id_team", nullable = false, length = 20)
	@SequenceGenerator(sequenceName = "sequence_team", name = "SEQUENCIA", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "SEQUENCIA", strategy = GenerationType.SEQUENCE)
	private Integer idTeam;

	@Column(name = "team_name")
	private String teamName;

	@OneToMany(mappedBy = "team")
	private List<Member> member;

	//Ele cria um coluna fk de producTeam
	@OneToMany(mappedBy = "team")
	private List<ProductTeam> productTeam;

	public List<ProductTeam> getProductTeam() {
		if (productTeam == null) {
			productTeam = new ArrayList<>();
			
		}

		return productTeam;
	}

	public void setProductTeam(List<ProductTeam> productTeam) {
		this.productTeam = productTeam;
	}

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

	public List<Member> getMember() {
		if (member == null) {
			member = new ArrayList();
		}
		return member;
	}

	public void setMember(List<Member> member) {
		this.member = member;
	}


	@Override
	public Integer getId() {
		return this.idTeam;
	}

}
