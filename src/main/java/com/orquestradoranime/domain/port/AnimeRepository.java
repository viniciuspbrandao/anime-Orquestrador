package com.orquestradoranime.domain.port;


import com.orquestradoranime.domain.domain.Anime;

import java.util.List;

public interface AnimeRepository {

    List<Anime> listarAnimes();

    Anime findAnimeById(Long id);

    Anime inserirNovoAnime(Anime anime);

    Anime atualizarAnime(Anime anime);

    void deletarAnime(Long id);
}
