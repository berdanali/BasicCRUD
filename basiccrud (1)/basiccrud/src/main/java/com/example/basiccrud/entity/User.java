package com.example.basiccrud.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity // entitiy anatasyonuda veri tabanı bağlantısı için bu sınıfı işaretliyor
@Table(name = "kullanıcılar")
@Data // lombok sayeseinde bu sınıfın geter, setter, toString vs. methodlarını kolayca inject etmiş olduk
public class User extends BaseEntity {
    @Id // bunun bir entitiy sınıfı olması için gerekli bir anatasyon
    @SequenceGenerator(name = "user_seq_gen",sequenceName = "user_gen", initialValue = 100, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq_gen") // sequence diğer tiplere göre daha performanslı
    private Long id;
    private String firstName;
    private String lastName;

}

//hibernate ile oluşturudğumuz bu string tipindeki değerler veritabanına sutunlar olacak işlenecek hibernate sayesinde