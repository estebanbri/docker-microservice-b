package com.example.dockermicroserviceb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class AppController {

    private static final String SPRING_APPLICATION_NAME = "docker-app";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String isRunning() throws UnknownHostException {
        return "Hi, docker-microservice-b is running from ip=" + InetAddress.getLocalHost() + " [container_id/container_ip]";
    }

    @GetMapping("/call-docker-app")
    public String callDockerApp(){
        return restTemplate.getForObject("http://"+ SPRING_APPLICATION_NAME, String.class);
    }

}
