package com.example.apiConSpringBoot.service;

import com.example.apiConSpringBoot.dto.SucursalDTO;

import java.util.List;

public interface ISucursalService {

    List<SucursalDTO> traerSucursal();
    SucursalDTO crearSucursal(SucursalDTO sucursaldto);
    SucursalDTO actualizarSucursal(Long id, SucursalDTO sucursaldto);
    void eliminarSucursal(Long id);

}
