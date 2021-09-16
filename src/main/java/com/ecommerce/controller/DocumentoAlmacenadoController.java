package com.ecommerce.controller;

import javax.servlet.http.HttpServletRequest; 

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.DocumentoAlmacenado;
import com.ecommerce.service.DocumentoAlmacenadoService;
import com.ecommerce.utils.GenericResponse;

@RestController
@RequestMapping("api/documento-almacenado")
public class DocumentoAlmacenadoController {

	private DocumentoAlmacenadoService service;

	public DocumentoAlmacenadoController(DocumentoAlmacenadoService service) {
		this.service = service;
	}

	@GetMapping
	public GenericResponse list() {
		return service.list();
	}

	@GetMapping("/{id}")
	public GenericResponse find(@PathVariable Long id) {
		return null;
	}

	@GetMapping("/download/{fileName}")
	public ResponseEntity<Resource> download(@PathVariable String fileName, HttpServletRequest request) {
		return service.downloadByFileName(fileName, request);
	}

	@PostMapping
	public GenericResponse save(@ModelAttribute DocumentoAlmacenado obj) {
		return service.save(obj);
	}

	public GenericResponse update(Long aLong, DocumentoAlmacenado obj) {
		return null;
	}

	public GenericResponse delete(Long aLong) {
		return null;
	}
}
