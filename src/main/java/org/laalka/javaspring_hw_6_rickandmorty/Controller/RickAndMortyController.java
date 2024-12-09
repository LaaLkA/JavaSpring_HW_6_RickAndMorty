package org.laalka.javaspring_hw_6_rickandmorty.Controller;

import lombok.RequiredArgsConstructor;
import org.laalka.javaspring_hw_6_rickandmorty.Service.RickAndMortyClient;
import org.laalka.javaspring_hw_6_rickandmorty.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rickandmortyapi")
public class RickAndMortyController {

    private final RickAndMortyClient client;

    @GetMapping("/persons/{first_id}/{last_id}")
    public List<Person> getPersons(@PathVariable("first_id") String firstId, @PathVariable("last_id") String lastId) {
        return client.getPersons(firstId, lastId);
    }
}
