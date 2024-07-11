package spring_mvc_tes.belajar_spring_mvc.core.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HeaderController {

    @RequestMapping(path = "/header/token")
    @ResponseBody
    public String header(@RequestHeader(name = "X-TOKEN")String token){
        if(token.equals("Dimas")){
            return "OK";
        }else{
            return "KO";
        }
    }
}
