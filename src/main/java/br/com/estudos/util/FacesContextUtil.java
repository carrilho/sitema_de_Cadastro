package br.com.estudos.util;

import javax.faces.context.FacesContext;

import org.hibernate.Session;

public class FacesContextUtil {
	
	private static final String HIBERNATE_SESSION = "hibernate_session";
	
	//metodo que seta a sessao na requisicao do usuario
	public static void setRequestSession(Session session){
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(HIBERNATE_SESSION, session);
	}
	
	//metodo para recuperar a sessao
	public static Session getRequestSession() {
		return (Session) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(HIBERNATE_SESSION);
	}

}
