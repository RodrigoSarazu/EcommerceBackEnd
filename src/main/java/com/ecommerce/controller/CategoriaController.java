package com.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.service.CategoriaService;
import com.ecommerce.utils.GenericResponse;

@RestController
@RequestMapping("api/categoria")
public class CategoriaController {

	private final CategoriaService service;

	public CategoriaController(CategoriaService service) {
		this.service = service;
	}
	
	@GetMapping
	public GenericResponse listarCategoriasActivas() {
		return this.service.listarCategoriasActivas();
	}
	
}
