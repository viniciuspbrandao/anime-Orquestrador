package com.orquestradoranime.domain.enums;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoGenero {

    SHOUJO("Shoujo"),
    SEINEN("Seinen"),
    JOSEI("Josei"),
    HAREM("Harem"),
    ISEKAI("Isekai"),
    MECHA("Mecha");

    private final String type;
}
