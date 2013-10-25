package br.com.estudos.util;

import javax.faces.context.FacesContext;

import org.hibernate.Session;

public class FacesContextUtil {
	
	private static final String HIBERNATE_SESSION = "hibernate_session";
	
	//método que seta a sessão na requisição do usuário
	public static void setRequestSession(Session session){
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(HIBERNATE_SESSION, session);
	}
	
	//método para recuperar a sessão
	public static Session getRequestSession() {
		return (Session) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(HIBERNATE_SESSION);
	}

}
