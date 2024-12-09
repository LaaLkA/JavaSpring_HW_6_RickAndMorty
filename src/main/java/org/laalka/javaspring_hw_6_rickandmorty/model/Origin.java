package org.laalka.javaspring_hw_6_rickandmorty.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Origin {

    private String name;
    private String url;

}
