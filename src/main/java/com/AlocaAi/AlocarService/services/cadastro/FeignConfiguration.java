package com.AlocaAi.AlocarService.services.cadastro;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import feign.okhttp.OkHttpClient;

@Configuration 
public class FeignConfiguration {
    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    } 
}