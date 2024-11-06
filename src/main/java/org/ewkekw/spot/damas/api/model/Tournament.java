package org.ewkekw.spot.damas.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class Tournament {
    private Long id;
    private String nome;
    private String descricao;

    @JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate data;

    @JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime horario;

    private String local;

    private Double preco;

    @JsonProperty("estado_id")
    private Long estadoId;

    @JsonProperty("cidade_id")
    private Long cidadeId;
}
