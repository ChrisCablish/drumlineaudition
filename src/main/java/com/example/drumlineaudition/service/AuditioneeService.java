package com.example.drumlineaudition.service;

import org.springframework.stereotype.Service;
import com.example.drumlineaudition.model.Auditionee;
import com.example.drumlineaudition.repository.AuditioneeRepository;
import java.util.Collection;

@Service
public class AuditioneeService {

    private final AuditioneeRepository auditioneeRepository;

    public AuditioneeService(AuditioneeRepository auditioneeRepository) {
        this.auditioneeRepository = auditioneeRepository;
    }

    public Collection<Auditionee> getAllAuditionees() {
        return auditioneeRepository.findAll();
    }

    public Auditionee getAuditioneeById(Long id) {
        return auditioneeRepository.findById(id);
    }

    public void saveAuditionee(Auditionee auditionee) {
        auditioneeRepository.save(auditionee);
    }


    public void deleteAuditionee(Long id) {
        auditioneeRepository.deleteById(id);
    }
}
