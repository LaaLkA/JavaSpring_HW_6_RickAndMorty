package org.laalka.javaspring_hw_6_rickandmorty.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {

    private String name;
    private String url;
}
