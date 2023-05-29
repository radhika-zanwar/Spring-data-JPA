package com.radhika.springdata.associations.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<PhoneNumber> numbers;

    public Set<PhoneNumber> getNumbers() {
        return numbers;
    }

    public void setNumbers(Set<PhoneNumber> numbers) {
        this.numbers = numbers;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
