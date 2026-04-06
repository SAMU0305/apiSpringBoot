package com.example.apiConSpringBoot.mapper;
import com.example.apiConSpringBoot.dto.DetalleVentaDTO;
import com.example.apiConSpringBoot.dto.ProductoDTO;
import com.example.apiConSpringBoot.dto.SucursalDTO;
import com.example.apiConSpringBoot.dto.VentaDTO;
import com.example.apiConSpringBoot.model.Producto;
import com.example.apiConSpringBoot.model.Sucursal;
import com.example.apiConSpringBoot.model.Venta;


import java.util.stream.Collectors;

public class Mapper  {

    public static ProductoDTO toDTO(Producto p){

        if( p == null){

            return null;
        }

        return ProductoDTO.builder()
                .id(p.getId())
                .nombre(p.getNombre())
                .categoria(p.getCategoria())
                .precio(p.getPrecio())
                .stock(p.getStock())
                .build();

    }

    public static SucursalDTO toDTO(Sucursal s){

        if( s == null){

            return null;
        }

        return SucursalDTO.builder()
                .id(s.getId())
                .nombre(s.getNombre())
                .direccion(s.getDireccion())
                .build();

    }

    public static VentaDTO toDTO(Venta v){

        if( v == null){

            return null;
        }

        var detalle = v.getDetalle().stream().map(det ->
                DetalleVentaDTO.builder()
                        .id(det.getId())
                        .nombreProducto(det.getProducto().getNombre())
                        .cantidadProducto(det.getCantidadProductos())
                        .precio(det.getPrecio())
                        .subTotal(det.getPrecio() * det.getCantidadProductos())
                        .build()).collect(Collectors.toList());


        return VentaDTO.builder()
                .id(v.getId())
                .fecha(v.getFecha())
                .idSucursal(v.getSucursal().getId() )
                .estado(v.getEstado())
                .detalle(detalle)
                .total(v.getTotal())
                .build();



    }
}
