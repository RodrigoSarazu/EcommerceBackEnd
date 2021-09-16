package com.ecommerce.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Usuario;
import com.ecommerce.service.UsuarioService;
import com.ecommerce.utils.GenericResponse;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

	private final UsuarioService service;

	public UsuarioController(UsuarioService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/login")
	public GenericResponse<Usuario>login(HttpServletRequest request){
		//declaramos variables de tipo String
		String email=request.getParameter("email");
		String contrasenia=request.getParameter("pass");
		return this.service.login(email, contrasenia);
	}
	//datos del usuario guardando
	@PostMapping
	public GenericResponse save(@RequestBody Usuario u) {
		return this.service.guardarUsuario(u);
	}
	
	//datos del usuario actualizando
	@PutMapping("/{id}")
	public GenericResponse update(@PathVariable int id, @RequestBody Usuario u){
		return this.service.guardarUsuario(u);
	}
	
	
}
