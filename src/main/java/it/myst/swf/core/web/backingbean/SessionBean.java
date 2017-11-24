package it.myst.swf.core.web.backingbean;

import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class SessionBean {

	private String prevViewState = "";
	
	// Test Preparazione stringa orgUnitKeyExt
	private String orgUnitKeyExt;
	
	// Test CodGestione Usata per il partitario
	private String codGestione;
	
	// Test variabile utilizzata per passare un input ad un flusso
	private String modalitaLancioFlow;
	
	// Test Stato sessioni
	private boolean sessioneContabilitaInizializzata = false;

	public String getOrgUnitKeyExt() {
		return orgUnitKeyExt;
	}

	public void setOrgUnitKeyExt(String orgUnitKeyExt) {
		this.orgUnitKeyExt = orgUnitKeyExt;
	}

	public String getCodGestione() {
		return codGestione;
	}

	public void setCodGestione(String codGestione) {
		this.codGestione = codGestione;
	}

	public String getModalitaLancioFlow() {
		return modalitaLancioFlow;
	}

	public void setModalitaLancioFlow(String modalitaLancioFlow) {
		this.modalitaLancioFlow = modalitaLancioFlow;
	}

	public boolean isSessioneContabilitaInizializzata() {
		return sessioneContabilitaInizializzata;
	}

	public void setSessioneContabilitaInizializzata(boolean sessioneContabilitaInizializzata) {
		this.sessioneContabilitaInizializzata = sessioneContabilitaInizializzata;
	}
	
	public void initPrevViewState() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		if (facesContext != null && facesContext.getViewRoot() != null) {
			String viewId = facesContext.getViewRoot().getViewId();
			int beginIndex = viewId.lastIndexOf("/") + 1;
			int endIndex = viewId.lastIndexOf(".");
			this.prevViewState = viewId.substring(beginIndex, endIndex);
		}
	}

	public String getPrevViewState() {
		return prevViewState;
	}

	public void setPrevViewState(String prevViewState) {
		this.prevViewState = prevViewState;
	}
	
}
