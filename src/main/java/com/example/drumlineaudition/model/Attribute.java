package com.example.drumlineaudition.model;

public class Attribute {
    private String name;
    private Long id;

    Attribute() {
    }

    public Attribute (String name) {
        this.name = name;
    }

    public String getName () {
        return this.name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
