package br.com.estudos.util;

import javax.faces.context.FacesContext;

import org.hibernate.Session;

public class FacesContextUtil {
	
	private static final String HIBERNATE_SESSION = "hibernate_session";
	
	//m�todo que seta a sess�o na requisi��o do usu�rio
	public static void setRequestSession(Session session){
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(HIBERNATE_SESSION, session);
	}
	
	//m�todo para recuperar a sess�o
	public static Session getRequestSession() {
		return (Session) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(HIBERNATE_SESSION);
	}

}
