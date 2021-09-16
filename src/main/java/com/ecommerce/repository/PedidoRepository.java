package com.ecommerce.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ecommerce.entity.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Integer>{
	//Consulta
	//compras por el cliente el cual se va a traer por su id
	@Query("SELECT P FROM Pedido P WHERE P.cliente.id=:idCli")
	Iterable<Pedido>devolverMisCompras(int idCli);
}
