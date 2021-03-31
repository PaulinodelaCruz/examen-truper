package com.examen.truper.service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.examen.truper.entities.Detalle;
import com.examen.truper.entities.Pedido;
import com.examen.truper.repository.DetalleRepository;
import com.examen.truper.repository.PedidoRepository;

@Service
public class DetalleService {

	@Autowired
	private DetalleRepository detalleRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	public Detalle guardaDetalle(int idpedido, Detalle detallePedido) {

		Optional<Pedido> result = pedidoRepository.findById((long) idpedido);

		if (result.isPresent()) {
			detallePedido.setIdPedido(idpedido);
			return detalleRepository.save(detallePedido);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Pedido no encontrado %d", idpedido));
		}

	}

	public List<Detalle> listaDetalleByIdPedido(Integer idPedido) {

		return detalleRepository.findByIdPedido((long) idPedido);
	}

}
