package com.example.apiConSpringBoot.repository;

import com.example.apiConSpringBoot.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Long> {
}
