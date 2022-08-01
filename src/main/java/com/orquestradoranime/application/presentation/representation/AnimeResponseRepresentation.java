package com.orquestradoranime.application.presentation.representation;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.orquestradoranime.application.presentation.representation.enums.TipoGeneroRepresentation;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AnimeResponseRepresentation {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("autor")
    private String autor;

    @JsonProperty("publicacao")
    private int publicacao;

    @JsonProperty("numeroEpisodios")
    private int numeroEpisodios;

    @JsonProperty("tipoGenero")
    private TipoGeneroRepresentation tipoGenero;

    @JsonProperty("sinopse")
    private String sinopse;

}