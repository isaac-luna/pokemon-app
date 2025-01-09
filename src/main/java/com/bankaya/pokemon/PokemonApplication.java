package com.bankaya.pokemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;

@SpringBootApplication
public class PokemonApplication extends WsConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(PokemonApplication.class,
                args);
    }

}
