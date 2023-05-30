package com.abelgomez.gomeza.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.abelgomez.gomeza.entity.Usuario;



public interface IUsuarioDAO extends  JpaRepository<Usuario,Long>{

}
