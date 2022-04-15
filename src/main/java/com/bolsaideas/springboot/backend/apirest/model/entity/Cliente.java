package com.bolsaideas.springboot.backend.apirest.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Table(name = "clientes")
@Entity
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*@NotEmpty debe estar acompañado del @Size y se le puede añadir el mensaje de salida en el front  @NotEmpty(message = "no puede estar ")*/
    @NotEmpty(message = "es obligatorio!")
    @Size(min = 4, max = 20)
    /*los campos por defecto son nulos*/
    @Column(nullable = false)
    private  String nombre;

    @NotEmpty
    private  String apellido;


    @Email
    @NotEmpty
    @Column(nullable = false, unique = true)
    private String email;


    @Column(name = "create_at")
    /*transforma la fecha de java a la fecha de mysql*/
    @Temporal(TemporalType.DATE)
    private Date createAt;

    private String foto;

    @NotNull(message = "la region no puede estar vacia")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")/*nombre de la tabla forenea en clientes*/
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Region region;


    /*FOTO*/
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

//    /*crea la fecha del cliente automaticamente cuando se crea un cliente*/
//    @PrePersist
//    public void prePersist(){
//        createAt = new Date();
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public static final long serialVersionUID = 1L;
}
