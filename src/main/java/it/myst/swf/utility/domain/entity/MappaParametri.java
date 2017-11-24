package it.myst.swf.utility.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import it.myst.swf.utility.domain.listener.MappaParametriListener;

@Entity
@EntityListeners(MappaParametriListener.class)
@Table(name="HBN_MAPPA_PARAMETRI")
public class MappaParametri {

	@Id
    @Column(name = "COD_PARAMETRO")
	private Integer codParametro;

	@Column(name = "DES_PARAMETRO", nullable=true)
	private String desParametro;
	
	@Column(name = "ID_USER", nullable=false)
	private String user;

	@Column(name = "ID_TIMESTAMP", nullable=false, insertable=false, updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;
	
	public Integer getCodParametro() {
		return codParametro;
	}

	public void setCodParametro(Integer codParametro) {
		this.codParametro = codParametro;
	}

	public String getDesParametro() {
		return desParametro;
	}

	public void setDesParametro(String desParametro) {
		this.desParametro = desParametro;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
    public String toString() {
        return "Class info [cod=" + this.codParametro 
        			+ ", des=" + this.desParametro + "]";
    }

}
