package kr.co.jongminkim.demozipkinserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/getList")
    public List<User> getUsers(){

        List<User> userList = new ArrayList<>();
        userList = restTemplate.exchange(
                "http://localhost:8082/users/getList"
                ,HttpMethod.GET
                ,null
                ,new ParameterizedTypeReference<List<User>>() {}
        ).getBody();



        return userList;
    }
}
