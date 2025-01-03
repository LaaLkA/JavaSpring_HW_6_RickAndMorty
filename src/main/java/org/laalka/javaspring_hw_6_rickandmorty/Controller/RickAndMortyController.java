package org.laalka.javaspring_hw_6_rickandmorty.Controller;

import lombok.RequiredArgsConstructor;
import org.laalka.javaspring_hw_6_rickandmorty.Service.RickAndMortyClient;
import org.laalka.javaspring_hw_6_rickandmorty.model.Character;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/rickandmortyui")
public class RickAndMortyController {

    private final RickAndMortyClient rickAndMortyClient;

    @GetMapping
    public String start(){
        return "index";
    }

    @GetMapping("/persons/{first_id}/{last_id}")
    public String getCharactersByFirstLastId(@PathVariable("first_id") String firstId,
                                             @PathVariable("last_id") String lastId,
                                             Model model) {
        List<Character> characters = rickAndMortyClient.getCharactersStartEndId(firstId, lastId);
        model.addAttribute("persons", characters);
        return "charactersByPage";


    }

    @GetMapping("/charactersByPage")
    public String getCharactersPage(@RequestParam(defaultValue = "0") int page,
                                    Model model) {
        int pageSize = 10;
        int startId = page * pageSize + 1;
        int endId = startId + pageSize;

        List<Character> characters = rickAndMortyClient.getCharactersStartEndId(String.valueOf(startId), String.valueOf(endId));
        model.addAttribute("characters", characters);
        model.addAttribute("page", page);
        return "charactersByPage";
    }

    @GetMapping("/characters")
    public String getCharacters(Model model) {
        return "characters";
    }

    @GetMapping("/character")
    public String getCharacterById() {
        return "character";
    }
}
