package com.example.drumlineaudition.service;

import com.example.drumlineaudition.model.Attribute;
import com.example.drumlineaudition.repository.AttributeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DataInitializationService {

    private final AttributeRepository attributeRepository;

    @Autowired
    public DataInitializationService(AttributeRepository attributeRepository) {
        this.attributeRepository = attributeRepository;
    }

    @PostConstruct
    public void init() {
        List<String> attributeNames = Arrays.asList("Technique", "Posture", "Attitude", "Accuracy", "Preparedness", "Sound Quality");
        for (String name : attributeNames) {
            attributeRepository.save(new Attribute(name));
        }
    }
}
