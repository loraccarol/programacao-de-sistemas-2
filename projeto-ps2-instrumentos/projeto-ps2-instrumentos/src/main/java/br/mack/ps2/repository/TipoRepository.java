package br.mack.ps2.repository;

import br.mack.ps2.model.TipoInstrumentos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoRepository extends JpaRepository<TipoInstrumentos, Long> {

}
