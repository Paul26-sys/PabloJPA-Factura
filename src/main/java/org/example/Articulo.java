package org.example;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "articulo")
public class Articulo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "denominacion")
    private String denominacion;
    @Column(name = "precio")
    private int precio;

    @OneToMany(mappedBy = "articulo", cascade = CascadeType.PERSIST)
    private List<DetalleFactura> detalle = new ArrayList<DetalleFactura>();

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "articulo_categoria",
            joinColumns = @JoinColumn(name = "articulo_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias = new ArrayList<Categoria>();


    //Constructores
    public Articulo (){
    }


    public Articulo(List<DetalleFactura> detalle) {
        this.detalle = detalle;
    }

    public Articulo (int cantidad, String denominacion, int precio){
        this.cantidad = cantidad;
        this.precio = precio;
        this.denominacion = denominacion;
    }
    //metodos get y set

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public List<DetalleFactura> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetalleFactura> detalle) {
        this.detalle = detalle;
    }
}
