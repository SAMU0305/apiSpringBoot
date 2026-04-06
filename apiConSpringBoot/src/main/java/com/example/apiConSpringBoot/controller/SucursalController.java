package com.example.apiConSpringBoot.controller;



import com.example.apiConSpringBoot.dto.SucursalDTO;
import com.example.apiConSpringBoot.service.ISucursalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sucursales")
public class SucursalController {


    private ISucursalService  sucursalServi;



    @GetMapping
    public ResponseEntity<List<SucursalDTO>> obtenerSucursal(){

        return ResponseEntity.ok(sucursalServi.traerSucursal());

    }

    @PostMapping
    public ResponseEntity <SucursalDTO> crearSucursal(@RequestBody SucursalDTO sucursaldto){

        SucursalDTO creado = sucursalServi.crearSucursal(sucursaldto);

        return ResponseEntity.created(URI.create("/api/sucursales" + creado.getId())).body(creado);

    }

    @PutMapping("/{id}")
    public ResponseEntity <SucursalDTO> actualizarSucursal(@PathVariable Long id, @RequestBody SucursalDTO sucursaldto ){

        return  ResponseEntity.ok(sucursalServi.actualizarSucursal(id,sucursaldto));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarSucursal(@PathVariable Long id){

        sucursalServi.eliminarSucursal(id);

        return ResponseEntity.ok().build();


    }






}
