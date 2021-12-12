
package com.as.reposirory.crud;

import com.as.model.Accesory;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Edgar
 */
public interface AccesoryCrudRepository extends MongoRepository<Accesory, String>{
    Optional<Accesory> findByReference(String reference);
}
