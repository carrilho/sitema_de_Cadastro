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
@Table (name="TbTipoEndereco")
public class TipoEndereco implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public TipoEndereco(){
		super();
	}
	
	@Id
	@GeneratedValue
	private Integer idTpEndereco;
	@Column (length=20, nullable=false)
	private String  nomeTpEnd;
	
	@OneToMany(mappedBy="tipoEndereco", fetch=FetchType.LAZY)
	@ForeignKey(name="endTipoEnderecoPK")
	private List<Endereco> enderecos;
	
	public Integer getIdTpEndereco() {
		return idTpEndereco;
	}
	public void setIdTpEndereco(Integer idTpEndereco) {
		this.idTpEndereco = idTpEndereco;
	}
	public String getNomeTpEnd() {
		return nomeTpEnd;
	}
	public void setNomeTpEnd(String nomeTpEnd) {
		this.nomeTpEnd = nomeTpEnd;
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
				+ ((idTpEndereco == null) ? 0 : idTpEndereco.hashCode());
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
		TipoEndereco other = (TipoEndereco) obj;
		if (idTpEndereco == null) {
			if (other.idTpEndereco != null)
				return false;
		} else if (!idTpEndereco.equals(other.idTpEndereco))
			return false;
		return true;
	}
}
