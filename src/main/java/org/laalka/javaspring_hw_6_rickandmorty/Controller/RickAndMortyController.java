package org.laalka.javaspring_hw_6_rickandmorty.Controller;

import lombok.RequiredArgsConstructor;
import org.laalka.javaspring_hw_6_rickandmorty.Service.RickAndMortyClient;
import org.laalka.javaspring_hw_6_rickandmorty.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/rickandmortyui")
public class RickAndMortyController {

    private final RickAndMortyClient rickAndMortyClient;

    @GetMapping("/persons/{first_id}/{last_id}")
    public String getCharactersByFirstLastId(@PathVariable("first_id") String firstId,
                                             @PathVariable("last_id") String lastId,
                                             Model model) {
        List<Person> persons = rickAndMortyClient.getPersonsStartEndId(firstId, lastId);
        model.addAttribute("persons", persons);
        return "persons";


    }
}
