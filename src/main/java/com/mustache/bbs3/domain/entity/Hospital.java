package com.mustache.bbs3.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nation_wide_hospitals") // hospital이라는 테이블이 아님
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {
    @Id // GeneratedValue안씀
    private Integer id; // Long --> bigint

    @Column(name = "hospital_name")
    private String HospitalName;

    private String roadNameAddress;

    public static Hospital of(Integer id) {
        return Hospital.builder().id(id).build();
    }
}