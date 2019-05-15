package com.telcel.gam.siev.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.telcel.gam.siev.modelo.TcSafinCanales;

@Component("canal")
public interface TcSafinCanalesRepository extends JpaRepository<TcSafinCanales, Long>{

}
