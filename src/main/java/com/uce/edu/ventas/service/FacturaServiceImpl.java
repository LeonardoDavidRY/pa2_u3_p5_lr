package com.uce.edu.ventas.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.ventas.repository.IClienteRepository;
import com.uce.edu.ventas.repository.IFacturaRepositoty;
import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepositoty iFacturaRepositoty;
	
	@Autowired
	private IClienteService iClienteService;
	@Override
	public Factura buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.iFacturaRepositoty.seleccionarPorNumero(numero);
	}

	@Override
	@Transactional(value=TxType.REQUIRED)
	public void guardar(Factura factura, Cliente cliente) {
		// TODO Auto-generated method stub
		
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		this.iFacturaRepositoty.insertar(factura);
		System.out.println("paso el insert de factura");
		this.iClienteService.guardar(cliente);
		System.out.println("paso el insert de cliente");

	}

	@Override
	public List<Factura> buscarFacturasInnerJoin() {
		// TODO Auto-generated method stub
		return this.iFacturaRepositoty.seleccionarFacturasInnerJoin();
	}

	@Override
	public List<Factura> buscarFacturasRightJoin() {
		// TODO Auto-generated method stub
		return this.iFacturaRepositoty.seleccionarFacturasRightJoin();
	}

	@Override
	public List<Factura> buscarFacturasLeftJoin() {
		// TODO Auto-generated method stub
		return this.iFacturaRepositoty.seleccionarFacturasLeftJoin();
	}

	@Override
	public List<Factura> buscarFacturasFullJoin() {
		// TODO Auto-generated method stub
		return this.iFacturaRepositoty.seleccionarFacturasFullJoin();
	}

	@Override
	public List<Factura> buscarFacturasWhereJoin() {
		// TODO Auto-generated method stub
		return this.iFacturaRepositoty.seleccionarFacturasWhereJoin();
	}

	@Override
	public List<Factura> buscarFacturasFetchJoin() {
		// TODO Auto-generated method stub
		return this.iFacturaRepositoty.seleccionarFacturasFetchJoin();
	}

	@Override
	public int actualizarfechas(LocalDateTime fechaNueva, LocalDateTime fechaActual) {
		// TODO Auto-generated method stub
		return this.iFacturaRepositoty.actualizarfechas(fechaNueva, fechaActual);
	}

	@Override
	public int borrarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.iFacturaRepositoty.eliminarPorNumero(numero);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iFacturaRepositoty.eliminar(id);
		
	}

	@Override
	public List<FacturaDTO> buscarFacturaDTO() {
		// TODO Auto-generated method stub
		return this.iFacturaRepositoty.seleccionarFacturaDTO();
	}

}
