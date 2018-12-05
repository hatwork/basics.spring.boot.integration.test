package com.hatim.basics.springboot.comp;

import static org.junit.Assert.assertEquals;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.hatim.basics.springboot.app.BasicsSpringBootApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BasicsSpringBootApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerIntegrationTest {
	
	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void testController() {
		
		validateResponse( "{id:1,name:Hatim,school=MSB,standard=III}" , getStudent("1"));
		
		assertEquals("Done", addStudent().getBody());
		
		validateResponse( "[{id:1,name:Hatim,school=MSB,standard=III},{id:2,name:\"Hatim Kamaal\",school=TSK,standard=III}]" , getStudent("all"));
		
		assertEquals("Done", removeStudent().getBody());
		
		validateResponse( "[{id:1,name:Hatim,school=MSB,standard=III}]" , getStudent("all"));
		
	}
		
	/**
	 * 
	 * @param expected
	 * @param response
	 */
	private void validateResponse(String expected, ResponseEntity<String> response) {
		try {
			JSONAssert.assertEquals(expected, response.getBody(), false);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param sid
	 * @return
	 */
	private ResponseEntity<String> getStudent(String sid) {
		HttpEntity<String> entity = new HttpEntity<String>(null, new HttpHeaders());
		return restTemplate.exchange(createURLWithPort("/student/"+sid), HttpMethod.GET, entity,
				String.class);
	}

	/**
	 * 
	 * @return
	 */
	public ResponseEntity<String> addStudent() {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("id", "2");
		map.add("name", "Hatim Kamaal");
		map.add("school", "TSK");
		map.add("standard", "III");

		
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		return restTemplate.postForEntity(createURLWithPort("/student/add"), request,
				String.class);
	}
	
	/**
	 * 
	 * @return
	 */
	public ResponseEntity<String> removeStudent() {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("id", "2");
		
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		return restTemplate.postForEntity(createURLWithPort("/student/remove"), request,
				String.class);
	}
	
	/**
	 * 
	 * @param uri
	 * @return
	 */
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
