package it.myst.swf.core.web.backingbean;

import java.io.Serializable;

public class ErrorMsgBBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String code;
	private String desc;
	private String severity;
	private String detail;

	public ErrorMsgBBean(String code, String desc, String severity, String detail) {
		super();
		this.code = code;
		this.desc = desc;
		this.severity = severity;
		this.detail = detail;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}
