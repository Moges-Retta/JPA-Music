package be.vdab.muziek.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

@Embeddable
@Access(AccessType.FIELD)
public class Track {
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int albumid;*/

    private String naam;
    private LocalTime tijd;

    public Track(String naam,LocalTime tijd) {
        this.naam = naam;
        this.tijd = tijd;
    }
    protected Track(){}

    public LocalTime getTijd() {
        return tijd;
    }

    public String getNaam() {
        return naam;
    }

    /*public void setAlbum(Album album) {
        if (!album.getTracks().contains(this)) {
            album.add(this);
        }
        this.album = album;
    }

    public Album getAlbum() {
        return album;
    }*/

    /*public int getAlbumid() {
        return albumid;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Track)) return false;
        Track track = (Track) o;
        return naam.equals(track.naam) &&
                tijd.equals(track.tijd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam, tijd);
    }
}
