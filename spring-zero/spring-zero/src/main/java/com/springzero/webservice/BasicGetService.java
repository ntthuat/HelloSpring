package com.springzero.webservice;

import org.springframework.web.client.RestTemplate;

/**
 * @author tnthien
 * @version 03/08/2018
 * https://api.coinmarketcap.com/v1/ticker/
 */
public class BasicGetService {

    private RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        BasicGetService response = null;
    }
}
