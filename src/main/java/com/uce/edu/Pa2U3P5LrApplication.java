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
import com.uce.edu.ventas.service.IClienteService;
import com.uce.edu.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5LrApplication implements CommandLineRunner {

	// Join Types en Jakarta Persistence
	// 1.JOIN
	// 1.1- INNER JOIN
	// 1.2- OUTER JOIN
	// 1.2.1) JOIN RIGHT
	// 1.2.2) JOIN LEFT
	// 1.2.3) JOIN FULL
	// 2.JOIN WHERE
	// 3.FETCH JOIN

	@Autowired
	private IClienteService iClienteService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5LrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());
		long tiempoInicial = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			Cliente cliente = new Cliente();
			cliente.setNombre("CN" + i);
			cliente.setApellido("CA" + i);
			iClienteService.guardar(cliente);
		}
		long tiempoFinal = System.currentTimeMillis();

		long tiempoTotal = (tiempoFinal - tiempoInicial) / 1000;
		System.out.println("Tiempo Total: " + tiempoTotal);
		*/
		//Tiempo  transcurrido en 10 seg
		
		//Programacion en paralelo
		
		long tiempoInicial = System.currentTimeMillis();
		List<Cliente>listaClientes = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			Cliente cliente = new Cliente();
			cliente.setNombre("CN" + i);
			cliente.setApellido("CA" + i);
			listaClientes.add(cliente);
		}
		listaClientes.parallelStream().forEach(Cliente -> this.iClienteService.guardar(Cliente));
		
		long tiempoFinal = System.currentTimeMillis();

		long tiempoTotal = (tiempoFinal - tiempoInicial) / 1000;
		System.out.println("Tiempo transcurrido en segundos: " + tiempoTotal);
	}

}
