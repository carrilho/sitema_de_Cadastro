package br.com.estudos.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.hibernate.Session;

public class PhaseListenerCadastro implements PhaseListener{

	private static final long serialVersionUID = 1L;
	
	@Override
	public void afterPhase(PhaseEvent phase) {
		if(phase.getPhaseId().equals(PhaseId.RESTORE_VIEW)){
			System.out.println("Antes da fase" + getPhaseId());
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			FacesContextUtil.setRequestSession(session);

		}
	}

	@Override
	public void beforePhase(PhaseEvent phase) {
		if(phase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)){
			System.out.println("Depois da fase" + getPhaseId());
			Session session = FacesContextUtil.getRequestSession();
			try {
				session.getTransaction().commit();
			} catch (Exception e) {
				if(session.getTransaction().isActive()){
					session.getTransaction().rollback();
				}
			}finally{
				session.close();
			}
		}
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
