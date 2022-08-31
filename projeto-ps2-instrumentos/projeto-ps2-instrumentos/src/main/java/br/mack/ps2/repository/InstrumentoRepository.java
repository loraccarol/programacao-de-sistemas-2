package br.mack.ps2.repository;

import br.mack.ps2.model.Instrumentos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstrumentoRepository extends JpaRepository<Instrumentos, Long> {
    public List<Instrumentos> findByNomeContaining(String nome);
}
