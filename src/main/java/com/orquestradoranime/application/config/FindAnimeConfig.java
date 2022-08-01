package com.orquestradoranime.application.config;

import com.orquestradoranime.domain.camel.CamelContextWrapper;
import com.orquestradoranime.domain.camel.route.AnimeRouter;
import com.orquestradoranime.domain.port.AnimeRepository;
import com.orquestradoranime.domain.service.AnimeService;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class FindAnimeConfig {

  //bean pra acessar o endpoint do atomico
  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  //camel vai fazer a rota
  @Bean
  public CamelContextWrapper camelContextWrapper(RouteBuilder... routes) throws Exception {
    return new CamelContextWrapper(routes);
  }

  //router chama a implementação
  @Bean
  public AnimeRouter animeRouter(AnimeRepository animeRepository) {
    return new AnimeRouter(animeRepository);
  }

  //service
  @Bean
  public AnimeService animeService(CamelContextWrapper wrapper) {
    return new AnimeService(wrapper);
  }

}













