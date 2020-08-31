package be.vdab.muziek.services;

import be.vdab.muziek.domain.Album;
import be.vdab.muziek.exceptions.AlbumNietGevondenException;
import be.vdab.muziek.repositories.AlbumRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DefaultAlbumService implements AlbumService{
    private final AlbumRepository repository;

    public DefaultAlbumService(AlbumRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Album> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Album> findById(int id) {
        return Optional.of(repository.findById(id).get());
    }

    @Override
    public void update(int id, int score) {
         repository.findById(id)
                .orElseThrow(AlbumNietGevondenException::new)
                .updateScore(score);
    }
}
