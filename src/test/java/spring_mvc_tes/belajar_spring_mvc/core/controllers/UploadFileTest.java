package spring_mvc_tes.belajar_spring_mvc.core.controllers;


import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UploadFileTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void uploadTest() throws Exception {
        mockMvc.perform(
                multipart("/upload/profile")
                        .file(new MockMultipartFile("profile", "profile.png", "image/png",
                                getClass().getResourceAsStream("/images/profile.png")))
                        .param("name", "Dimas")
                        .contentType(MediaType.MULTIPART_FORM_DATA)
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Success upload file Dimas"))
        );
    }
}
