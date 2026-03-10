package br.com.fiap.study_apir.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class PingController {

    @GetMapping("/ping/teste")
    public String ping() {
        return "pong"; // Resposta padrão
    }

    @GetMapping("rota")
    public String rota1() {
        return "rota1"; // Resposta padrão
    }

    @GetMapping("rota2")
    public String rota2() {
        return "rota2";
    }

    @GetMapping("karine")
    public String karine() {
        return "CHATONAAA";
    }

}
