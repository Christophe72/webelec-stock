package com.webelec.stock.chantier;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chantiers")
@RequiredArgsConstructor
public class ChantierController {

    private final ChantierService service;

    @GetMapping
    public List<Chantier> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Chantier getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Chantier create(@Valid @RequestBody ChantierRequest request) {
        return service.create(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
