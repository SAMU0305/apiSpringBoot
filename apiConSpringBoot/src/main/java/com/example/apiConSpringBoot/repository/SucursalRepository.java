package com.example.apiConSpringBoot.repository;

import  com.example.apiConSpringBoot.model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SucursalRepository  extends JpaRepository<Sucursal, Long> {

}
