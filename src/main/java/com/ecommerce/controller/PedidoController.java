package com.ecommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.dto.GenerarPedidoDTO;
import com.ecommerce.entity.dto.PedidoConDetalleDTO;
import com.ecommerce.service.PedidoService;
import com.ecommerce.utils.GenericResponse;

@RestController
@RequestMapping("api/pedido")
public class PedidoController {
	private final PedidoService service;

	public PedidoController(PedidoService service) {
		super();
		this.service = service;
	}
	//Listar pedidos con detalles
	@GetMapping("/misPedidos/{idCli}")
	public GenericResponse<List<PedidoConDetalleDTO>> devolverMisComprasConDetalle(@PathVariable int idCli){
		return this.service.devolverMisCompras(idCli);
	}
	//GUARDAR PEDIDO
	@PostMapping
	public GenericResponse guardarPedido(@RequestBody GenerarPedidoDTO dto) {
		return this.service.guardarPedido(dto);
	}
	
	//ANULAR PEDIDO
	@DeleteMapping("/{id}")
	public GenericResponse anularPedido(@PathVariable int id) {
		return this.service.anularPedido(id);
	}

}
