package com.telcel.gam.siev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.telcel.gam.siev.modelo.TtWsLlamadaRespuesta;

public interface TtWsLlamadaRespuestaRepository extends JpaRepository<TtWsLlamadaRespuesta, Integer> {

	 @Query(value = "SELECT NEXT VALUE FOR SEQUENCE_TT_WS_LLAMADA_RESPUESTA", nativeQuery = true)
	 Integer getNextSeriesId();
	
}
