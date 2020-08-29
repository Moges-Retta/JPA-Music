package be.vdab.muziek.repositories;

import be.vdab.muziek.domain.Album;

import java.util.List;

public interface MuziekRepository {
    List<Album> findAll();
    int update(int id,int score);
}
