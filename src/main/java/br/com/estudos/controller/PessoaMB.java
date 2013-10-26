package br.com.estudos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.estudos.model.dao.CadastroDAO;
import br.com.estudos.model.daoImpl.CadastroDAOImpl;
import br.com.estudos.model.entities.Endereco;
import br.com.estudos.model.entities.Pessoa;
import br.com.estudos.util.FacesContextUtil;

@ManagedBean
public class PessoaMB{

	private Pessoa pessoa = new Pessoa();
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	private Endereco endereco = new Endereco();
	
	private CadastroDAO<Pessoa> pessoaDAO() {
		CadastroDAO<Pessoa> pessoaDAO = new CadastroDAOImpl<Pessoa>(
				Pessoa.class, FacesContextUtil.getRequestSession());
		return pessoaDAO;
	}

	public void addPessoa() {
		if (pessoa.getIdPessoa() == null || pessoa.getIdPessoa() == 0) {
			pessoaDAO().save(pessoa);
			FacesContext.getCurrentInstance().addMessage(
					"Cadastro realizado com sucesso!", null);

		} else {
			pessoaDAO().update(pessoa);
			FacesContext.getCurrentInstance().addMessage(
					"Alteração realizada com sucesso!", null);
		}
	}

	public void removerPessoa() {

		if (pessoa.getIdPessoa() != null) {
			pessoaDAO().remove(pessoa);

			FacesContext.getCurrentInstance().addMessage(
					"Cadastro removido com sucesso!", null);
		}

	}

	public List<Pessoa> listaPessoas() {
		
		return null;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
