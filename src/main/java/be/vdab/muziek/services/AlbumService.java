package be.vdab.muziek.services;

import be.vdab.muziek.domain.Album;

import java.util.List;
import java.util.Optional;

public interface AlbumService {
    List<Album> findAll();
    Optional<Album> findById(int id);
    void update(int id,int score);
}
