package com.springzero.webservice;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

/**
 * @author tnthien
 * @version 03/09/2018
 * https://api.coinmarketcap.com/v1/ticker/
 */
public class BasicGetServiceTest {

    RestTemplate restTemplate = new RestTemplate();
    
    String urlTicker = "https://api.coinmarketcap.com/v1/ticker/";
    String urlGlobal = "https://api.coinmarketcap.com/v1/global";

    @Test
    public void testGetServiceGetMethod() {
        Ticker response = null;
        response = restTemplate.getForObject(urlTicker, Ticker.class);
    }

    @Test
    public void testGetServiceMethodGlobalObject(){
        Global response = null;
        restTemplate.getForObject(urlGlobal, Global.class);
    }

    @Test
    public void testRestTemplate(){
        String result = restTemplate.getForObject("http://example.com/hotels/{hotel}/bookings/{booking}", String.class, "42", "21");
    }
}
