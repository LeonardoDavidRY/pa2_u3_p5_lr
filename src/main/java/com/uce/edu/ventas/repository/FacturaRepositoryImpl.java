package com.uce.edu.ventas.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepositoty {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Factura seleccionarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f WHERE f.numero = :numero",Factura.class);
		myQuery.setParameter("numero", numero);
		Factura fact= myQuery.getSingleResult();
		fact.getDetalleFacturas().size(); // carga el detalle bajo demanda
		return fact;
	}

	@Override
	@Transactional(value=TxType.MANDATORY)
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);

	}

	@Override
	public List<Factura> seleccionarFacturasInnerJoin() {
		// TODO Auto-generated method stub
		//SQL: SELECT * FROM factura f inner join detalle_factura d 
		//     on f.fact_id = d.defa_id_factura
		
		//JPQL: SELECT f, d FROM Factura f INNER JOIN f.detalleFacturas d
		//JPQL: SELECT f FROM Factura f JOIN f.detalleFacturas d
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f JOIN f.detalleFacturas d", Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for(Factura f:lista) {
			f.getDetalleFacturas().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasRightJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f RIGHT JOIN f.detalleFacturas d", Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for(Factura f:lista) {
			f.getDetalleFacturas().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasLeftJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f LEFT JOIN f.detalleFacturas d", Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for(Factura f:lista) {
			f.getDetalleFacturas().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasFullJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f FULL JOIN f.detalleFacturas d", Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for(Factura f:lista) {
			f.getDetalleFacturas().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasWhereJoin() {
		// TODO Auto-generated method stub
		// SQL: SELECT f.* FROM factura f, detalle_factura d WHERE f.fact_id = d.defa_id_factura
		// JPQL: SELECT f FROM Factura f, DetalleFactura d WHERE f.id = d.factura.id
		// short version: WHERE f = d.factura
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f, DetalleFactura d WHERE f = d.factura", Factura.class);
		
		List<Factura> lista = myQuery.getResultList();
		for(Factura f:lista) {
			f.getDetalleFacturas().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasFetchJoin() {
		// TODO Auto-generated method stub
		//SELECT f from Factura f JOIN FETCH f.detalleFactura d
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f from Factura f JOIN FETCH f.detalleFacturas d", Factura.class);
		
		return myQuery.getResultList();
	}

	@Override
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.merge(factura);
		
		
	}

	@Override
	public int actualizarfechas(LocalDateTime fechaNueva, LocalDateTime fechaActual) {
		// TODO Auto-generated method stub
		// select * from factura where fecha >= fechaActual
		//Lista
		//Recorrer por cada fecha del select la nueva fecha
		//Actualizar factura
		// SQL: UPDATE factura set fact_fecha =: fechaNueva WHERE fact fecha >= fechaActual
		// JPQL: UPDATE Factura f SET f.fecha =: fechaNueva WHERE f.fecha >= :fechaActual
		Query myQuery = this.entityManager.createQuery("UPDATE Factura f SET f.fecha =: fechaNueva WHERE f.fecha >= :fechaActual");
		myQuery.setParameter("fechaNueva", fechaNueva);
		myQuery.setParameter("fechaActual", fechaActual);
		return myQuery.executeUpdate(); // cantidad de registros actulizados
		
	}
	@Transactional(value=TxType.NOT_SUPPORTED)
	public Factura buscar(Integer id) {
		return this.entityManager.find(Factura.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		 
		this.entityManager.remove(this.buscar(id));
		
	}

	@Override
	public int eliminarPorNumero(String numero) {
		// TODO Auto-generated method stub
		// SQL: DELETE FROM factura WHERE fact_numero = :numero
		// JPQL: DELETE FROM Factura f WHERE f.numero = :numero
		Query myQuery = this.entityManager.createQuery("DELETE FROM Factura f WHERE f.numero = :numero");
		myQuery.setParameter("numero", numero);
		return myQuery.executeUpdate();
		
		
	}

	@Override
	public List<FacturaDTO> seleccionarFacturaDTO() {
		// TODO Auto-generated method stub
		
		TypedQuery<FacturaDTO> myQuery = this.entityManager.createQuery
				("SELECT NEW com.uce.edu.ventas.repository.modelo.dto.FacturaDTO(f.numero,f.fecha) FROM Factura f ", FacturaDTO.class);

		return myQuery.getResultList();
	}

}
