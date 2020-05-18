package com.isidrocorp.vmperuse.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tbl_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="racf", length=7)
	private String racf;
	
	@Column(name="senha", length=20)
	private String senha;
	
	@Column(name="nome", length=100)
	private String nome;
	
	@Column(name="email", length=80)
	private String email;
	
	@Column(name="telefone", length=20)
	private String telefone;
	
	@Column(name="setor", length=50)
	private String setor;
	
	@Column(name="linkfoto", length=200)
	private String linkFoto;
	
	/* preciso anotar a lista de pedidos indicando que há uma relação Um-Para-Muitos entre
	 * Usuário e Solicitacao (Um Usuário realiza muitas solicitacões)
	 * Além disso, preciso obrigatoriamente dizer qual o atributo dentro do objeto Solicitacao
	 *      referencia o usuário (através do maapedBy)
	 *  O Cascade indica que, se eu fizer uma determinada operação no usuário isso tb vai 
	 *  se refletir nas solicitações (ex: inseri um usuário, faço a inserção de uma nova solicitação, se for o caso)
	 */
	@OneToMany(mappedBy="solicitante", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("solicitante")
	private List<Solicitacao> pedidos;
	
	
	public List<Solicitacao> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Solicitacao> pedidos) {
		this.pedidos = pedidos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRacf() {
		return racf;
	}
	public void setRacf(String racf) {
		this.racf = racf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public String getLinkFoto() {
		return linkFoto;
	}
	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
