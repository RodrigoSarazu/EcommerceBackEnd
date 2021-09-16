package com.ecommerce.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ecommerce.entity.Usuario;
import com.ecommerce.repository.UsuarioRepository;
import com.ecommerce.utils.GenericResponse;
import static com.ecommerce.utils.Global.*;

@Service
@Transactional
public class UsuarioService {

	private final UsuarioRepository repository;

	//creando constructor para llamar al dao
	public UsuarioService(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}
	
	//metodo para iniciar sesion
	
	public GenericResponse<Usuario>login(String email,String contrasenia){
		Optional<Usuario>otpU=this.repository.login(email, contrasenia);
		//si el usuario existe
		if(otpU.isPresent()) {
			return new GenericResponse<Usuario>(TIPO_AUTH,RPTA_OK,"Has iniciado sesión correctamente",otpU.get());
		}//si el usuario no existe
		else {
			return new GenericResponse<Usuario>(TIPO_AUTH,RPTA_WARNING,"Lo sentimos ese usuario no existe",new Usuario());	
		}
	}
	
	//metodo para guardar credenciales del usuario
	public GenericResponse guardarUsuario(Usuario u) {
		//declaramos un optional para buscar por usuario
		Optional<Usuario>optU=this.repository.findById(u.getId());
		//si el usuario esta presente
		int idf=optU.isPresent() ? optU.get().getId() : 0;
		if(idf==0) {
			return new GenericResponse(TIPO_DATA,RPTA_OK,"Usuario registrado correctamente",this.repository.save(u));
		}else {
			return new GenericResponse(TIPO_DATA,RPTA_OK,"Datos del usuario actualizados",this.repository.save(u));
		}
		
		
	}
	
}
