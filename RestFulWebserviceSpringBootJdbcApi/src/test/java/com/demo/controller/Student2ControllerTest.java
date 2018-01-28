package com.demo.controller;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.assertj.core.api.BDDAssertions;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.entity.Student;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import hello.Application;

/**
 * 
 * @author tnthien
 * @version 01/23/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"management.port=0"})
public class Student2ControllerTest {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	private final int port = 8080;
	
	private final String address = "http://localhost:" + port + "/rest/student2/";
	
	/**
	 * This test case is used for testing send request Ok to address "http://localhost:8080/rest/student2/"
	 * 
	 * @throws Exception
	 */
	@Test
	public void shouldReturn200WhenSendingRequestToController() throws Exception {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = testRestTemplate.getForEntity(address, Map.class);

		BDDAssertions.then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	/**
	 * Based on https://www.mkyong.com/webservices/jax-rs/restfull-java-client-with-java-net-url/
	 */
	@Test
	public void testGetRequestStudent2() {
		try {
			URL url = new URL(address);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			assertEquals(conn.getResponseCode(), 200);

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This test case is used for get json object from String
	 */
	@Test
	public void testGetJsonFromStudent2() {
		try {
			URL url = new URL(address);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			assertEquals(conn.getResponseCode(), 200);

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output = br.readLine();
			JSONObject jsonObj = new JSONObject(output);
			
			// check String that have id is "101"
			assertEquals(jsonObj.getString("101"), "{\"subject\":\"Math\",\"name\":\"John\",\"id\":101}");
			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetObjectFromStudent2() {
		try {
			URL url = new URL(address);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			assertEquals(conn.getResponseCode(), 200);

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output = br.readLine();
			JSONObject jsonObj = new JSONObject(output);
			
			JSONObject childJsonObj = jsonObj.getJSONObject("101");
			Gson gson = new GsonBuilder().create();
			Student student = gson.fromJson(childJsonObj.toString(), Student.class);
			assertEquals(101, student.getId());
			assertEquals("John", student.getName());
			assertEquals("Math", student.getSubject());
			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
