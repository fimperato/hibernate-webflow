package it.myst.swf.utility.business.service;

import java.math.BigDecimal;
import java.util.List;

import it.myst.swf.utility.domain.entity.Forecast;
import it.myst.swf.utility.domain.entity.Product;
import it.myst.swf.utility.web.data.SearchCriteria;

/**
 * service interface
 */
public interface UtilityService {

    public List<Forecast> findForecasts(String username);

    public List<Product> findProducts(SearchCriteria criteria, int firstResult, String sortBy, boolean ascending);

    public Product findProductById(Long id);

    public Forecast createForecast(String name, String desc, BigDecimal value, Product product);

    public void persistForecast(Forecast forecast);

    public void cancelForecast(Forecast forecast);

    int getNumberOfProducts(SearchCriteria criteria);
    
    public void evalutateStringVar(String stringVar);

	public void evalutateForecastsVar(List<Forecast> forecasts);
    
}
