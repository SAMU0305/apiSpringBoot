package com.example.apiConSpringBoot.service;

import com.example.apiConSpringBoot.dto.ProductoDTO;
import com.example.apiConSpringBoot.model.Producto;


import java.util.List;

public interface IProductoService {

    List<ProductoDTO> traerProducto();
    ProductoDTO crearProducto(ProductoDTO productodto);
    ProductoDTO actualizarProducto(Long id, ProductoDTO productodto);
    void eliminarProducto(Long id);
}
