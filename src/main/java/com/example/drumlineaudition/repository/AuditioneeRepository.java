package com.example.drumlineaudition.repository;

import com.example.drumlineaudition.model.Auditionee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AuditioneeRepository {
    private final Map<Long, Auditionee> auditioneeMap = new HashMap<>();
    private Long nextId = 1L;

    public Collection<Auditionee> findAll() {
        return auditioneeMap.values();
    }

    public Auditionee findById(Long id) {
        return auditioneeMap.get(id);
    }


    public void save(Auditionee auditionee) {
        if (auditionee.getId() == null) {
            auditionee.setId(nextId++);
        }
        auditioneeMap.put(auditionee.getId(), auditionee);
    }

    public void deleteById(Long id) {
        auditioneeMap.remove(id);
    }

}
