package com.service.one.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="service-two")
@Configuration
public interface ServiceOneFeignClient {
  
	@GetMapping("/servicetwo/username")
	 public ResponseEntity<String> serviceTwo();
}
