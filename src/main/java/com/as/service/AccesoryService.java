package com.as.service;

import com.as.model.Accesory;
import com.as.reposirory.AccesoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Edgar
 */

@Service
public class AccesoryService {
    @Autowired
    private AccesoryRepository  repositorio;
    
    public List<Accesory> ListarAccesorios() {
        return repositorio.getAll();
    }
    
    public Accesory creaAccesorio(Accesory accesorio) {
        if (accesorio.getReference() != null) {
            return repositorio.save(accesorio); 
        } else {
            return accesorio;
        }
    }
    
     public Optional<Accesory> getAccesory(String reference) {
        return repositorio.getAccesory(reference);
    }

    public Accesory update(Accesory accesorio){
        if (accesorio.getReference()!= null){
            Optional<Accesory> g = repositorio.getAccesory(accesorio.getReference());
            if (!g.isEmpty()) {
                if (accesorio.getReference()!=null) {
                    g.get().setReference(accesorio.getReference());
                }                
                if (accesorio.getDescription()!=null) {
                    g.get().setDescription(accesorio.getDescription());
                }
                if (accesorio.getBrand()!=null) {
                    g.get().setBrand(accesorio.getBrand());
                }
                if (accesorio.getCategory()!=null) {
                    g.get().setCategory(accesorio.getCategory());
                }
                if (accesorio.getMaterial()!=null) {
                    g.get().setMaterial(accesorio.getMaterial());
                }
                if (accesorio.getPhotography()!=null) {
                    g.get().setPhotography(accesorio.getPhotography());
                }
                return repositorio.save(g.get());
            }
        }
        return accesorio;
    }
    
    public boolean delete(String reference) {
        Optional<Accesory> c = getAccesory(reference);
        if (!c.isEmpty()) {
            repositorio.delete(c.get());
            return true;
        }
        return false;
    }    
    
}
