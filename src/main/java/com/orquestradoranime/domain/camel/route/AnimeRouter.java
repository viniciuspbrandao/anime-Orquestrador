package com.orquestradoranime.domain.camel.route;


import com.orquestradoranime.domain.port.AnimeRepository;
import lombok.AllArgsConstructor;
import org.apache.camel.builder.RouteBuilder;

@AllArgsConstructor
public class AnimeRouter extends RouteBuilder {
    public static final String ROUTE_URI = "direct:animeRouter";
    public static final String ROUTE_URI_BY_ID = "direct:AnimeRouterById";
    public static final String ROUTE_URI_SAVE = "direct:AnimeRouterSave";
    public static final String ROUTE_URI_UPDATE = "direct:AnimeRouterUpdate";
    public static final String ROUTE_URI_DELETE = "direct:AnimeRouterDelete";

    AnimeRepository animeRepository;

    @Override
    public void configure() {
        from(ROUTE_URI)
                .bean(animeRepository, "listarAnimes");
        from(ROUTE_URI_BY_ID)
                .bean(animeRepository, "findAnimeById"); //Deve estar errado
        from(ROUTE_URI_SAVE)
                .bean(animeRepository, "inserirNovoAnime");
        from(ROUTE_URI_UPDATE)
                .bean(animeRepository, "atualizarAnime");
        from(ROUTE_URI_DELETE)
                .bean(animeRepository, "deletarAnime");
    }
}

