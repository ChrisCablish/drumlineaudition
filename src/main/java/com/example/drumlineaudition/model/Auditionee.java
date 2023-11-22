package com.example.drumlineaudition.model;
import java.util.List;
public class Auditionee {
    private Long id;
    private String name;
    private List<String> strengths;
    private List<String> weaknesses;
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

    public List<String> getStrengths() {
        return strengths;
    }

    public void setStrengths(List<String> strengths) {
        this.strengths = strengths;
    }

    public List<String> getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(List<String> weaknesses) {
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
