package com.as.service;

import com.as.model.User;
import com.as.reposirory.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Edgar
 */
@Service
public class UserService {
    @Autowired
    private UserRepository repositorio;
    
    public List<User> ListarUsuarios() {
        return repositorio.getAll();
    }
    
    public Optional<User> getUser(int id) {
        return repositorio.getUser(id);
    }
    
    public User creaUser(User user) {
        if (user.getId() != null) {
            if (existeEmail(user.getEmail()) == false) {
                return repositorio.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
    
    public boolean existeEmail(String email) {
        return repositorio.existeEmail(email);
    }
    
    public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = repositorio.autenticarUsuario(email, password);

        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }
    
    public User update(User usuario){
        if (usuario.getId()!= null){
            Optional<User> g = repositorio.getUser(usuario.getId());
            if (!g.isEmpty()) {
                if (usuario.getId()!=null) {
                    g.get().setId(usuario.getId());
                }                
                if (usuario.getAddress()!=null) {
                    g.get().setAddress(usuario.getAddress());
                }
                if (usuario.getCellPhone()!=null) {
                    g.get().setCellPhone(usuario.getCellPhone());
                }
                if (usuario.getEmail()!=null) {
                    g.get().setEmail(usuario.getEmail());
                }
                if (usuario.getIdentification()!=null) {
                    g.get().setIdentification(usuario.getIdentification());
                }
                if (usuario.getName()!=null) {
                    g.get().setName(usuario.getName());
                }
                if (usuario.getPassword()!=null) {
                    g.get().setPassword(usuario.getPassword());
                }
                if (usuario.getType()!=null) {
                    g.get().setType(usuario.getType());
                }
                if (usuario.getZone()!=null) {
                    g.get().setZone(usuario.getZone());
                }
                return repositorio.save(g.get());
            }
        }
        return usuario;
    }
    
    public boolean delete(Integer id) {
        Optional<User> c = getUser(id);
        if (!c.isEmpty()) {
            repositorio.delete(c.get());
            return true;
        }
        return false;
    }
    
}
