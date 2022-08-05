package com.orquestradoranime.application.listener;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
@Slf4j
public class AnimeListener {

    public static final String ANIME = "anime.save";

    public void listen(String payLoad) {
        try {

        } catch (Throwable e) {
            log.error("Erro", e);
        }
    }
}





