package com.evidencia.servicio.service;

/*Import de la anotación Service de Spring para indicar que esta clase es un servicio
( el componente encargado de resolver la lógica de negocio dentro de la aplicación)*/
import org.springframework.stereotype.Service;
//Import de clases y anotaciones necesarias para la autenticación
import com.evidencia.servicio.model.User;
import com.evidencia.servicio.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Lizeth
 */

// Indica que esta clase es un servicio y la registra en el contexto de Spring
@Service
public class AuthService {
//Repositorio de usuarios para acceder a la base de datos

    private final UserRepository userRepository;
//Inyecta el repositorio de usuarios (UserRepository) mediante constructor

    /**
     * Constructor para inyectar el repositorio de usuarios.
     *
     * @param userRepository Repositorio de usuarios.
     */
    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Registra un nuevo usuario en el sistema. Verifica si el usuario ya existe
     * y registra si no existe
     *
     * @param user Usuario a registrar.
     * @return ResponseEntity con mensaje de resultado.
     */
    public ResponseEntity<String> registerUser(User user) {
        if (existsUserByUsername(user.getUsername())) {
            return ResponseEntity.badRequest().body("Error en la autenticación. El usuario ya existe.");
        } else {
            userRepository.save(user);
            System.out.println(user.getPassword());
            return ResponseEntity.ok("Usuario creado exitosamente. Autenticación satisfactoria.");
        }

    }

    /**
     * Inicia sesión para un usuario existente. Verifica credenciales del
     * usuario para iniciar sesión
     *
     * @param user Usuario que intenta iniciar sesión.
     * @return ResponseEntity con mensaje de resultado.
     */
    public ResponseEntity<String> logIn(User user) {
        boolean existsUser = existsUserByUsername(user.getUsername());
        if (existsUser && passwordMatches(user.getUsername(), user.getPassword())) {
            return ResponseEntity.ok("Sesión iniciada exitosamente. Autenticación satisfactoria.");
        } else {
            return ResponseEntity.badRequest().body("Ha habido un error. El usuario no existe o la contraseña es incorrecta. ");
        }
    }

    /**
     * Verifica si un usuario existe por nombre de usuario.
     *
     * @param username Nombre de usuario a verificar.
     * @return True si el usuario existe, false de lo contrario.
     */
    public boolean existsUserByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    /**
     * Verifica si la contraseña coincide con la del usuario.
     *
     * @param username Nombre de usuario.
     * @param password Contraseña a verificar.
     * @return True si la contraseña coincide, false de lo contrario.
     */
    public boolean passwordMatches(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return user.get().getPassword().equals(password);
        } else {
            return false;
        }
    }
}
