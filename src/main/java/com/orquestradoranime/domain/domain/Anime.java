package com.orquestradoranime.domain.domain;

//import com.orquestradoranime.domain.enums.TipoGenero;
//import lombok.*;
//
//@Getter
//@Setter
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//public class Anime {
//
//    private Long id;
//    private String nome;
//    private String autor;
//    private int anoPublicacao;
//    private int numeroEpisodios;
//    private String sinopse;
//    private TipoGenero tipoGenero;
//
//}



import com.fasterxml.jackson.annotation.JsonProperty;
import com.orquestradoranime.application.presentation.representation.enums.TipoGeneroRepresentation;
import com.orquestradoranime.domain.enums.TipoGenero;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Anime implements Serializable {

    private Long id;
    private String nome;
    private String autor;
    private Integer publicacao;
    private Integer numeroEpisodios;
    private TipoGenero tipoGenero;
    private String sinopse;

}
