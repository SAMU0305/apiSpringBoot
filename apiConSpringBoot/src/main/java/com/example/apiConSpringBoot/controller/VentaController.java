package com.example.apiConSpringBoot.controller;


import com.example.apiConSpringBoot.dto.VentaDTO;
import com.example.apiConSpringBoot.service.IVentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ventas")
public class VentaController {


    private IVentaService ventaServi;


    @GetMapping
    public ResponseEntity<List<VentaDTO>> obtenerVentas(){

        return ResponseEntity.ok(ventaServi.traerVenta());

    }

    @PostMapping
    public ResponseEntity <VentaDTO> crearVenta(@RequestBody VentaDTO ventadto){

        VentaDTO creado = ventaServi.crearVenta(ventadto);

        return ResponseEntity.created(URI.create("/api/ventas" + creado.getId())).body(creado);

    }

    @PutMapping("/{id}")
    public ResponseEntity <VentaDTO> actualizarSucursal(@PathVariable Long id, @RequestBody VentaDTO ventadto ){

        return  ResponseEntity.ok(ventaServi.actualizarVenta(id,ventadto));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarVenta(@PathVariable Long id){

        ventaServi.eliminarVenta(id);

        return ResponseEntity.ok().build();


    }





}
