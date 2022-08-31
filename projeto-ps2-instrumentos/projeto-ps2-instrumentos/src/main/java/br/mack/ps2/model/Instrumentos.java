package br.mack.ps2.model;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Instrumentos")
public class Instrumentos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String marca;
    private String nome;
    private String imagemURL;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "TipoInstrumentos_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private TipoInstrumentos tipo_instrumentos;

    public Instrumentos(){}

    public Instrumentos(String marca, String nome, String imagemURL) {
        this.marca = marca;
        this.nome = nome;
        this.imagemURL = imagemURL;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagemURL() {
        return imagemURL;
    }

    public void setImagemURL(String imagemURL) {
        this.imagemURL = imagemURL;
    }

    public TipoInstrumentos getTipo_instrumentos() {
        return tipo_instrumentos;
    }

    public void setTipo_instrumentos(TipoInstrumentos tipo_instrumentos) {
        this.tipo_instrumentos = tipo_instrumentos;
    }
}
