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
@Table(name = "client")
public class Cliente implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Fk_domicilio")
    private Domicilio domicilio;

    @OneToMany(mappedBy = "cliente")
    private List<Factura> facturas = new ArrayList<Factura>();

    //al usar column me aseguro que el no va a usar el atributo nombre sino que lo referencio la columna con ese nombre y no con el atributo
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;
    // con el unique no va a poder guardar el mismo dni dos veces
    @Column(name = "dni", unique = true)
    private int dni;
    //Constructores
    public Cliente (){
    }

    public Cliente(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Cliente(int dni, String apellido, String nombre){
        this.apellido = apellido;
        this.dni = dni;
        this.nombre = nombre;
    }
    //metodos get y set

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
}
