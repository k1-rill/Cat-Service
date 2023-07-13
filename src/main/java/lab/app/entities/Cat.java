package lab.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cats")
public class Cat {
    @Column(name = "cat_name")
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private long id;

    @Column(name = "cat_date")
    private LocalDate date;

    @Column(name = "cat_breed")
    private String breed;

    @Column(name = "cat_color")
    private String color;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cat_owner")
    private Owner catOwner;

    @OneToMany(mappedBy = "cat", cascade = CascadeType.ALL)
    private List<Flea> fleas;
    public Cat(){

    }
    public Cat(String name, LocalDate date, String breed, String color, Owner owner){
        this.name = name;
        this.date = date;
        this.breed = breed;
        this.color = color;
        this.catOwner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setCat_id(long id){
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
