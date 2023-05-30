package com.abelgomez.gomeza.services;

import java.util.List;

import com.abelgomez.gomeza.entity.Usuario;



public interface IUsuarioService {
	
	public List<Usuario> findAll();

	public Usuario save(Usuario cliente);

	public Usuario finById(Long id);

	public void delete(Long id);

}
