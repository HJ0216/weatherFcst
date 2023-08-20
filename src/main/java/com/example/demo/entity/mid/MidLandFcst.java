package com.example.demo.entity.mid;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class MidLandFcst {

    @Id
    @GeneratedValue
    private Long id;

    private String regId;

    private String rnSt3Am;
    private String rnSt3Pm;
    private String rnSt4Am;
    private String rnSt4Pm;
    private String rnSt5Am;
    private String rnSt5Pm;
    private String rnSt6Am;
    private String rnSt6Pm;
    private String rnSt7Am;
    private String rnSt7Pm;
    private String rnSt8;
    private String rnSt9;
    private String rnSt10;

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

    public MidLandFcst() {
    }

    @Builder // 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함
    public MidLandFcst(String regId, String rnSt3Am, String rnSt3Pm, String rnSt4Am, String rnSt4Pm, String rnSt5Am, String rnSt5Pm, String rnSt6Am, String rnSt6Pm, String rnSt7Am, String rnSt7Pm, String rnSt8, String rnSt9, String rnSt10, String wf3Am, String wf3Pm, String wf4Am, String wf4Pm, String wf5Am, String wf5Pm, String wf6Am, String wf6Pm, String wf7Am, String wf7Pm, String wf8, String wf9, String wf10) {
        this.regId = regId;
        this.rnSt3Am = rnSt3Am;
        this.rnSt3Pm = rnSt3Pm;
        this.rnSt4Am = rnSt4Am;
        this.rnSt4Pm = rnSt4Pm;
        this.rnSt5Am = rnSt5Am;
        this.rnSt5Pm = rnSt5Pm;
        this.rnSt6Am = rnSt6Am;
        this.rnSt6Pm = rnSt6Pm;
        this.rnSt7Am = rnSt7Am;
        this.rnSt7Pm = rnSt7Pm;
        this.rnSt8 = rnSt8;
        this.rnSt9 = rnSt9;
        this.rnSt10 = rnSt10;
        this.wf3Am = wf3Am;
        this.wf3Pm = wf3Pm;
        this.wf4Am = wf4Am;
        this.wf4Pm = wf4Pm;
        this.wf5Am = wf5Am;
        this.wf5Pm = wf5Pm;
        this.wf6Am = wf6Am;
        this.wf6Pm = wf6Pm;
        this.wf7Am = wf7Am;
        this.wf7Pm = wf7Pm;
        this.wf8 = wf8;
        this.wf9 = wf9;
        this.wf10 = wf10;
    }

}
