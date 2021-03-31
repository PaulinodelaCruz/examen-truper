package com.examen.truper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.truper.entities.Detalle;
import com.examen.truper.entities.Pedido;
import com.examen.truper.service.DetalleService;
import com.examen.truper.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

	@Autowired
	private PedidoService pedidoService;

	@Autowired
	private DetalleService detalleService;

	@PostMapping
	public ResponseEntity<Pedido> guardaPedido(@RequestBody Pedido pedido) {

		return new ResponseEntity<Pedido>(pedidoService.guardaPedido(pedido), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Pedido>> listaPedidos() {
		return new ResponseEntity<List<Pedido>>(pedidoService.listaPedidos(), HttpStatus.OK);
	}

	@PostMapping("/{idPedido}")
	public ResponseEntity<Detalle> guardaDetalle(@PathVariable("idPedido") Integer idPedido,
			@RequestBody Detalle detallePedido) {

		return new ResponseEntity<Detalle>(detalleService.guardaDetalle(idPedido, detallePedido), HttpStatus.CREATED);

	}

	@GetMapping("/{idPedido}/detalles")
	public ResponseEntity<List<Detalle>> listaDetallePedidos(@PathVariable("idPedido") Integer idPedido) {
		return new ResponseEntity<List<Detalle>>(detalleService.listaDetalleByIdPedido(idPedido), HttpStatus.OK);
	}

}
