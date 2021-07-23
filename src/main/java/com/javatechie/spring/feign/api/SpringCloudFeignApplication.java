package com.javatechie.spring.feign.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.spring.feign.api.client.UserClient;
import com.javatechie.spring.feign.api.dto.ServiceResponse;

@SpringBootApplication
@RestController
@EnableFeignClients
public class SpringCloudFeignApplication {

	@Autowired
	private UserClient client;
	
	@GetMapping("/findAllUser")
	public List<ServiceResponse> getUsers(){
		return client.getUsers();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFeignApplication.class, args);
	}

}
