package com.evidencia.servicio.controller;
//Import de clases y anotaciones necesarios para la autenticación

import com.evidencia.servicio.model.User;
import com.evidencia.servicio.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lizeth
 */

/*Clase que contiene los métodos a ejecutar para una petición HTTP en
específico*/
 /* Se marca la clase como controlador con la anotación de Spring,
es una anotación que indica que una clase es un controlador de API REST (Representational State of Resource). 
 La clase maneja peticiones HTTP y devuelve respuestas en formato JSON (podría también ser en otro formato
adecuado para una API)*/
@RestController
/* Habilita CORS para permitir peticiones desde cualquier origen. */
@CrossOrigin(origins = "*", methods = RequestMethod.POST)
/* Establece el prefijo de la URL para las peticiones (/api). */
@RequestMapping("/api")
public class AuthController {

    private final AuthService authService;

    /* Servicio de autenticación inyectado. */
    /**
     * Constructor para inyectar el servicio de autenticación desde el contexto
     * de Spring.
     *
     * @param authService Servicio de autenticación.
     */
    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * Registro de usuario mediante petición POST al endpoint /register
     *
     * @param user Usuario a registrar.
     * @return ResponseEntity con mensaje de resultado.
     */
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        return authService.registerUser(user);
    }

    /**
     * Inicio de sesión de usuario mediante petición POST al endpoint /login
     *
     * @param user Usuario que intenta iniciar sesión.
     * @return ResponseEntity con mensaje de resultado.
     */
    @PostMapping("/login")
    public ResponseEntity<String> logInUser(@RequestBody User user) {
        return authService.logIn(user);
    }
}
