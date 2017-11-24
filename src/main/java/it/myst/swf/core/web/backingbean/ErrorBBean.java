package it.myst.swf.core.web.backingbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErrorBBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String code;
	private String desc;
	private String severity;
	private String stacktrace;
	private Date time;
	private String user;
	private String detail;

	private List<ErrorMsgBBean> errMsgList = new ArrayList<ErrorMsgBBean>(0);

	public ErrorBBean() {
		super();

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getStacktrace() {
		return stacktrace;
	}

	public void setStacktrace(String stacktrace) {
		this.stacktrace = stacktrace;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public List<ErrorMsgBBean> getErrMsgList() {
		return errMsgList;
	}

	public void setErrMsgList(List<ErrorMsgBBean> errMsgList) {
		this.errMsgList = errMsgList;
	}

}
