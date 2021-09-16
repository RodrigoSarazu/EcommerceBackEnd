package com.ecommerce.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ecommerce.entity.Platillo;

public interface PlatilloRepository extends CrudRepository<Platillo, Integer>{
	
	@Query("SELECT P FROM Platillo P WHERE P.recomendado IS 1")
    Iterable<Platillo> listarPlatillosRecomendados();

    @Query("SELECT P FROM Platillo P WHERE P.categoria.id=:idC")
    Iterable<Platillo> listarPlatillosPorCategoria(int idC);
    
    //Método para actualizar el stock del platillo
    @Modifying
    @Query("UPDATE Platillo P SET P.stock=stock-:cant WHERE P.id=:id")
    void actualizarStock(int cant, int id);
    
}
