package it.myst.swf.core.web.data;

import java.io.Serializable;

/**
 * 3.9.1. Flow Scope
 * Flow scope gets allocated when a flow starts and destroyed when the flow ends. 
 * With the default implementation, any objects stored in flow scope need to be Serializable.
 *
 */
public class MyFlowData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String chief;
	private String azienda;
	private Integer eta;
	
	public String getChief() {
		return chief;
	}
	public void setChief(String chief) {
		this.chief = chief;
	}
	public String getAzienda() {
		return azienda;
	}
	public void setAzienda(String azienda) {
		this.azienda = azienda;
	}
	public Integer getEta() {
		return eta;
	}
	public void setEta(Integer eta) {
		this.eta = eta;
	}
	
}
