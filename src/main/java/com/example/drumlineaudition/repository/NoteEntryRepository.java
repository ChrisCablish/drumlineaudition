package com.example.drumlineaudition.repository;

import com.example.drumlineaudition.model.Auditionee;
import com.example.drumlineaudition.model.NoteEntry;

import java.util.HashMap;
import java.util.Map;

public class NoteEntryRepository {
    private final Map<Long, NoteEntry> noteEntryMap = new HashMap<>();
}
