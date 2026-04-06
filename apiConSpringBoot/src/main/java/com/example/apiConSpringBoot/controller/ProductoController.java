package com.example.apiConSpringBoot.controller;

import com.example.apiConSpringBoot.dto.ProductoDTO;
import com.example.apiConSpringBoot.service.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/productos")
public class ProductoController {


    private final IProductoService productoServi;



    @GetMapping
    public ResponseEntity <List<ProductoDTO>> obtenerProductos(){

        return ResponseEntity.ok(productoServi.traerProducto());

    }

    @PostMapping
    public ResponseEntity <ProductoDTO> crearProductos(@RequestBody ProductoDTO productodto){

       ProductoDTO creado = productoServi.crearProducto(productodto);

       return ResponseEntity.created(URI.create("/api/productos" + creado.getId())).body(creado);

    }

    @PutMapping("/{id}")
    public ResponseEntity <ProductoDTO> actualizarProducto(@PathVariable Long id, @RequestBody ProductoDTO productodto ){

           return  ResponseEntity.ok(productoServi.actualizarProducto(id,productodto));


    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarProducto(@PathVariable Long id){

        productoServi.eliminarProducto(id);

        return ResponseEntity.ok().build();


    }











}
