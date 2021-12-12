package com.as.reposirory;

import com.as.model.User;
import com.as.reposirory.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Edgar
 */

@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository crudRepositorio; 
    
    public List<User> getAll() {
        return (List<User>) crudRepositorio.findAll();
    }
    
    public Optional<User> getUser(int id) {
        return crudRepositorio.findById(id);
    }
    
    public User save(User user) {
        return crudRepositorio.save(user);
    }
    
    public boolean existeEmail(String email) {
        Optional<User> usuario = crudRepositorio.findByEmail(email);
        return !usuario.isEmpty();
    }
    
    public Optional<User> autenticarUsuario(String email, String password) {
        return crudRepositorio.findByEmailAndPassword(email, password);
    }
    
    public void delete(User usuario){
        crudRepositorio.delete(usuario);
    }
}
