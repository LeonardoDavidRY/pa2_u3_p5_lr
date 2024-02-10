package com.uce.edu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.repository.modelo.DetalleFactura;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;
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
		// Taller 31
		
		//System.out.println("Prueba supports: "+TransactionSynchronizationManager.isActualTransactionActive());
		
		//this.iFacturaService.pruebaSupports();
		//this.iFacturaService.pruebaNever();
		
		
	}
	

}
