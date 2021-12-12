package com.as.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Edgar
 */

@Document(collection = "accessories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Accesory {
    @Id
    private String reference;
    private String brand;
    private String category;
    private String material;
    private String description;
    private boolean availability = true;
    private double price;
    private int quantity;
    private String photography;
 
}
