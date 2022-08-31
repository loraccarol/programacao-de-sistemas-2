package br.mack.ps2.model;

import javax.persistence.*;

@Entity
@Table(name = "TipoInstrumentos")
public class TipoInstrumentos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String tipo;

    public TipoInstrumentos() {}

    public TipoInstrumentos(String tipo) {
        this.tipo = tipo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
