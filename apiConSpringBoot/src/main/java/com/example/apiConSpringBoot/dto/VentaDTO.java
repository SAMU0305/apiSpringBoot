package com.example.apiConSpringBoot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VentaDTO {

    private Long id;

    private LocalDate fecha;
    private String estado;

    private Long idSucursal;

    List<DetalleVentaDTO> detalle;

    // SOLO para mostrar, no se envía en el request.
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double total;
}
