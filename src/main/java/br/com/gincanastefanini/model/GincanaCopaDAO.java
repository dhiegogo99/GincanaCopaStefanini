package br.com.gincanastefanini.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.gincanastefanini.dto.TimeDTO;

/**
 * DAO para intera��o com base de dados, criando tabelas, realizando consulta e
 * inser��es
 * 
 * @author eaoliveira5
 */
public class GincanaCopaDAO {

	private static GincanaCopaDAO instance;

	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * Instancia do DAO
	 * 
	 * @return instance;
	 */
	public static GincanaCopaDAO getInstance() {
		if (instance == null) {
			instance = new GincanaCopaDAO();
		}
		return instance;
	}

	/**
	 * M�todo de setInstance do DAO
	 * 
	 * @param instance
	 */
	public static void setInstance(GincanaCopaDAO instance) {

		GincanaCopaDAO.instance = instance;
	}

	/**
	 * M�todo Construtor {@link GincanaCopaDAO}
	 */
	private GincanaCopaDAO() {
		entityManager = getEntityManager();
	}

	/**
	 * M�todo que retorna EntityManager
	 * 
	 * @return entityManager
	 */
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("copagincana-dev");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	// Atribui��o da tabela atrav�s da entidades de cada classe
	/**
	 * M�todo da classe Team para pegar o ID
	 * 
	 * @param id
	 * @return
	 */
	public Team getTeamId(final int id) {

		return entityManager.find(Team.class, id);
	}

	/**
	 * M�todo de inser��o ao banco Team
	 * 
	 * @param team
	 */
	public void registerTeam(Team team) {
		try {
			this.entityManager.persist(team);
		} catch (Exception ex) {
			ex.printStackTrace();
			this.entityManager.getTransaction().rollback();
		}
	}

	public void saveProductTeam(ProductTeam productTeam) {

		try {
			this.entityManager.persist(productTeam);
		} catch (Exception e) {
			this.entityManager.getTransaction().rollback();
		}

	}

	public void insertMembro(Member member) {
		try {
			this.entityManager.persist(member);
		} catch (Exception ex) {
			ex.printStackTrace();
			this.entityManager.getTransaction().rollback();
		}

	}

	public List<Member> findAllTeamAndPlayers() {
		try {
			return entityManager.createQuery("select m from Member m order by m.team.idTeam DESC", Member.class)
					.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public List<Team> findAllTimes() {
		try {
			return entityManager.createQuery("select t from Team t order by t.teamName", Team.class).getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public boolean verificaExisteTime(Team team) {

		try {
			Query query = entityManager.createQuery("select t from Team t where UPPER(t.teamName) LIKE :nomeTeam ",
					Team.class);

			query.setParameter("nomeTeam", team.getTeamName().toUpperCase());

			return query.getResultList().size() > 0;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	public List<TimeDTO> findAllProductTeam() {
		try {

			StringBuilder sql = new StringBuilder();
			sql.append(" select new br.com.gincanastefanini.dto.TimeDTO( ");
			sql.append(" t.teamName,pc.descCategory, p.productDescr,pt.qtdItem,pt.qtdItem * p.productScore ");
			sql.append(" ) from  ProductTeam pt inner join pt.product p inner join p.categoria pc");
			sql.append(" inner join pt.team t ");

			return entityManager.createQuery(sql.toString(), TimeDTO.class).getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public List<TimeDTO> getRanking() {
		try {

			StringBuilder sql = new StringBuilder();
			sql.append(" select distinct new br.com.gincanastefanini.dto.TimeDTO( ");
			sql.append(" t.teamName,pc.descCategory, p.productDescr,pt.qtdItem, ");
			sql.append("  (select SUM(pt1.qtdItem * p1.productScore) as soma");
			sql.append("  from  ProductTeam pt1 inner join pt1.product p1 inner join p1.categoria pc1 ");
			sql.append("  inner join pt1.team t1 where t1.id = t.id ) as soma ");
			sql.append(" , pt.dtConclusion,p.productScore, pt.uniMed ");
			sql.append(" ) from  ProductTeam pt inner join pt.product p inner join p.categoria pc ");
			sql.append(" inner join pt.team t  ");
			sql.append(
					" group by t.teamName,pc.descCategory, p.productDescr,pt.qtdItem,pt.dtConclusion,p.productScore, pt.uniMed,t.id ");
			sql.append(" order by soma DESC ");

			List<TimeDTO> list = entityManager.createQuery(sql.toString(), TimeDTO.class).getResultList();
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public List<Team> listAllTeam() {
		try {
			return entityManager.createQuery("select t from Team t order by t.teamName", Team.class).getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public List<Categoria> listAllCategory() {
		try {
			return entityManager.createQuery("select c from Categoria c order by c.descCategory ", Categoria.class)
					.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public List<Product> buscarItem(Integer idCategory) {
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(" select t  ");
			sb.append(" from Product t inner join t.categoria c ");
			sb.append(" where c.idCategory = :idCategory ");
			sb.append(" order by c.descCategory ");
			Query query = entityManager.createQuery(sb.toString(), Product.class);
			query.setParameter("idCategory", idCategory);
			return query.getResultList();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public void saveListProductTeam(List<ProductTeam> listProductTeam) {
		try {
			for (ProductTeam productTeam : listProductTeam) {
				this.entityManager.persist(productTeam);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			this.entityManager.getTransaction().rollback();
		}
	}

}
