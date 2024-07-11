package spring_mvc_tes.belajar_spring_mvc.core.controllers;


import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {
    @GetMapping(path = "/orders/{orderId}/product/{productId}")
    @ResponseBody
    public String orderController(
            @PathVariable("orderId") String orderId,
            @PathVariable("productId") String productId
    ){
        return "Order: " + orderId + " Product: " + productId;
    }

}
