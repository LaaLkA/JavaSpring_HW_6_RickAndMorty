package org.laalka.javaspring_hw_6_rickandmorty.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {

    private Long id;

    private String name;

    private String status;
    private String species;
    private String type;
    private String gender;

    private Origin origin;
    private Location location;
    private String image;

}
