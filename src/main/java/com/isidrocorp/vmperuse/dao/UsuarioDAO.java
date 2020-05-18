package com.isidrocorp.vmperuse.dao;

import org.springframework.data.repository.CrudRepository;

import com.isidrocorp.vmperuse.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {
	public Usuario findByEmailAndSenha(String email, String senha);
	public Usuario findByRacfAndSenha(String racf, String senha);
}
