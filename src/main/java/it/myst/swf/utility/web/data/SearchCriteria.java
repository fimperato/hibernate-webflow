package it.myst.swf.utility.web.data;

import java.io.Serializable;

/**
 * A backing bean for the product search form. 
 */
public class SearchCriteria implements Serializable {

	private static final long serialVersionUID = 1L;

	private String searchString = "";

	private int pageSize = 5;

	private int currentPage = 1;

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String toString() {
		return "[Search Criteria searchString = '" + searchString + "'";
	}

}