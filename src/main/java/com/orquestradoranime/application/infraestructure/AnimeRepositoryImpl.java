package com.orquestradoranime.application.infraestructure;


import com.orquestradoranime.domain.domain.Anime;
import com.orquestradoranime.domain.port.AnimeRepository;

import com.orquestradoranime.domain.util.Util;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;


import java.util.List;



@Repository
public class AnimeRepositoryImpl implements AnimeRepository {
    private final RestTemplate restTemplate;
    private final RabbitTemplate rabbitTemplate;


    @Autowired
    public AnimeRepositoryImpl(RestTemplate restTemplate, RabbitTemplate rabbitTemplate) {
        this.restTemplate = restTemplate;
        this.rabbitTemplate = rabbitTemplate;
    }




    @Override
    public List<Anime> listarAnimes() {
        return List.of(restTemplate.getForEntity("http://localhost:8080/animes/listarAnimes", Anime[].class).getBody());
    }




    @Override
    public Anime findAnimeById(Long id) {
        return restTemplate.getForEntity("http://localhost:8080/animes/{id}", Anime.class, id).getBody();
    }


//    @Override
//    public Anime inserirNovoAnime(Anime anime) {
//        return restTemplate.postForEntity("http://localhost:8080/animes/salvar", anime, Anime.class).getBody();
//    }

    @Override
    public Anime inserirNovoAnime(Anime anime) {
        var animenew = restTemplate.postForEntity("http://localhost:8080/animes/salvar", anime, Anime.class).getBody();
        rabbitTemplate.convertAndSend("animes", "anime-rout", Util.toJson(animenew));
        return animenew;
    }



    @Override
    public Anime atualizarAnime(Anime anime) {
        restTemplate.put("http://localhost:8080/animes/{id}", anime, anime.getId());
        return anime;
    }

    @Override
    public void deletarAnime(Long id) {
        restTemplate.delete("http://localhost:8080/animes/{id}", id);
    }

}
















