package com.webelec.stock.vca;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VcaService {

    private final VcaRepository repository;

    @Transactional(readOnly = true)
    public List<Vca> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Vca findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("VCA not found: " + id));
    }

    @Transactional
    public Vca create(VcaRequest request) {
        Vca vca = new Vca();
        vca.setCandidateName(request.candidateName());
        vca.setCompany(request.company());
        vca.setNiveau(request.niveau());
        vca.setExamDate(request.examDate());
        vca.setExamCenter(request.examCenter());
        vca.setScore(request.score());
        vca.setStatus(request.status());
        vca.setCertificateNumber(request.certificateNumber());
        vca.setExpiryDate(request.expiryDate());
        return repository.save(vca);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
