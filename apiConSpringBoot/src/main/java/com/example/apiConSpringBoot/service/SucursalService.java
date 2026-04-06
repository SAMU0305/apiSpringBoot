package com.example.apiConSpringBoot.service;

import com.example.apiConSpringBoot.dto.SucursalDTO;
import com.example.apiConSpringBoot.exception.NotFoundException;
import com.example.apiConSpringBoot.mapper.Mapper;
import com.example.apiConSpringBoot.model.Sucursal;
import com.example.apiConSpringBoot.repository.SucursalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SucursalService implements ISucursalService {


    private final SucursalRepository repo;



    @Override
    public List<SucursalDTO> traerSucursal() {

        return repo.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public SucursalDTO crearSucursal(SucursalDTO sucursaldto) {
        Sucursal sucu = Sucursal.builder()
                .nombre(sucursaldto.getNombre())
                .direccion(sucursaldto.getDireccion())
                .build();

        return Mapper.toDTO(repo.save(sucu));
    }

    @Override
    public SucursalDTO actualizarSucursal(Long id, SucursalDTO sucursaldto) {

        Sucursal sucu = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Sucursal no encontrada"));

        sucu.setNombre(sucursaldto.getNombre());
        sucu.setDireccion(sucursaldto.getDireccion());

        return  Mapper.toDTO(repo.save(sucu));
    }

    @Override
    public void eliminarSucursal(Long id) {

        if(!repo.existsById(id)){

            throw new NotFoundException("Sucursal no encontrada para eliminar");

        }

        repo.deleteById(id);

    }
}
