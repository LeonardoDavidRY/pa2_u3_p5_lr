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
	
	//Join Types en Jakarta Persistence
	//1.JOIN
	// 1.1- INNER JOIN
	// 1.2- OUTER JOIN
	//   1.2.1) JOIN RIGHT
    //   1.2.2) JOIN LEFT
    //   1.2.3) JOIN FULL
	//2.JOIN WHERE
	//3.FETCH JOIN

	
	@Autowired
	private IFacturaService iFacturaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5LrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("INNER JOIN");
		List<Factura> Facturas1 = this.iFacturaService.buscarFacturasInnerJoin();
		for (Factura factura : Facturas1) {
			System.out.println(factura);
		}
		
		System.out.println("RIGHT JOIN");
		List<Factura> Facturas2 = this.iFacturaService.buscarFacturasRightJoin();
		for (Factura factura : Facturas2) {
			System.out.println(factura.getNumero());
		}
		
		System.out.println("LEFT JOIN");
		List<Factura> Facturas3 = this.iFacturaService.buscarFacturasLeftJoin();
		for (Factura factura : Facturas3) {
			System.out.println(factura);
		}
		System.out.println("FULL JOIN");
		List<Factura> Facturas4 = this.iFacturaService.buscarFacturasFullJoin();
		for (Factura factura : Facturas4) {
			System.out.println(factura);
			for(DetalleFactura detalleFactura : factura.getDetalleFacturas()) {
				System.out.println(detalleFactura);
			}
		}
		
	}

}
