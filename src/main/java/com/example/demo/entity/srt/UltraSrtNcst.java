package com.example.demo.entity.srt;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class UltraSrtNcst {

    @Id
    @GeneratedValue
    private Long id;

    private String baseDate;
    private String baseTime;
    private String category;
    private String nx;
    private String ny;
    private String obsrValue;

}
