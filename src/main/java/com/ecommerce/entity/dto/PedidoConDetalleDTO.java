package com.ecommerce.entity.dto;

import java.util.ArrayList;

import com.ecommerce.entity.DetallePedido;
import com.ecommerce.entity.Pedido;

public class PedidoConDetalleDTO {
	
	private Pedido pedido;
	//Lista de DetallePedido
	private Iterable<DetallePedido> detallePedido;
	
	public PedidoConDetalleDTO() {
		this.pedido=new Pedido();
		this.detallePedido=new ArrayList<>();
	}
	//crear el constructor
	

	public Pedido getPedido() {
		return pedido;
	}

	public PedidoConDetalleDTO(Pedido pedido, Iterable<DetallePedido> detallePedido) {
		super();
		this.pedido = pedido;
		this.detallePedido = detallePedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Iterable<DetallePedido> getDetallePedido() {
		return detallePedido;
	}

	public void setDetallePedido(Iterable<DetallePedido> detallePedido) {
		this.detallePedido = detallePedido;
	}
	
}
