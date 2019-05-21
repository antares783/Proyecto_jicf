package com.telcel.gam.siev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.telcel.gam.siev.modelo.TcMarca;
import com.telcel.gam.siev.modelo.TcModelo;

public interface TcModeloRepository extends JpaRepository<TcModelo, Short> {

	@Query("Select mod from TcModelo mod, TcMarca mar where mod.dispoR9 = :dispoR9 and mod.idMarca = :marca")
	List<TcModelo> findByMarca(Character dispoR9, TcMarca marca);	
}