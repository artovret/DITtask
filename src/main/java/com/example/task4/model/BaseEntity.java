package com.example.task4.model;


import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass // суперкласс для которого не нужно отдельной таблицы
@Data
public class BaseEntity {
    private Long id;
    private Date created;
    private Date updated;

}
