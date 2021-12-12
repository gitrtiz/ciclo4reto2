package com.as;

import com.as.model.Accesory;
import com.as.model.User;
import com.as.reposirory.crud.AccesoryCrudRepository;
import com.as.reposirory.crud.UserCrudRepository;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
     @Autowired   
     private UserCrudRepository userRepo;
     @Autowired
     private AccesoryCrudRepository accesoryCrud;
        
    public static void main(String[] args) {
	SpringApplication.run(DemoApplication.class, args);
    }
        
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Aqui se ejecuta la creación en MongoDb");
        //SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
       userRepo.deleteAll();
       accesoryCrud.deleteAll(); 
        
   /*
    userRepo.saveAll(List.of(
        new User(3,"4444", "Juana la colombiana", new Date(), "11", "calle 54", "777777", "mail@meil.com", "123", "","ADM"),
        new User(4, "4444", "Juana la colombiana", new Date(), "11", "calle 54", "777777", "mail@meil.com", "123", "","COORD")
    ));
    
          
    accesoryCrud.saveAll(List.of(
        new Accesory(1, "AP-903", "Genius", "Ratones", "Cuero", "Describe", true, 150.000, 10, "www.mipagina.com"),
        new Accesory(2, "AP-904", "Genius", "Ratones", "Cuero", "Describe", true, 150.000, 10, "www.mipagina.com")
    ));
    */
    }
}
