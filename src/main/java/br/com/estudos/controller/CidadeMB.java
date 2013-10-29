package br.com.estudos.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;

import br.com.estudos.model.dao.CadastroDAO;
import br.com.estudos.model.daoImpl.CadastroDAOImpl;
import br.com.estudos.model.entities.Cidade;
import br.com.estudos.util.FacesContextUtil;

@ManagedBean (name="cidadeMB")
@SessionScoped
public class CidadeMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Cidade cidade = new Cidade();
	private List<Cidade> cidades =  new ArrayList<Cidade>();
	
	public CidadeMB(){
		
	}
		
	private CadastroDAO<Cidade> cidadeDAO() {
		CadastroDAO<Cidade> cidadeDAO = new CadastroDAOImpl<Cidade>(
				Cidade.class, FacesContextUtil.getRequestSession());
		return cidadeDAO;
	}
	
	public String limpaCidade(){
		
		cidade = new Cidade();
		
		return"";
	}
	
	public void addCidade() {
		
			cidadeDAO().save(cidade);

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Cidade adicionada com sucesso.",""));
		
		limpaCidade();
	}
	
	public void editarCidade(CellEditEvent event){
		
		 Object oldValue = event.getOldValue();  
	     Object newValue = event.getNewValue(); 
	     
		 UIComponent component =  event.getComponent();
		 UIInput input = (UIInput) component.findComponent("hiddenId");
			
		 Integer id = (Integer) input.getValue();
		 String  nomeCidade = (String) event.getNewValue();
		 
		 cidade.setIdCidade(id);
		 cidade.setNomeCidade(nomeCidade);
		 cidadeDAO().update(cidade);

		  if(newValue != null && !newValue.equals(oldValue)) {  
	            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cidade alterada com sucesso.", 
	            "Valor antigo: " + oldValue + ", Novo valor:" + newValue);  
	            FacesContext.getCurrentInstance().addMessage(null, msg);  
	        }  
		  
		  System.out.println("alterado com todo sucesso do mundo.");
		
	}

	public void removeCidade(){
		
		cidadeDAO().remove(cidade);
		
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Cidade removida com sucesso.",""));
		
		limpaCidade();
		
	}
	
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public List<Cidade> getCidades() {
		
		cidades = cidadeDAO().getEntities();
		
		return cidades;
	}
	
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
}
