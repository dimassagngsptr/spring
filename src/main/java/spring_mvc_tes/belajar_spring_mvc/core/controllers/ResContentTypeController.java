package spring_mvc_tes.belajar_spring_mvc.core.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResContentTypeController {
@PostMapping(path = "/hello/content",
        consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
        produces = MediaType.TEXT_HTML_VALUE)
@ResponseBody
    public String hello(@RequestParam(name = "name") String name){
    return """
                  <html>
                        <body>
                        <div>
                        <h1>Hello $name</h1>
                        </div>
                        </body>
                </html>
            """.replace("$name", name);
}
}
