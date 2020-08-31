package be.vdab.muziek.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class TrackTest {
   /* private Album album1;
    private Album album2;
    private Track track1;
    private Track track2;

    @BeforeEach
    void beforeEach() {
        var artist = new Artist("test");
        album1 = new Album("test", 0, artist);
        album2 = new Album("test2", 0, artist);
        track1 = new Track("test", LocalTime.of(0, 0, 0));
        track2 = new Track("test", LocalTime.of(0, 0, 0));
    }

    @Test
    @DisplayName("album 1 is van track 1")
    void trackAlbum() {
        assertThat(album1.getTracks()).containsOnly(track1);
        assertThat(album2.getTracks()).isEmpty();
    }
    @Test
    void track2NaarAlbum1() {
        track2.setAlbum(album2);
        assertThat(album2.getTracks()).containsOnly(track2);
        assertThat(track2.getAlbum()).isEqualTo(album2);

    }

    @Test
    @DisplayName("null album toekenen mislukt")
    void nullAlbum() {
        assertThatNullPointerException().isThrownBy(()->track1.setAlbum(null));
    }*/
}
