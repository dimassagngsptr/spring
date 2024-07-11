package spring_mvc_tes.belajar_spring_mvc.core.controllers;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import spring_mvc_tes.belajar_spring_mvc.core.services.HelloService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HelloService helloService;

    @BeforeEach
    void setUp(){
        Mockito.when(helloService.hello(Mockito.anyString()))
                .thenReturn("Hello Guest");
    }


    @Test
    void helloName() throws Exception{
        mockMvc.perform(get("/hello").queryParam("name", "Dimas")).
                andExpectAll(
                        status().isOk(),
                        content().string(
                                Matchers.containsString("Hello Guest"))
                );
    }
}
