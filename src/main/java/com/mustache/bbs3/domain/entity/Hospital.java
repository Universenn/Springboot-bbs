package com.mustache.bbs3.domain.entity;

import com.mustache.bbs3.domain.dto.HospitalResponse;
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

    @Column(name = "road_name_address")
    private String roadNameAddress;

    @Column(name = "hospital_name")
    private String hospitalName;

    private Integer patientRoomCount;

    private Integer totalNumberOfBeds;

    private String businessTypeName;

    private Integer businessStatusCode;

    private Float totalAreaSize;
    // HospitalEntity를 HospitalResponse Dto로 만들어주는 부분
    public static HospitalResponse of(Hospital hospital) {
        return new HospitalResponse(hospital.getId(),
                hospital.getRoadNameAddress(), hospital.getHospitalName(),
                hospital.getPatientRoomCount(), hospital.getTotalNumberOfBeds(), hospital.getBusinessTypeName(),
                hospital.getTotalAreaSize());
    }
}