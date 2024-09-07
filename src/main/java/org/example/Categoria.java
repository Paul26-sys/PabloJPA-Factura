package org.example;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {
    @Serial
    private static final long serialVerionIUD = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "denominacion")
    private String denominacion;

    @ManyToMany(mappedBy = "categorias")
    private List<Articulo> articulos =new ArrayList<Articulo>();

    //Constructores
    public Categoria (){
    }
    public Categoria(String denominacion){
        this.denominacion = denominacion;
    }
    //metodos get y set

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
}
