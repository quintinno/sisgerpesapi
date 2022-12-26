package br.com.quintinodigital.sisgerpesapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_PESSOA")
public class PessoaModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CODIGO", nullable = false)
	private UUID codigo;

	@JsonProperty("tipo")
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_PESSOA")
	private TipoPessoaModel tipoPessoaModel;

	@NotNull(message = "O campo NOME deve ser preenchido")
	@Column(name = "NOME", unique = true, nullable = false)
	private String nome;

	public PessoaModel() { }

	public UUID getCodigo() {
		return codigo;
	}

	public void setCodigo(UUID codigo) {
		this.codigo = codigo;
	}

	public TipoPessoaModel getTipoPessoaModel() {
		return tipoPessoaModel;
	}

	public void setTipoPessoaModel(TipoPessoaModel tipoPessoaModel) {
		this.tipoPessoaModel = tipoPessoaModel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaModel other = (PessoaModel) obj;
		return Objects.equals(codigo, other.codigo);
	}

}
