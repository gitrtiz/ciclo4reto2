package com.as.controller;

import com.as.model.Accesory;
import com.as.service.AccesoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Edgar
 */
@RestController
@RequestMapping("/api/accesory")
public class AccesoryController {
   @Autowired
   private AccesoryService servicio;
   
   @GetMapping("/all")
    public List<Accesory> ListarAccesorios() {
        return servicio.ListarAccesorios();  
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Accesory registrar(@RequestBody Accesory accesorio) {
        return servicio.creaAccesorio(accesorio);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Accesory update(@RequestBody Accesory accesorio) {
        return servicio.update(accesorio);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") String reference) {
        return servicio.delete(reference);
    }
    
}
