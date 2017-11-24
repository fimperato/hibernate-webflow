package it.myst.swf.web.backingbean;

import java.io.Serializable;


public class TestOperazioniBBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String bbAttributeOne;
	private Boolean bbAttributeTwo;
	public String getBbAttributeOne() {
		return bbAttributeOne;
	}
	public void setBbAttributeOne(String bbAttributeOne) {
		this.bbAttributeOne = bbAttributeOne;
	}
	public Boolean getBbAttributeTwo() {
		return bbAttributeTwo;
	}
	public void setBbAttributeTwo(Boolean bbAttributeTwo) {
		this.bbAttributeTwo = bbAttributeTwo;
	}
	
}
