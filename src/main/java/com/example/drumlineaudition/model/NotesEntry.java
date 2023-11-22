package com.example.drumlineaudition.model;

import java.time.LocalDateTime;

public class NotesEntry {
    private Long id;
    private LocalDateTime date;
    private String text;

    public NotesEntry() {
    }

    public NotesEntry(LocalDateTime date, String text) {
        this.date = LocalDateTime.now();
        this.text = text;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
