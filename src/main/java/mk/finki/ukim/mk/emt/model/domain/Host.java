package mk.finki.ukim.mk.emt.model.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;

    @ManyToOne
    private Country country;

    public Host( Long id, String name, String surname,Country country) {

        this.id = id;
        this.name = name;
        this.surname = surname;
        this.country = country;
    }

    public Host( String name, String surname,Country country) {

        this.name = name;
        this.surname = surname;
        this.country = country;
    }
    public Host() {}

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
