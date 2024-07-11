package spring_mvc_tes.belajar_spring_mvc.core.controllers;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void helloGuest() throws Exception{
        mockMvc.perform(get("/hello")).andExpectAll(status().isOk(),content().string(Matchers.containsString("Hello Guest")));
    }

    @Test
    void helloName() throws Exception{
        mockMvc.perform(get("/hello").queryParam("name", "Dimas")).andExpectAll(status().isOk(),content().string(Matchers.containsString("Hello Dimas"))
                );
    }
    @Test
    void helloPost() throws Exception{
        mockMvc.perform(post("/hello").queryParam("name", "Dimas")).andExpectAll(status().isMethodNotAllowed()
        );
    }
}
