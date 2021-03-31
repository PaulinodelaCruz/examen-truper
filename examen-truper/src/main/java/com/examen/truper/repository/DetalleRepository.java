package com.examen.truper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.truper.entities.Detalle;

@Repository
public interface DetalleRepository extends JpaRepository<Detalle, Long> {
	
	List<Detalle> findByIdPedido(long idPedido);

}
