package com.orquestradoranime.application.presentation.representation.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoGeneroRepresentation {

    SHOUJO("Shoujo"),
    SEINEN("Seinen"),
    JOSEI("Josei"),
    HAREM("Harem"),
    ISEKAI("Isekai"),
    MECHA("Mecha");

    private final String tipo;

}