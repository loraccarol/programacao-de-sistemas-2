package br.mack.ps2.controller;

import java.util.List;

import javax.management.relation.RoleNotFoundException;

import br.mack.ps2.repository.InstrumentoRepository;
import br.mack.ps2.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.mack.ps2.model.TipoInstrumentos;
import br.mack.ps2.model.Instrumentos;

@RestController
@RequestMapping("/api")
public class InstrumentosController {

    @Autowired
    TipoRepository tipoRepository;

    @Autowired
    InstrumentoRepository instrumentoRepository;

    @PostMapping("/tipos/{tipo_instrumentosId}/instrumentos")
    public ResponseEntity<Instrumentos> create(@PathVariable("tipo_instrumentosId") long tipo_instrumentosId,
            @RequestBody Instrumentos instrumentos) {
        TipoInstrumentos tipo_instrumentos = tipoRepository.findById(tipo_instrumentosId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        instrumentos.setTipo_instrumentos(tipo_instrumentos);
        Instrumentos _instrumentos = instrumentoRepository.save(instrumentos);
        return new ResponseEntity<>(_instrumentos, HttpStatus.CREATED);
    }

    @GetMapping("/instrumentos")
    public ResponseEntity<List<Instrumentos>> read() {
        List<Instrumentos> instrumentos = instrumentoRepository.findAll();
        return new ResponseEntity<>(instrumentos, HttpStatus.OK);
    }

    @GetMapping("/tipos/instrumentos/{instrumento}")
    public ResponseEntity<List<Instrumentos>> readByTipo(@PathVariable("instrumento") String instrumento) {
        List<Instrumentos> instrumentos = instrumentoRepository.findByNomeContaining(instrumento);
        return new ResponseEntity<>(instrumentos, HttpStatus.OK);
    }

    @GetMapping("/instrumentos/{id}")
    public ResponseEntity<Instrumentos> read(@PathVariable("id") long id) {
        Instrumentos instrumentos = instrumentoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new ResponseEntity<>(instrumentos, HttpStatus.OK);
    }

    @PutMapping("/instrumentos/{id}")
    public ResponseEntity<Instrumentos> update(@PathVariable("id") long id,
            @RequestBody Instrumentos Instrumentos) throws RoleNotFoundException  {
                Instrumentos instrumentos  = instrumentoRepository.findById(id)
                    .orElseThrow(() -> new RoleNotFoundException("Instrumento não encontrado com esse ID:" + id));

        instrumentos.setNome(Instrumentos.getNome());
        instrumentos.setMarca(Instrumentos.getMarca());
        instrumentos.setImagemURL(Instrumentos.getImagemURL());

        final Instrumentos novoInstrumentos = instrumentoRepository.save(instrumentos);
        return ResponseEntity.ok(novoInstrumentos);
    }

    @DeleteMapping("/instrumentos/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
        instrumentoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
