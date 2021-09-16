package com.ecommerce.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ecommerce.repository.CategoriaRepository;
import com.ecommerce.utils.GenericResponse;
import static com.ecommerce.utils.Global.*;

@Service
@Transactional
public class CategoriaService {

	private final CategoriaRepository repository;

	public CategoriaService(CategoriaRepository repository) {
		this.repository = repository;
	}
	//método para listar 
	public GenericResponse listarCategoriasActivas() {
		return new GenericResponse(TIPO_DATA,RPTA_OK,OPERACION_CORRECTA,this.repository.listarCategoriaActivas());
		
	}
	
	
}
