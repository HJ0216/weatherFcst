package com.example.demo.entity.mid;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class MidFcst {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "contents", length = 1_000)
    private String wfSv;

    public MidFcst() {
    }
    public MidFcst(String wfSv) {
        this.wfSv = wfSv;
    }
}
