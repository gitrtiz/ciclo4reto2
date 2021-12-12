package com.as.reposirory;

import com.as.model.Accesory;
import com.as.reposirory.crud.AccesoryCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Edgar
 */
@Repository
public class AccesoryRepository {
    @Autowired
    private AccesoryCrudRepository crudRepositorio; 
    
    public List<Accesory> getAll() {
        return (List<Accesory>) crudRepositorio.findAll();
    }
    
    public Accesory save(Accesory accesorio) {
        return crudRepositorio.save(accesorio);
    }
    
    public Optional<Accesory> getAccesory(String reference) {
        return crudRepositorio.findByReference(reference);
    }
    
    public void delete(Accesory accesorio){
        crudRepositorio.delete(accesorio);
    }
}
