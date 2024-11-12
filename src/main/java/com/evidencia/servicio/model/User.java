package com.evidencia.servicio.model;

/**
 *
 * @author Lizeth
 */

/*Importación de anotaciones de Jakarta
Persistence (JPA) para mapear la entidad*/
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Indica que la clase es una entidad (tabla) en la base de datos
@Entity
//Especifica el nombre de la tabla en la base de datos ("usuario")
@Table(name = "usuario")
/*Clase que representa o modela los datos de la entidad "usuario" (POJO)
modelo o plantilla que se utiliza para crear objetos
define las propiedades del  objeto*/
public class User {

    //Identificador único de la entidad (clave primaria)
    @Id
    //Genera automáticamente un valor único para la clave primaria 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //Campos para almacenar el nombre de usuario y contraseña
    private String username;
    private String password;

    /*Métodos getter y setter para acceder
    y modificar los campos de la entidad*/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
/*Esta clase sigue el patrón de diseño POJO (Plain Old Java Object), 
comúnmente utilizado para representar entidades en aplicaciones Java*/

