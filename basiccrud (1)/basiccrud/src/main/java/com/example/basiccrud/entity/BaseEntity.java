package com.example.basiccrud.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
@MappedSuperclass  // BaseEntitiy sınıfını miras alan her clas bu özlliklerden faydalanacak
@Getter
@Setter
@ToString
public class BaseEntity implements Serializable {

    private Date createdAt;
    private String createdBy;
    private Date updateAt;
    private String updateBy;
}
