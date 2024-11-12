package com.evidencia.servicio.repository;

//Import de la clase de modelo de usuario (User)
import com.evidencia.servicio.model.User;
/*Import de la interfaz CrudRepository de Spring Data para operaciones
CRUD (Crear, Leer, Actualizar, Eliminar)*/
import org.springframework.data.repository.CrudRepository;
/*Import de la anotación Repository de Spring para indicar
que esta interfaz es un repositorio(patrón de diseño de
software que separa la aplicación de la base de datos, 
mediador entre ambos, permitiendo acceder a las tablas de 
la base de datos y cargar registros en objetos de la entidad)*/
import org.springframework.stereotype.Repository;
//Import de la clase Optional de Java para manejar resultados nulos
import java.util.Optional;
//Indica que esta interfaz es un repositorio y la registra en el contexto de Spring

/**
 *
 * @author Lizeth
 */
@Repository
/*Extiende la interfaz CrudRepository para heredar operaciones CRUD, 
con User como entidad y Integer como tipo de clave primaria*/
public interface UserRepository extends CrudRepository<User, Integer> {
    //Método para verificar si existe un usuario con el nombre de usuario especificado

    boolean existsByUsername(String username);
    //Método para buscar un usuario por nombre de usuario y devuelve un Optional para manejar resultados nulos

    Optional<User> findByUsername(String username);

}
