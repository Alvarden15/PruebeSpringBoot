package com.programaciondos.prueba1.APIs;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartController {
    
    @RequestMapping("/")
    public String index(){
        return "Saludos desde spring boot";
    }
}
