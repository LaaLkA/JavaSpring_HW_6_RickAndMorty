package org.laalka.javaspring_hw_6_rickandmorty.Controller.Rest;

import lombok.RequiredArgsConstructor;
import org.laalka.javaspring_hw_6_rickandmorty.Service.RickAndMortyClient;
import org.laalka.javaspring_hw_6_rickandmorty.model.Character;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class RickAndMortyRestController {

    private final RickAndMortyClient client;

    @GetMapping("/persons/{first_id}/{last_id}")
    public List<Character> getPersons(@PathVariable("first_id") String firstId, @PathVariable("last_id") String lastId) {
        return client.getCharactersStartEndId(firstId, lastId);
    }

    @GetMapping("/characters")
    public List<Character> getCharacters(@RequestParam(defaultValue = "0") int page){
        int pageSize = 10;
        int startId = page * pageSize + 1;
        int endId = startId + pageSize;
        return client.getCharactersStartEndId(String.valueOf(startId), String.valueOf(endId));
    }

    @GetMapping("/character")
    public Character getCharacter(@RequestParam(defaultValue = "1") Long id) {
        return client.getCharacterById(id);
    }
}
