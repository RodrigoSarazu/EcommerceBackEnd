package com.ecommerce.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ecommerce.repository.PlatilloRepository;
import com.ecommerce.utils.GenericResponse;
import static com.ecommerce.utils.Global.*;
@Service
@Transactional
public class PlatilloService {

	private final PlatilloRepository repository;

	public PlatilloService(PlatilloRepository repository) {
		this.repository = repository;
	}
	//método listar platillos recomendados
	public GenericResponse listarPlatillosRecomendados() {
		return new GenericResponse(TIPO_DATA,RPTA_OK,OPERACION_CORRECTA,this.repository.listarPlatillosRecomendados());
	}
	
	public GenericResponse listarPlatillosPorCategoria(int idC) {
		return new GenericResponse(TIPO_DATA,RPTA_OK,OPERACION_CORRECTA,this.repository.listarPlatillosPorCategoria(idC));
	}
	
}
