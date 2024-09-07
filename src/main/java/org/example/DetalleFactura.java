package org.example;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "detalleFactura")
public class DetalleFactura implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "subtotal")
    private int subtotal;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_factura")
    private Factura factura;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_articulo")
    private Articulo articulo;
    //Constructores
    public DetalleFactura () {
    }

    public DetalleFactura(Articulo articulo) {
        this.articulo = articulo;
    }

    public DetalleFactura(int cantidad, int subtotal) {
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public DetalleFactura(Factura factura) {
        this.factura = factura;
    }

    public int getCantidad() {
        return cantidad;
    }

    public long getId() {
        return id;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
}
