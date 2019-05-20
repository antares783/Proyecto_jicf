package com.telcel.gam.siev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telcel.gam.siev.modelo.TcSafinCanales;

@Repository
public interface TcSafinCanalesRepository extends JpaRepository<TcSafinCanales, Long>{

}
