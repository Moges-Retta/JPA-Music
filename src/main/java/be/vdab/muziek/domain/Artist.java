package be.vdab.muziek.domain;

import javax.persistence.*;

@Entity
@Table(name = "artiesten")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    private String naam;

    public Artist(String naam) {
        this.naam = naam;
    }
    protected Artist(){}

    public String getNaam() {
        return naam;
    }

    public int getId() {
        return id;
    }
}
