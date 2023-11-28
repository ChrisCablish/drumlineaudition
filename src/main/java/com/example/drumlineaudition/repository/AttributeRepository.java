package com.example.drumlineaudition.repository;

import com.example.drumlineaudition.model.Attribute;
import com.example.drumlineaudition.model.Auditionee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AttributeRepository {
    private final Map<Long, Attribute> attributeMap = new HashMap<>();

    private Long nextId = 1L;


    public Collection<Attribute> findAll() {
        return attributeMap.values();
    }

    public Attribute findById(Long id) {
        return attributeMap.get(id);
    }


    public void save(Attribute attribute) {
        if (attribute.getId() == null) {
            attribute.setId(nextId++);
        }
        attributeMap.put(attribute.getId(), attribute);
    }

    public void deleteById(Long id) {
        attributeMap.remove(id);
    }
}
