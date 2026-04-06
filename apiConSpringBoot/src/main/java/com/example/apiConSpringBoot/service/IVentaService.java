package com.example.apiConSpringBoot.service;


import com.example.apiConSpringBoot.dto.VentaDTO;

import java.util.List;

public interface IVentaService {

    List<VentaDTO> traerVenta();
    VentaDTO crearVenta(VentaDTO ventadto);
    VentaDTO actualizarVenta(Long id, VentaDTO ventadto);
    void eliminarVenta(Long id);
}
