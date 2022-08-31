package br.mack.ps2.controller;

import br.mack.ps2.model.TipoInstrumentos;
import br.mack.ps2.repository.TipoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import javax.management.relation.RoleNotFoundException;

@RestController
@RequestMapping("/api/tipos")
public class TipoController {

    @Autowired
    TipoRepository tipoRepository;

    @PostMapping("")
    public ResponseEntity<TipoInstrumentos> create(@RequestBody TipoInstrumentos tipoInstrumentos) {
        TipoInstrumentos _tipo = tipoRepository.save(tipoInstrumentos);
        return new ResponseEntity<>(_tipo, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<TipoInstrumentos>> read() {
        List<TipoInstrumentos> tipo = tipoRepository.findAll();
        return new ResponseEntity<>(tipo, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<TipoInstrumentos> read(@PathVariable("id") long id) {
        TipoInstrumentos tipo = tipoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new ResponseEntity<>(tipo, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<TipoInstrumentos> update(@PathVariable("id") long id,
            @RequestBody TipoInstrumentos tipoInstrumentos) throws RoleNotFoundException  {
                TipoInstrumentos tipo = tipoRepository.findById(id)
                    .orElseThrow(() -> new RoleNotFoundException("Tipo de Instrumento não encontrado com esse ID:" + id));

        tipo.setTipo(tipoInstrumentos.getTipo());

        final TipoInstrumentos novoTipoInstrumentos = tipoRepository.save(tipo);
        return ResponseEntity.ok(novoTipoInstrumentos);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {

        tipoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}