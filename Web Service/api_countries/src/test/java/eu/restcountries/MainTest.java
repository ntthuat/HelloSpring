package eu.restcountries;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webservice.dto.Country;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class MainTest {
    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void testGetAll() {
        String response = restTemplate.getForObject("https://restcountries.eu/rest/v2/all", String.class);
        System.out.println("Response from all: \n" + response);
    }

    @Test
    public void testGetAllMapToCountry() {
        ResponseEntity<Country[]> responseEntity = restTemplate.getForEntity("https://restcountries.eu/rest/v2/all", Country[].class);
        Country[] countries = responseEntity.getBody();
        MediaType contentType = responseEntity.getHeaders().getContentType();
        HttpStatus statusCode = responseEntity.getStatusCode();
    }
}
