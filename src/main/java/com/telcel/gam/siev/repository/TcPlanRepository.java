package com.telcel.gam.siev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.telcel.gam.siev.modelo.TcPlan;
import com.telcel.gam.siev.modelo.TcTipoPlan;
import com.telcel.gam.siev.modelo.TcTipoPlazo;

public interface TcPlanRepository extends JpaRepository<TcPlan, Integer>{

	@Query("Select planes from TcPlan planes, TcTipoPlan tipoPlan, TcTipoPlazo tipoPlazo where planes.tipoPlan = :tipoPlan and planes.tipoPlazo = :tipoPlazo and planes.dispoDeur = :dispoDeur")
	public List<TcPlan> findByTipoPlanTipoPlazo(TcTipoPlan tipoPlan, TcTipoPlazo tipoPlazo, Character dispoDeur );
	
}
