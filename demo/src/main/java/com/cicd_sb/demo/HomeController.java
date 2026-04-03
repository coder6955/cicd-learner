package com.cicd_sb.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

@RestController
public class HomeController {
    @GetMapping("/")
    public Map<String, String> home() throws UnknownHostException {
        String env = System.getenv().getOrDefault("ENVIRONMENT", "NO VALUE PRESENT");
        String host = InetAddress.getLocalHost().getHostName();
        String LOG_LEVEL = System.getenv().getOrDefault("LOG_LEVEL", "NO VALUE PRESENT");
        String DB_USERNAME = System.getenv().getOrDefault("DB_USERNAME", "NO VALUE PRESENT");
        //return "Hello World from uday V2!";
        return Map.of(
                "message", "Hello World from uday V3!",
                "environment", env,
                "logLevel", LOG_LEVEL,
                "host", host,
                "Kubernetes","Is added bruhhh finally!!!"
        );
    }
}
