package com.example.apiConSpringBoot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class DetalleVentaDTO {

    private Long id;
    private String nombreProducto;
    private  Integer cantidadProducto;
    private Double precio;
    // SOLO para mostrar, el subtotal se calcula y se muestra no se guarda en base de datos.
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double subTotal;
}
