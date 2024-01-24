package com.uce.edu.ventas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.ventas.repository.IFacturaRepositoty;
import com.uce.edu.ventas.repository.modelo.Factura;
@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepositoty iFacturaRepositoty;
	@Override
	public Factura buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.iFacturaRepositoty.seleccionarPorNumero(numero);
	}

	@Override
	public void guardar(Factura factura) {
		// TODO Auto-generated method stub
		this.iFacturaRepositoty.insertar(factura);

	}

}
