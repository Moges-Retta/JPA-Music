package be.vdab.muziek.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.*;

public class AlbumTest {
    private Album album1;
    private Album album2;
    private Track track1;
    private Track track2;

    @BeforeEach
    void beforeEach() {
        var artist = new Artist("test");
        album1 = new Album("test", 0, artist);
        album2 = new Album("test2", 0, artist);
        track1 = new Track("test", LocalTime.of(0, 0, 0));
        track2 = new Track("test2", LocalTime.of(1, 0, 0));
        album1.add(track1);
    }

    @Test
    @DisplayName("track1 is van album 1")
    void trackAlbum() {
        //assertThat(track1.getAlbum()).isEqualTo(album1);
        assertThat(album1.getTracks()).containsOnly(track1);
    }

    @Test
    void track2NaarAlbum1() {
        assertThat(album2.add(track2)).isTrue();
        assertThat(album2.getTracks()).containsOnly(track2);
    }
    @Test
    @DisplayName("merdere tracks kunnen tot dezelfde album behoren")
    void meerdereTracks() {
        assertThat(album2.getTracks()).isEmpty();
        assertThat(album2.add(track1)).isTrue();
        assertThat(album2.add(track2)).isTrue();
        assertThat(album2.getTracks()).containsOnly(track1, track2);
    }
    @Test
    @DisplayName("null track toovoegen mislukt")
    void nullTrack() {
        assertThat(album1.add(null)).isFalse();
        //assertThatNullPointerException().isThrownBy(() -> album1.add(null));
    }

    @Test
    @DisplayName("Total time van track 1 en track 2 is 1:00:00")
    void totaalTijd(){
        album2.add(track1);
        album2.add(track2);
        assertThat(album2.totalTime()).isEqualTo(LocalTime.of(1,0,0));
    }
    @Test
    void updateScore(){
        album1.updateScore(5);
        assertThat(album1.getScore()).isEqualTo(5);
    }
    @Test
    void updateScoreIllegal(){
        assertThatIllegalArgumentException().isThrownBy(()->album1.updateScore(-1));
    }
}
