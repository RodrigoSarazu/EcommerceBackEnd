package com.ecommerce.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ecommerce.entity.DetallePedido;
import com.ecommerce.repository.DetallePedidoRepository;

@Service
@Transactional
public class DetallePedidoService {

	private final DetallePedidoRepository repository;

	public DetallePedidoService(DetallePedidoRepository repository) {
		this.repository = repository;
	}
	//Método para guardar los detalles del pedido
	public void guardarDetalles(Iterable<DetallePedido> detalle) {
		this.repository.saveAll(detalle);
	}
	
	
}
