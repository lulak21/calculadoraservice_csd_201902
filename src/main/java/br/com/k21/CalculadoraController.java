package br.com.k21;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController {
    @RequestMapping("/calculadora-royalties")
    public double royalties(@RequestParam(value="mes", defaultValue="1") int mes, 
    		@RequestParam(value="ano", defaultValue="2018") int ano) {
        return new CalculadoraRoyalties().calcularRoyalties(mes, ano);
    }
}