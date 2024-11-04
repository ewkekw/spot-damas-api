package org.ewkekw.spot.damas.api.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class Tournament {
    private Long id;
    private String nome;
    private String descricao;
    private LocalDate data;
    private LocalTime horario;
    private String local;
    private Double preco;
    private Long estadoId;
    private Long cidadeId;
}
