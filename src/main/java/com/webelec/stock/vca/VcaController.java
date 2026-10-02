package com.webelec.stock.vca;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vca")
@RequiredArgsConstructor
public class VcaController {

    private final VcaService service;

    @GetMapping
    public List<Vca> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Vca getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vca create(@Valid @RequestBody VcaRequest request) {
        return service.create(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
