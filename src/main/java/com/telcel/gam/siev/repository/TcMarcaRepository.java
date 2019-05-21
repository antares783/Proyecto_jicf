package com.telcel.gam.siev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.telcel.gam.siev.modelo.TcMarca;

public interface TcMarcaRepository extends JpaRepository<TcMarca, Short>{

	@Query("SELECT t FROM TcMarca t WHERE t.dispoDeur = :dispoDeur")
	List<TcMarca> findByParams(@Param("dispoDeur") Character dispoDeur);
}
