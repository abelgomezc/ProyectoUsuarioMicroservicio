package com.abelgomez.gomeza.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abelgomez.gomeza.dao.IUsuarioDAO;
import com.abelgomez.gomeza.entity.Usuario;

@Service

public class UsuarioServiceImpl  implements IUsuarioService{
	
	@Autowired
	public IUsuarioDAO iUsuarioDAO;
	
	
	
	

//	public UsuarioServiceImpl() {
//		// TODO Auto-generated constructor stub
//	}





	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>)iUsuarioDAO.findAll();
	}





	@Override
	@Transactional
	public Usuario save(Usuario cliente) {
		// TODO Auto-generated method stub
		return iUsuarioDAO.save(cliente);
	}





	@Override
	@Transactional(readOnly = true)
	public Usuario finById(Long id) {
		// TODO Auto-generated method stub
		return iUsuarioDAO.findById(id).orElse(null);
	}





	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		iUsuarioDAO.deleteById(id);
		
	}

}
