package com.abelgomez.gomeza.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.abelgomez.gomeza.entity.Usuario;
import com.abelgomez.gomeza.services.IUsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioRestController {

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping("/listarUsuarios")
	public List<Usuario> index() {
		return (List<Usuario>) usuarioService.findAll();

	};

	@GetMapping("/buscarUsuarioPorID/{id}")
	public Usuario show(@PathVariable Long id) {
		return (Usuario) usuarioService.finById(id);
	}

	@PostMapping("/nuevoUsuario")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
	}

	// editar
	@PutMapping("/editarUsuario/{id}")
	public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id) {

		Usuario usuarioActual = usuarioService.finById(id);

		usuarioActual.setNombre(usuario.getNombre());
		usuarioActual.setClave(usuario.getClave());
		usuarioActual.setEmail(usuario.getEmail());
		usuarioActual.setEstado(usuario.isEstado());

		return usuarioService.save(usuarioActual);

	}

	// eliminar
	@DeleteMapping("/eliminarUsuario/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {

		usuarioService.delete(id);
	}

	public UsuarioRestController() {
		// TODO Auto-generated constructor stub
	}

}
