package it.myst.swf.utility.business.service.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import it.myst.swf.utility.business.service.UtilityService;
import it.myst.swf.utility.domain.entity.Forecast;
import it.myst.swf.utility.domain.entity.Product;
import it.myst.swf.utility.domain.entity.User;
import it.myst.swf.utility.web.data.SearchCriteria;

/**
 * A JPA-based implementation of the Forecast Service. 
 * Delegates to a JPA entity manager to issue data access calls against the backing repository. 
 * The EntityManager reference is provided by the managing container (Spring) automatically.
 * 
 */
@Service("utilityService")
@Repository
public class JpaUtilityServiceImpl implements UtilityService, Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager em;
	
	private static Logger logger = LoggerFactory.getLogger(JpaUtilityServiceImpl.class);
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Forecast> findForecasts(String name) {
		if (name != null) {
			return em.createQuery("select b from Forecast b where b.name = :name order by b.id")
					.setParameter("name", name)
					.getResultList();
		} else {
			return null;
		}
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Product> findProducts(SearchCriteria criteria, int firstResult, String orderBy, boolean ascending) {
		String pattern = getSearchPattern(criteria);
		orderBy = (orderBy != null) ? orderBy : "name";
		String orderDirection = (ascending) ? " ASC" : " DESC";
		String sql = "select h from Product h where lower(h.name) like :pattern  "
			+ "or lower(h.state) like :pattern order by h."
			+ orderBy + orderDirection;
		List<Product> resultList = em.createQuery(sql)
						.setParameter("pattern", pattern)
						.setMaxResults(criteria.getPageSize())
						.setFirstResult(firstResult)
						.getResultList();
		// Forecast testing:
		List<Forecast> resultListForecast = null;
		try {
			String sqlForecast = "select h from Forecast h";
			resultListForecast = em.createQuery(sqlForecast).getResultList();
		} catch(Exception e) {
			logger.error("ERROR: "+e.getMessage(),e);
		}

		return resultList;
	}

	@Transactional(readOnly = true)
	public int getNumberOfProducts(SearchCriteria criteria) {
		String pattern = getSearchPattern(criteria);
		Long count = (Long) em
				.createQuery(
						"select count(h.id) from Forecast h where lower(h.name) like :pattern "
							+ "or lower(h.description) like :pattern ")
							.setParameter("pattern", pattern)
							.getSingleResult();
		return count.intValue();
	}

	@Transactional(readOnly = true)
	public Product findProductById(Long id) {
		return em.find(Product.class, id);
	}

//	@Transactional(readOnly = true)
	public Forecast createForecast(String name, String desc, BigDecimal value, Product product) {
		Forecast forecast = new Forecast(name, desc, value, product);
		return forecast;
	}

	@Transactional
	public void persistForecast(Forecast forecast) {
		em.persist(forecast);
	}

	@Transactional
	public void cancelForecast(Forecast forecast) {
		forecast = em.find(Forecast.class, forecast.getId());
		if (forecast != null) {
			em.remove(forecast);
		}
	}

	// helpers

	private String getSearchPattern(SearchCriteria criteria) {
		if (StringUtils.hasText(criteria.getSearchString())) {
			return "%" + criteria.getSearchString().toLowerCase().replace('*', '%') + "%";
		} else {
			return "%";
		}
	}

	private User findUser(String username) {
		return (User) em.createQuery("select u from User u where u.username = :username")
				.setParameter("username", username).getSingleResult();
	}
	
	@Override
	public void evalutateStringVar(String stringVar) {
		String eval=null;
		eval=stringVar;
	}

	@Override
	public void evalutateForecastsVar(List<Forecast> forecasts) {
		List<Forecast> list=null;
		list=forecasts;
	}

}