package org.example;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "domicilio")
public class Domicilio  implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombreCalle")
    private String nombreCalle;
    @Column(name = "numero")
    private int numero;

    @OneToOne(mappedBy = "domicilio")
    private Cliente cliente;
    //Constructores
    public Domicilio (){
    }

    public Domicilio(Cliente cliente) {
        this.cliente = cliente;
    }

    public Domicilio(String nombreCalle, int numero) {
        this.nombreCalle = nombreCalle;
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombreCalle() {
        return nombreCalle;
    }

    public void setNombreCalle(String nombreCalle) {
        this.nombreCalle = nombreCalle;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
