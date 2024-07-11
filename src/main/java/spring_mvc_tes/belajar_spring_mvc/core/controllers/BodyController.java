package spring_mvc_tes.belajar_spring_mvc.core.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import spring_mvc_tes.belajar_spring_mvc.core.model.HelloRequest;
import spring_mvc_tes.belajar_spring_mvc.core.model.HelloResponse;

@Controller
public class BodyController {

    private ObjectMapper objectMapper;

    @PostMapping(path = "/body",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String body(@RequestBody String request) throws JsonProcessingException {
        HelloRequest helloRequest = objectMapper.readValue(request, HelloRequest.class);
        HelloResponse helloResponse = new HelloResponse();
        helloResponse.setHello("Hello " + helloRequest.getName());
        return objectMapper.writeValueAsString(helloResponse);
    }
}
