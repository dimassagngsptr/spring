package spring_mvc_tes.belajar_spring_mvc.core.controllers;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Controller
public class UploadFileController {
    @PostMapping(path = "/upload/profile" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public String uploadFile(
            @RequestParam(name="name") String name,
            @RequestPart(name = "profile") MultipartFile profile) throws IOException{

        Path path = Path.of("upload/" + profile.getOriginalFilename());
        Files.write(path, profile.getBytes());
        return "Success upload file " + name;
    }
}
