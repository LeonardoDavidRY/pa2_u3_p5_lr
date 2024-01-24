package com.uce.edu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ventas.repository.modelo.DetalleFactura;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5LrApplication implements CommandLineRunner {

	
	@Autowired
	private IFacturaService iFacturaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5LrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Factura factura = new Factura();
		factura.setCedula("456456");
		factura.setFecha(LocalDateTime.now());
		factura.setNumero("0001-02569");
		
		DetalleFactura det1 = new DetalleFactura();
		det1.setCantidad(4);
		det1.setCodigoBarras("54556875");
		det1.setFactura(factura);
		det1.setNombreProducto("Coca Cola");
		
		DetalleFactura det2 = new DetalleFactura();
		det2.setCantidad(2);
		det2.setCodigoBarras("78542");
		det2.setFactura(factura);
		det2.setNombreProducto("Leche Vita");
		
		List<DetalleFactura> detalleFacturas = new ArrayList<>();
		detalleFacturas.add(det1);
		detalleFacturas.add(det2);
		factura.setDetalleFacturas(detalleFacturas);
		
		//this.iFacturaService.guardar(factura);
		
		Factura fact1 = this.iFacturaService.buscarPorNumero("0001-02569");
		
		for(DetalleFactura dell: fact1.getDetalleFacturas()) {
			System.out.println(dell.getCodigoBarras());
		}
		
		System.out.println(fact1);
	}

}
