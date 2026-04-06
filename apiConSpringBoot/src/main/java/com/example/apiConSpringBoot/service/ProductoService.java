package com.example.apiConSpringBoot.service;

import com.example.apiConSpringBoot.dto.ProductoDTO;
import com.example.apiConSpringBoot.exception.NotFoundException;
import com.example.apiConSpringBoot.mapper.Mapper;
import com.example.apiConSpringBoot.model.Producto;
import com.example.apiConSpringBoot.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService implements IProductoService {


    private final ProductoRepository repo;


    @Override
    public List<ProductoDTO> traerProducto() {

        return repo.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public ProductoDTO crearProducto(ProductoDTO productodto) {

        Producto produc = Producto.builder()
                .nombre(productodto.getNombre())
                .categoria(productodto.getCategoria())
                .precio(productodto.getPrecio())
                .stock(productodto.getStock())
                .build();
        return Mapper.toDTO(repo.save(produc));


    }

    @Override
    public ProductoDTO actualizarProducto(Long id, ProductoDTO productodto) {

        Producto produc = repo.findById(id)
        .orElseThrow(() -> new NotFoundException("Producto no encontrado"));

        produc.setNombre(productodto.getNombre());
        produc.setCategoria(productodto.getCategoria());
        produc.setPrecio(productodto.getPrecio());
        produc.setStock(productodto.getStock());

        return Mapper.toDTO(repo.save(produc));
    }

    @Override
    public void eliminarProducto(Long id) {

        if(!repo.existsById(id)){

            throw new NotFoundException("Producto no encontrado para eliminar");

        }

        repo.deleteById(id);

    }
}
