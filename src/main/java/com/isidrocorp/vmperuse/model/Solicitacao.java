package com.isidrocorp.vmperuse.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tbl_solicitacao")
public class Solicitacao {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="num_solicitacao")
	private int    numSolicitacao;
	
	@Column(name="data")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private Date   data;
	
	@Column(name="observacoes", length=200)
	private String observacoes;
	
	@ManyToOne
	@JsonIgnoreProperties("pedidos")
	private Usuario solicitante;    // aqui é a relação da chave estrangeira com Usuario
	
	
	// relaciono a solicitacao com  seu conjunto de itens
	@OneToMany(mappedBy = "solicitacao", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("solicitacao")
	private List<Item> itensSolicitacao;
		
	public List<Item> getItensSolicitacao() {
		return itensSolicitacao;
	}
	public void setItensSolicitacao(List<Item> itensSolicitacao) {
		this.itensSolicitacao = itensSolicitacao;
	}
	public Usuario getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(Usuario solicitante) {
		this.solicitante = solicitante;
	}
	public int getNumSolicitacao() {
		return numSolicitacao;
	}
	public void setNumSolicitacao(int numSolicitacao) {
		this.numSolicitacao = numSolicitacao;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	
	
}
