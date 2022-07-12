package com.service.one.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.service.one.feign.client.ServiceOneFeignClient;
import com.service.one.feign.client.ServiceTwoFeignClient;
import com.service.one.model.FullName;

@Service
public class ServiceClassImpl {

	// private ServiceOneFeignClient serviceOneFeignClient;

	// private ServiceTwoFeignClient serviceTwoFeignClient;

	@Autowired
	RestTemplate restTemplate;

	public ResponseEntity<String> ConcatenatedString(FullName fullName) {

//		ResponseEntity<String> stringOne =serviceOneFeignClient.serviceTwo();
//		ResponseEntity<String> stringTwo =serviceTwoFeignClient.serviceThree(fullName);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		String str = restTemplate.exchange("http://localhost:8000/servicetwo/username", HttpMethod.GET, entity, String.class).getBody();
		HttpEntity<FullName> entityTwo = new HttpEntity<FullName>(fullName, headers);
		String strOne = restTemplate.exchange("http://localhost:8001/servicethree/username", HttpMethod.POST, entityTwo, String.class).getBody();
		String concatString = str + " " + strOne;
		return ResponseEntity.ok().body(concatString);
		
	}

}
