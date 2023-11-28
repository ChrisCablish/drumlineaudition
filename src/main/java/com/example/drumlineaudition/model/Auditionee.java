package com.example.drumlineaudition.model;
import java.util.List;
public class Auditionee {
    private Long id;
    private String name;
    private List<Attribute> strengths;
    private List<Attribute> weaknesses;
    private List<NoteEntry> notes;
    private int rating;

    public Auditionee() {
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

    public List<Attribute> getStrengths() {
        return strengths;
    }

    public void setStrengths(List<Attribute> strengths) {
        this.strengths = strengths;
    }

    public List<Attribute> getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(List<Attribute> weaknesses) {
        this.weaknesses = weaknesses;
    }

    public List<NoteEntry> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteEntry> notes) {
        this.notes = notes;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
