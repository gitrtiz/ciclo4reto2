package com.as.controller;

import com.as.model.User;
import com.as.service.UserService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Edgar
 */
@RestController
@RequestMapping("/api/user/")
public class UserController {
    @Autowired
    private UserService servicio;
    
    @GetMapping("/all")
    public List<User> ListarUsuarios() {
        return servicio.ListarUsuarios();  
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User registrar(@RequestBody User user) {
        return servicio.creaUser(user);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User usuario) {
        return servicio.update(usuario);
    }
    
    @GetMapping("/{email}/{password}")
    public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return servicio.autenticarUsuario(email, password);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return servicio.delete(id);
    }
    
    @GetMapping("/{emailexist}")
    public boolean existeEmail(@PathVariable("email") String email) {
        if (servicio.existeEmail(email) != true) {
            return false;
        }
        else {
            return true;
        } 
    }
    
}
