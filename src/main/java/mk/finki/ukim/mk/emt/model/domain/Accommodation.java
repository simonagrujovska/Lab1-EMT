package mk.finki.ukim.mk.emt.model.domain;

import jakarta.persistence.*;
import lombok.Data;
import mk.finki.ukim.mk.emt.model.enumeration.CategoryEnum;

@Data
@Entity
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    @ManyToOne
    private Host host;

    private int numRooms;
    private boolean rented;


    public Accommodation() {}

    public Accommodation(Long id, String name, CategoryEnum category, Host host, int numRooms) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
        this.rented = false;

    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
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

    public int getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(int numRooms) {
        this.numRooms = numRooms;
    }
}
