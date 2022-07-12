package com.service.one.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import com.service.one.model.FullName;

@FeignClient(url="http://localhost:8001",name="service-three")
public interface ServiceTwoFeignClient {
	
	@PostMapping("/servicethree/username")
	 public ResponseEntity<String> serviceThree(FullName name);

}
