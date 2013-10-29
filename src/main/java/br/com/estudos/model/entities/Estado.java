package br.com.estudos.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table (name="TbEstado")
public class Estado implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public Estado(){
		super();
	}
	
	@Id
	@GeneratedValue
	private Integer idEstado;
	@Column (length=20, nullable=false)
	private String nomeEstado;
	
	@OneToMany(mappedBy="estado", fetch=FetchType.LAZY)
	@ForeignKey (name="endEstadoFK")
	private List<Endereco> enderecos;
			
	public Integer getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}
	public String getNomeEstado() {
		return nomeEstado;
	}
	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idEstado == null) ? 0 : idEstado.hashCode());
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
		Estado other = (Estado) obj;
		if (idEstado == null) {
			if (other.idEstado != null)
				return false;
		} else if (!idEstado.equals(other.idEstado))
			return false;
		return true;
	}
}
