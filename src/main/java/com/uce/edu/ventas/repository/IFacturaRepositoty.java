package com.uce.edu.ventas.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;

public interface IFacturaRepositoty {
	
	public Factura seleccionarPorNumero(String numero);
	
	public void insertar (Factura factura);
	
	public void actualizar (Factura factura);
	
	public int actualizarfechas(LocalDateTime fechaNueva, LocalDateTime fechaActual);
	
	public void eliminar (Integer id);
	
	public int eliminarPorNumero(String numero);
	
	public List<Factura> seleccionarFacturasInnerJoin();
	
	public List<Factura> seleccionarFacturasRightJoin();
	
	public List<Factura> seleccionarFacturasLeftJoin();
	
	public List<Factura> seleccionarFacturasFullJoin();
	
	public List<Factura> seleccionarFacturasWhereJoin();
	
	public List<Factura> seleccionarFacturasFetchJoin();
	
	public List<FacturaDTO> seleccionarFacturaDTO();

}
