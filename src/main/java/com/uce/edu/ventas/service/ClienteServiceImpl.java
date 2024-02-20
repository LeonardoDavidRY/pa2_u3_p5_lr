package com.uce.edu.ventas.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.ventas.repository.IClienteRepository;
import com.uce.edu.ventas.repository.modelo.Cliente;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepository iClienteRepository;
	@Override
	@Transactional(value = TxType.REQUIRES_NEW) //T2
	//begin
	public void guardar(Cliente cliente) {
		// TODO Auto-generated method stub
		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());
		try {
		this.iClienteRepository.insertar(cliente);
		TimeUnit.SECONDS.sleep(1);
		}catch(RuntimeException e) {
			System.out.println(e.getClass());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	@Transactional(value=TxType.SUPPORTS)
	public void pruebaSupports() {
		// TODO Auto-generated method stub
		System.out.println("Este es un metodo Supports");
		System.out.println("Prueba supports: "+TransactionSynchronizationManager.isActualTransactionActive());
		
		
	}
	@Override
	@Transactional(value=TxType.NEVER)
	public void pruebaNever() {
		// TODO Auto-generated method stub
		System.out.println("Este es un metodo Never");
		System.out.println("Prueba Never: "+TransactionSynchronizationManager.isActualTransactionActive());
		
	}

}
