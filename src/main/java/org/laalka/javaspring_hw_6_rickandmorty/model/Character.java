package org.laalka.javaspring_hw_6_rickandmorty.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Character {

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
