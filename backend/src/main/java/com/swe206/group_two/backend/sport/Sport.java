package com.swe206.group_two.backend.sport;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sports")
public class Sport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sport_id", nullable = false)
    private Integer id;

    @Column(name = "sport_name", nullable = false)
    private String name;

    public Sport() {
    }

    public Sport(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Sport))
            return false;
        Sport sport = (Sport) o;
        return Objects.equals(this.id, sport.id)
                && Objects.equals(this.name, sport.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.name);
    }

    @Override
    public String toString() {
        return "Sport{"
                + "id=" + this.id + ", "
                + "name='" + this.name + "'"
                + '}';
    }
}
