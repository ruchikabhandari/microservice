package com.service.one.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.one.model.FullName;
import com.service.one.service.ServiceClassImpl;

@RestController
@RequestMapping("/fullName")
public class ServiceController {
//	 private final ServiceClass serviceClass;
//
//	    @Autowired
//	    public ServiceController(final ServiceClass serviceClass) {
//	        this.serviceClass = serviceClass;
//	    }
//	
	 @Autowired
	 ServiceClassImpl serviceClass;
	 
	@GetMapping("/courses")
	public String IsAddressAvailable(String address)
	{
//	    try
//	    {
//	        System.Net.WebClient client = new WebClient();
//	        client.DownloadData(address);
//	        return "UP";
//	    }
//	    catch
//	    {
//	        return "NOT UP";
//	    }
		return null;
	}
    @PostMapping("/name")
    public ResponseEntity<String> ConcatenatedString(@RequestBody FullName fullName){
    	return serviceClass.ConcatenatedString(fullName);
    }

}
