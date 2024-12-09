package org.laalka.javaspring_hw_6_rickandmorty.Service;

import lombok.AllArgsConstructor;
import org.laalka.javaspring_hw_6_rickandmorty.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Person> getPersons(String firstId, String lastId){
        int startId = Integer.parseInt(firstId);
        int endId = Integer.parseInt(lastId);

        List<Person> persons = new ArrayList<>();

        for(int i = startId; i <= endId; i++){
            String url = BASE_URL + "?firstId=" + i + "&lastId=" + i;

            try {

            }
        }
        ResponseEntity<Map> response = restTemplate.getForEntity(BASE_URL, Map.class);
        List<Map<String, Object>> results = (List<Map<String, Object>>) response.getBody().get("results");
        return results.stream()
                .map(result -> new Person(
                        (String) result.get("id"),
                        (String) result.get("name"),
                        (String) result.get("status"),
                        (String) result.get("species"),
                        (String) result.get("type"),
                        (String) result.get("gender")
                ))
                .limit(10) // Ограничиваем результат до 10
                .toList();
    }
}
