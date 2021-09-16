package com.ecommerce.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ecommerce.entity.DetallePedido;
import com.ecommerce.entity.Pedido;
import com.ecommerce.entity.dto.GenerarPedidoDTO;
import com.ecommerce.entity.dto.PedidoConDetalleDTO;
import com.ecommerce.repository.DetallePedidoRepository;
import com.ecommerce.repository.PedidoRepository;
import com.ecommerce.repository.PlatilloRepository;
import com.ecommerce.utils.GenericResponse;
import static com.ecommerce.utils.Global.*;

@Service
@Transactional
public class PedidoService {

	private final PedidoRepository repository;
	private final DetallePedidoRepository detallePedidoRepository;
	//trayendo el detallePedidoService
	private final DetallePedidoService dpService;
	private final PlatilloRepository pRepository;
	
	
	//Constructor trayendo ambos Repository's y services
	public PedidoService(PedidoRepository repository, DetallePedidoRepository detallePedidoRepository,
			DetallePedidoService dpService, PlatilloRepository pRepository) {
		this.repository = repository;
		this.detallePedidoRepository = detallePedidoRepository;
		this.dpService = dpService;
		this.pRepository = pRepository;
	}
	
	
	//Método para devolver los pedidos con su respectivo detalle 
	public GenericResponse<List<PedidoConDetalleDTO>> devolverMisCompras(int idCli){
		
		final List<PedidoConDetalleDTO> dtos=new ArrayList<>();
		final Iterable<Pedido>pedidos=repository.devolverMisCompras(idCli);
		pedidos.forEach(p->{
			dtos.add(new PedidoConDetalleDTO(p,detallePedidoRepository.findByPedido(p.getId())));
		});
		return new GenericResponse(OPERACION_CORRECTA,RPTA_OK,"Petición encontrada",dtos);
	}
	
	

	//Método para guardar el pedido
	public GenericResponse guardarPedido(GenerarPedidoDTO dto) {
		Date date=new Date();
		//Ingresango la fecha de hoy 
		dto.getPedido().setFechaCompra(new java.sql.Date(date.getTime()));
		dto.getPedido().setAnularPedido(false);
		dto.getPedido().setMonto(dto.getPedido().getMonto());
		dto.getPedido().setCliente(dto.getCliente());
		this.repository.save(dto.getPedido());
		
		for(DetallePedido dp:dto.getDetallePedidos()) {
			dp.setPedido(dto.getPedido());
			this.pRepository.actualizarStock(dp.getCantidad(),dp.getPlatillo().getId());
		}
		//llamamos al DetallePedidoService
		this.dpService.guardarDetalles(dto.getDetallePedidos());
		return new GenericResponse(TIPO_DATA,RPTA_OK,OPERACION_CORRECTA,dto);
	}
	//Método para anular el pedido
	public GenericResponse anularPedido(int id) {
		Pedido p=this.repository.findById(id).orElse(new Pedido());
		if(p.getId()!=0) {
			p.setAnularPedido(true);
			this.repository.save(p);
			return new GenericResponse(TIPO_DATA,RPTA_OK,OPERACION_CORRECTA,p);
		}else {
			return new GenericResponse(TIPO_DATA,RPTA_OK,OPERACION_ERRONEA,"El pedido que desea anular no es valido");
		}
	}
}
