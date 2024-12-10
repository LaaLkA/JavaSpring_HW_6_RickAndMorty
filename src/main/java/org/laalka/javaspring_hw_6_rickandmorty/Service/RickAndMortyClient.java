package org.laalka.javaspring_hw_6_rickandmorty.Service;

import org.laalka.javaspring_hw_6_rickandmorty.model.Location;
import org.laalka.javaspring_hw_6_rickandmorty.model.Origin;
import org.laalka.javaspring_hw_6_rickandmorty.model.Character;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RickAndMortyClient {
    private final RestTemplate restTemplate;
    private static final String BASE_URL = "https://rickandmortyapi.com/api/character";

    public RickAndMortyClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Character> getCharacters(){
        return null;
    }

    public Character getCharacterById(Long id){
        String url = BASE_URL + "/" + id;
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        Map body = response.getBody();
        Map originMap = (Map) body.get("origin");
        Map locationMap = (Map) body.get("location");

        return new Character(
                ((Number) body.get("id")).longValue(),
                (String) body.get("name"),
                (String) body.get("status"),
                (String) body.get("species"),
                (String) body.get("type"),
                (String) body.get("gender"),
                new Origin((String) originMap.get("name"), (String) originMap.get("url")),
                new Location((String) locationMap.get("name"), (String) locationMap.get("url")),
                (String) body.get("image")
        );
    }


    public List<Character> getCharactersStartEndId(String firstId, String lastId) {
        int startId = Integer.parseInt(firstId);
        int endId = Integer.parseInt(lastId);

        List<Character> characters = new ArrayList<>();

        for (int i = startId; i <= endId; i++) {
            String url = BASE_URL + "/" + i;

            try {
                ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
                Map body = response.getBody();

                if (body == null) {
                    continue;
                }

                Map originMap = (Map) body.get("origin");
                Map locationMap = (Map) body.get("location");

                // Извлекаем поля
//                Long personId = (Long) body.get("id");
//                String name = (String) body.get("name");
//                String status = (String) body.get("status");
//                String species = (String) body.get("species");
//                String type = (String) body.get("type");
//                String gender = (String) body.get("gender");
//                String image = (String) body.get("image");
//
//                Map originMap = (Map) body.get("origin");
//                Origin origin = new Origin((String) originMap.get("name"), (String) originMap.get("url"));
//
//                Map locationMap = (Map) body.get("location");
//                Location location = new Location((String) locationMap.get("name"), (String) locationMap.get("url"));
//
//                Person person = new Person(personId, name, status, species, type, gender, origin, location, image);

                Character character = new Character(
                        ((Number) body.get("id")).longValue(),
                        (String) body.get("name"),
                        (String) body.get("status"),
                        (String) body.get("species"),
                        (String) body.get("type"),
                        (String) body.get("gender"),
                        new Origin((String) originMap.get("name"), (String) originMap.get("url")),
                        new Location((String) locationMap.get("name"), (String) locationMap.get("url")),
                        (String) body.get("image")
                );
                characters.add(character);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return characters;
    }
}
