package com.orquestradoranime.domain.service;

import com.orquestradoranime.domain.camel.CamelContextWrapper;
import com.orquestradoranime.domain.camel.route.AnimeRouter;
import com.orquestradoranime.domain.domain.Anime;
import org.apache.camel.ProducerTemplate;

import java.util.List;


public class AnimeService {
    private final ProducerTemplate template;

    public AnimeService(CamelContextWrapper wrapper) {
        this.template = wrapper.createProducerTemplate();
    }
    public List<Anime> listarAnimes() {

        return template.requestBody(AnimeRouter.ROUTE_URI, null, List.class);
    }

    public Anime findAnimeById(Long id) {
        return template.requestBody(AnimeRouter.ROUTE_URI_BY_ID, id, Anime.class);
    }

    public Anime inserirNovoAnime(Anime anime) {
        return template.requestBody(AnimeRouter.ROUTE_URI_SAVE, anime, Anime.class);
    }

    public Anime atualizarAnime(Long id, Anime anime) {
        anime.setId(id);
        return template.requestBody(AnimeRouter.ROUTE_URI_UPDATE, anime, Anime.class);
    }

    public void deletarAnime(Long id) {
        template.sendBody(AnimeRouter.ROUTE_URI_DELETE, id);
    }
}









