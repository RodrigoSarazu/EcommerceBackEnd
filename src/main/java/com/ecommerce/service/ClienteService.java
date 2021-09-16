package com.ecommerce.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ecommerce.entity.Cliente;
import com.ecommerce.repository.ClienteRepository;
import com.ecommerce.utils.GenericResponse;
import static com.ecommerce.utils.Global.*;

@Service
@Transactional
public class ClienteService {

	private final ClienteRepository repository;

	public ClienteService(ClienteRepository repository) {
		super();
		this.repository = repository;
	}
	
	//creando Método para guardar y actualizar cliente
	
	public GenericResponse save(Cliente c) {
		//traemos el repository por findById obteniendo por Id
		Optional<Cliente> otp=this.repository.findById(c.getId());
		//operador ternario
		int idf=otp.isPresent() ? otp.get().getId() : 0;
		if(idf==0) {
			if(repository.existByDoc(c.getNumDoc().trim())==1) {
				return new GenericResponse(TIPO_RESULT,RPTA_WARNING,"Lo sentimos: "+
			"Ya existe un cliente con ese mismo número de documento, y "
			+ "si el problema persiste comuniquese con el soporte técnico",null);
			}else {
				//Guardar
				c.setId(idf);
				return new GenericResponse(TIPO_DATA,RPTA_OK,"Cliente registrado correctamente", this.repository.save(c));
			}
		}else {
			//Actualiza registro
			if(repository.existByDocForUpdate(c.getNumDoc().trim(), c.getId())==1) {
				return new GenericResponse(TIPO_RESULT,RPTA_WARNING,"Error: Ya existe un cliente con esos mismo datos"
						+ "verifique e intente de nuevo",null);
			}
			else {
				//Actualizar 
				c.setId(idf);
				return new GenericResponse(TIPO_DATA,RPTA_OK,"Datos del cliente actualizado",this.repository.save(c));
			}
		}
	}
	
	
}
