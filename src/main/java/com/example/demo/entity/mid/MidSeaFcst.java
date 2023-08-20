package com.example.demo.entity.mid;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class MidSeaFcst {

    @Id
    @GeneratedValue
    private Long id;

    private String regId;

    private String wf3Am;
    private String wf3Pm;
    private String wf4Am;
    private String wf4Pm;
    private String wf5Am;
    private String wf5Pm;
    private String wf6Am;
    private String wf6Pm;
    private String wf7Am;
    private String wf7Pm;
    private String wf8;
    private String wf9;
    private String wf10;

    private String wh3AAm;
    private String wh3APm;
    private String wh3BAm;
    private String wh3BPm;
    private String wh4AAm;
    private String wh4APm;
    private String wh4BAm;
    private String wh4BPm;
    private String wh5AAm;
    private String wh5APm;
    private String wh5BAm;
    private String wh5BPm;
    private String wh6AAm;
    private String wh6APm;
    private String wh6BAm;
    private String wh6BPm;
    private String wh7AAm;
    private String wh7APm;
    private String wh7BAm;
    private String wh7BPm;
    private String wh8A;
    private String wh8B;
    private String wh9A;
    private String wh9B;
    private String wh10A;
    private String wh10B;

}
