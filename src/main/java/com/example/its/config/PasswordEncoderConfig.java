package com.example.its.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class PasswordEncoderConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }

//    @Bean
//    public PasswordEncoder delegatingPasswordEncoder() {
//        String idForEncode = "pbkdf2";
//        Map<String, PasswordEncoder> encoders = new HashMap<>();
//        encoders.put("pbkdf2", Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8());
//        encoders.put("noop", NoOpPasswordEncoder.getInstance());
//
//        return new DelegatingPasswordEncoder(idForEncode, encoders);
//    }
}
