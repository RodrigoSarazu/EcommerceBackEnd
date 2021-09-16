package com.ecommerce.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ecommerce.entity.DetallePedido;

public interface DetallePedidoRepository extends CrudRepository<DetallePedido, Integer> {

	//Método para retornar un pedido
	@Query("SELECT DP FROM DetallePedido DP WHERE DP.pedido.id=:idP")
	Iterable<DetallePedido>findByPedido(int idP);
}
