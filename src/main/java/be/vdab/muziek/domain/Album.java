package be.vdab.muziek.domain;

import javax.persistence.*;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    private String naam;
    private int score;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "artiestid")
    private Artist artist;
    @OneToMany(mappedBy = "album")
    private Set<Track> tracks;
    public Album(String naam, int score, Artist artist) {
        this.naam = naam;
        this.score = score;
        setArtist(artist);
        this.tracks = new LinkedHashSet<>();
    }
    protected Album(){}

    public String getNaam() {
        return naam;
    }

    public int getScore() {
        return score;
    }
    public int getId() {
        return id;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Set<Track> getTracks() {
        return Collections.unmodifiableSet(tracks);
    }

    public Artist getArtist() {
        return artist;
    }
    public boolean add(Track track) {
        var toegevoegd = tracks.add(track);
        var oudeAlbum = track.getAlbum();
        if (oudeAlbum != null && oudeAlbum != this) {
            oudeAlbum.tracks.remove(track);
        }
        if (this != oudeAlbum) {
            track.setAlbum(this);
        }
        return toegevoegd;
    }
}
