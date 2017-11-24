/**
 *
 */
package it.myst.swf.utility.web;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;

import it.myst.swf.utility.business.service.UtilityService;
import it.myst.swf.utility.domain.entity.Product;
import it.myst.swf.utility.web.data.SearchCriteria;

public class ProductLazyDataModel extends LazyDataModel<Product> {

	private static final long serialVersionUID = -3410328440186686264L;

	private SearchCriteria searchCriteria;

	private UtilityService utilityService;

	private List<Product> products;

	private Product selected;

	@Autowired
	public void setUtilityService(UtilityService service) {
		this.utilityService = service;
	}

	public void setSearchCriteria(SearchCriteria searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	@Override
	public List<Product> load(int first, int pageSize, String sortField, SortOrder order, Map<String, Object> filters) {
		int currentPage = first / (pageSize + 1);
		this.searchCriteria.setCurrentPage(currentPage);
		this.products = utilityService.findProducts(searchCriteria, first, sortField, order.equals(SortOrder.ASCENDING));
		return products;
	}

	@Override
	public Product getRowData(String rowKey) {
		for (Product product : this.products){
			if (product.getId().equals(rowKey)) {
				return product;
			}
 		}
		return null;
	}

	@Override
	public Object getRowKey(Product product) {
		return product.getId();
	}

	@Override
	public int getRowCount() {
		return utilityService.getNumberOfProducts(searchCriteria);
	}

	public Product getSelected() {
		return selected;
	}

	public void setSelected(Product selected) {
		this.selected = selected;
	}

	public int getCurrentPage() {
		return this.searchCriteria.getCurrentPage();
	}

	public int getPageSize() {
		return this.searchCriteria.getPageSize();
	}

}