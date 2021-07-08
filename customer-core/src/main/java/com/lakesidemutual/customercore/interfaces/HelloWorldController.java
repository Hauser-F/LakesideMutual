package com.lakesidemutual.customercore.interfaces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("hello")
public class HelloWorldController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Value("${customermanagement.baseURL}")
    private String resource;

    @GetMapping("/cycle")
    public String cycle() {
        ResponseEntity<String> response = restTemplate.getForEntity(resource + "customers/cycle", String.class);
        logger.info(response.getBody());
        return response.getBody();
    }
}
