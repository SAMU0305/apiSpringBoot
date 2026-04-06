package com.example.apiConSpringBoot.service;

import com.example.apiConSpringBoot.dto.DetalleVentaDTO;
import com.example.apiConSpringBoot.dto.VentaDTO;
import com.example.apiConSpringBoot.exception.NotFoundException;
import com.example.apiConSpringBoot.mapper.Mapper;
import com.example.apiConSpringBoot.model.DetalleVenta;
import com.example.apiConSpringBoot.model.Producto;
import com.example.apiConSpringBoot.model.Sucursal;
import com.example.apiConSpringBoot.model.Venta;
import com.example.apiConSpringBoot.repository.ProductoRepository;
import com.example.apiConSpringBoot.repository.SucursalRepository;
import com.example.apiConSpringBoot.repository.VentaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class VentaService implements  IVentaService {


    private final VentaRepository repoV;

    private final  ProductoRepository repoP;

    private final SucursalRepository repoS;


    @Override
    public List<VentaDTO> traerVenta() {

        List<Venta> ventas = repoV.findAll();
        List<VentaDTO> ventasDto = new ArrayList<>();
        VentaDTO ventaDto;

        for(Venta v : ventas){

            ventaDto = Mapper.toDTO(v);
            ventasDto.add(ventaDto);
        }

        return ventasDto;
    }



    @Override
    public VentaDTO crearVenta(VentaDTO ventadto) {

        if(ventadto == null) throw new RuntimeException("ventaDTO es nulo");
        if(ventadto.getIdSucursal() == null ) throw new RuntimeException("debe indicar la sucursal");
        if(ventadto.getDetalle() == null || ventadto.getDetalle().isEmpty()) throw new RuntimeException("debe incluir al menos un producto");

        Sucursal sucu= repoS.findById(ventadto.getIdSucursal()).orElse(null);

        if(sucu == null){
            throw new NotFoundException("sucursal no encontrada");
        }

        Venta vent = new Venta();

        vent.setFecha(ventadto.getFecha());
        vent.setEstado(ventadto.getEstado());
        vent.setSucursal(sucu);

        List<DetalleVenta> detalle = new ArrayList<>();

        for ( DetalleVentaDTO detalleVentaDto : ventadto.getDetalle() ){

            Producto p = repoP.findByNombre(detalleVentaDto.getNombreProducto()).orElse(null);

            if(p == null){

                throw new NotFoundException("producto no encontrado: " + detalleVentaDto.getNombreProducto());

            }

            DetalleVenta detalleV = new DetalleVenta();

            detalleV.setProducto(p);
            detalleV.setPrecio(detalleVentaDto.getPrecio());
            detalleV.setCantidadProductos(detalleVentaDto.getCantidadProducto());
            detalleV.setVenta(vent);


            detalle.add(detalleV);

        }

        vent.setDetalle(detalle);

        double total = detalle.stream()
                .mapToDouble(d -> d.getPrecio() * d.getCantidadProductos())
                .sum();

        vent.setTotal(total);


        return Mapper.toDTO(repoV.save(vent));



    }

    @Override
    public VentaDTO actualizarVenta(Long id, VentaDTO ventadto) {

        Venta v = repoV.findById(id).orElse(null);
        if (v == null ){
            throw new RuntimeException("vena no encontrada");
        }

        if (ventadto.getFecha() != null){

            v.setFecha(ventadto.getFecha());
        }

        if (ventadto.getEstado() != null){

            v.setEstado(ventadto.getEstado());
        }

        if (ventadto.getIdSucursal() != null){

            Sucursal sucu = repoS.findById(ventadto.getIdSucursal()).orElse(null);

            if (sucu == null){

                throw  new NotFoundException("no se encontro la sucursal");
            }

            v.setSucursal(sucu);

        }

        if (ventadto.getTotal() != null){

            v.setTotal(ventadto.getTotal());
        }

        repoV.save(v);

        return Mapper.toDTO(v);


    }

    @Override
    public void eliminarVenta(Long id) {

        Venta v = repoV.findById(id).orElse(null);
        if (v == null ){
            throw new RuntimeException("vena no encontrada");
        }
        repoV.delete(v);

    }
}
