package br.com.estudos.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table (name="TbEndereco")
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer idEndereco;
	@Column (length=80, nullable=false)
	private String bairro;
	@Column (length=10, nullable=false)
	private String cep;
	@Column
	private String complemento;
	@Column (length=100)
	private String rua;
	@Column (length=5)
	private int numero;
	
	@OneToOne(optional = false, fetch = FetchType.EAGER)	
	@ForeignKey(name="endPessoaFK")
	private Pessoa pessoa;
	
	@ManyToOne
	@ForeignKey(name="endCidadeFK")
	@JoinColumn(name="idCidade",referencedColumnName="idCidade")
	private Cidade cidade;
	
	@ManyToOne
	@ForeignKey(name="endEstadoFK")
	@JoinColumn(name="idEstado",referencedColumnName="idEstado")
	private Estado estado;
	
	@ManyToOne
	@ForeignKey(name="endTipoEnderecoPK")
	@JoinColumn(name="idTpEndereco",referencedColumnName="idTpEndereco")
	private TipoEndereco tipoEndereco;

	public Endereco() {
		this.cidade		  =  new Cidade();
	}
	
	public Integer getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(TipoEndereco tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idEndereco == null) ? 0 : idEndereco.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (idEndereco == null) {
			if (other.idEndereco != null)
				return false;
		} else if (!idEndereco.equals(other.idEndereco))
			return false;
		return true;
	}
}
