package com.example.basiccrud.config;
import org.modelmapper.*;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//dto ve entitiy dönüşümünde model mapper kullandım
// burada bir instance oluşturum ve IOC konteynırı içerisinde tutulmasını sağladım böylece her ihtiyaç olduğunda buradan çağırabilirim

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper getModel(){
        ModelMapper modelMapper= new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
