package com.examen.truper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.examen.truper.entities.Pedido;
import com.examen.truper.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public Pedido guardaPedido(Pedido pedido) {

		return pedidoRepository.save(pedido);

	}
	
	public List<Pedido> listaPedidos() {
		return pedidoRepository.findAll();
	}

}
