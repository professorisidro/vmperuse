package com.isidrocorp.vmperuse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// entidade com nome de tabela (tbl_software)
@Entity
@Table(name="tbl_software")
public class Software {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nome", length = 100)
	private String nome;
	
	@Column(name="fornecedor", length = 100)
	private String fornecedor;
	
	@Column(name="preco")
	private float  valor;
  // id, nome, fornecedor, valor
}
