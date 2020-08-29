package be.vdab.muziek.repositories;

import be.vdab.muziek.domain.Album;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
@Sql({"/insertArtist.sql", "/insertAlbum.sql", "/insertTrack.sql"})
@Import(JpaAlbumRepository.class)
class JpaAlbumRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private static final String ALBUMS = "albums";
    private JpaAlbumRepository repository;
    private EntityManager manager;

    public JpaAlbumRepositoryTest(JpaAlbumRepository repository, EntityManager manager) {
        this.repository = repository;
        this.manager = manager;
    }
    private int idVanTestAlbum() {
        return super.jdbcTemplate.queryForObject(
                "select id from albums where naam = 'test'", Integer.class);
    }
    @Test
    void findAll() {
        assertThat(repository.findAll()).hasSize(super.countRowsInTable(ALBUMS))
                .extracting(Album::getNaam).isSorted();
    }
    @Test
    void findById(){
        assertThat(repository.findById(idVanTestAlbum()).get().getNaam()).isEqualTo("test");
    }

    @Test
    @DisplayName("geen record voor id =  -1")
    void findByIdOnbestandeId(){
        assertThat(repository.findById(-1)).isNotPresent();
    }

    @Test
    void scoreOpslag() {
        assertThat(repository.update(idVanTestAlbum(),5))
                .isEqualTo(super.countRowsInTableWhere(ALBUMS,"score=5"));
        assertThat(super.jdbcTemplate.queryForObject(
                "select score from albums where id=?", Integer.class,
                idVanTestAlbum()))
                .isEqualByComparingTo(5);
    }
}
