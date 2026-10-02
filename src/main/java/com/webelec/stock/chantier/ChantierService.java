package com.webelec.stock.chantier;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChantierService {

    private final ChantierRepository repository;

    @Transactional(readOnly = true)
    public List<Chantier> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Chantier findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Chantier not found: " + id));
    }

    @Transactional
    public Chantier create(ChantierRequest request) {
        Chantier chantier = new Chantier();
        chantier.setName(request.name());
        chantier.setAddress(request.address());
        chantier.setStartDate(request.startDate());
        chantier.setEndDate(request.endDate());
        chantier.setStatus(request.status());
        return repository.save(chantier);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
