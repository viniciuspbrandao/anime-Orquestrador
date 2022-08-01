package com.orquestradoranime.application.mapper;

import com.orquestradoranime.application.presentation.representation.AnimeRequestRepresentation;
import com.orquestradoranime.application.presentation.representation.AnimeResponseRepresentation;
import com.orquestradoranime.domain.domain.Anime;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@UtilityClass
public class AnimeMapper {

    private Supplier<ModelMapper> modelMapperSupplier = ModelMapper::new;


    public Anime toDomain(AnimeRequestRepresentation representation) {
        return modelMapperSupplier.get().map(representation, Anime.class);
    }

    public AnimeResponseRepresentation paraRepresentacao(Anime anime){
        return modelMapperSupplier.get().map(anime, AnimeResponseRepresentation.class);
    }

    public List<AnimeResponseRepresentation> toAnimeResponseRepresentationList(List<Anime> animeList) {
        List<AnimeResponseRepresentation> animeRepresentationList = new ArrayList<>();


        animeList.forEach(anime -> {
            animeRepresentationList.add(paraRepresentacao(anime));
        });

        return animeRepresentationList;
    }

}
