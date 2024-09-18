package br.insper.avIntermediaria;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AvController {

    // crie uma rota q printa "Hello World" no navegador
    // a rota deve ser "/hello"
    // a rota deve ser do tipo GET

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }


}
