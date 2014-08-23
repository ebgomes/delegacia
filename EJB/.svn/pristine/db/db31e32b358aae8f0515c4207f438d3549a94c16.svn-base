package br.com.arquitetura;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class FacesMessageManager
{
	public void addMessageError(String message) {
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
	}

	public void addMessageInfo(String message) {
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
	}
	
	public void addMessageException(Throwable th) {
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, th != null && th.getMessage() != null ? th.getMessage() : "", null));
	}
	
	public void addMessageWarning(String message) {
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, message, null));
	}
	
	public Object getAttributeSession(String attributeName) {
		return getSession().getAttribute(attributeName);
	}

	public HttpSession getSession() {
		return (HttpSession) getFacesContext().getExternalContext().getSession(true);
	}

	public String getJSessionId(){
		return getSession().getId();
	}
	
	public FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	
}