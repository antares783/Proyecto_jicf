package com.telcel.gam.siev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telcel.gam.siev.modelo.TcCredcheckEstados;

@Repository
public interface TcCredcheckEstadosRepository extends JpaRepository<TcCredcheckEstados,String> {

}
