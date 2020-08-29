package be.vdab.muziek.repositories;

import be.vdab.muziek.domain.Album;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaAlbumRepository implements AlbumRepository {
    private EntityManager manager;

    public JpaAlbumRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public List<Album> findAll() {
        return manager.createNamedQuery("Album.findAll",Album.class).getResultList();
    }

    @Override
    public Optional<Album> findById(int id) {
        return Optional.ofNullable(manager.find(Album.class, id));
    }

    @Override
    public int update(int id,int score) {
        return manager.createNamedQuery("Album.scoreOpslag")
        .setParameter("score",score)
        .setParameter("id",id)
        .executeUpdate();
    }
}
