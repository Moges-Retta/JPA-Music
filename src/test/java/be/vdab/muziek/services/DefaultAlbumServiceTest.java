package be.vdab.muziek.services;

import be.vdab.muziek.domain.Album;
import be.vdab.muziek.domain.Artist;
import be.vdab.muziek.exceptions.AlbumNietGevondenException;
import be.vdab.muziek.repositories.AlbumRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DefaultAlbumServiceTest {
    private AlbumService albumService;
    @Mock
    private AlbumRepository repository;
    private Album album;

    @BeforeEach
    void beforeEach(){
        album = new Album("test",0,new Artist("test"));
        albumService = new DefaultAlbumService(repository);
    }
    @Test
    void updateScore(){
        when(repository.findById(1)).thenReturn(Optional.of(album));
        albumService.update(1,5);
        assertThat(album.getScore()).isEqualTo(5);
        verify(repository).findById(1);

    }
    @Test
    void opslagVoorOnbestaandeDocent() {
        assertThatExceptionOfType(AlbumNietGevondenException.class)
                .isThrownBy(()->albumService.update(-1, 0));
        verify(repository).findById(-1);
    }
}