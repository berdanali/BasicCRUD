package com.example.basiccrud.dto;
//api tabanlı geliştirmlerde kullanılır dto, entitiylerimizi api ler ile direkt olarak dış dünyaya açmak sakıncalı olur
//client a gereksiz alanları göndermek istemeyebiliriz bunun için dto lara ihtiyaç var

import lombok.Data;

@Data
public class UserDto {

    private String firstName;
    private String lastName;
}
