package com.mustache.bbs3.repository;

import com.mustache.bbs3.domain.entity.Hospital;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class HospitalRepositoryTest {

    @Autowired
    HospitalRepository hospitalRepository;


    @Test
    void findById() {
        Optional<Hospital> hospital = hospitalRepository.findById(1);
        Hospital hp = hospital.get();
        System.out.println(hp.getId());
        assertEquals(1,hp.getId());
    }
    @Test
    @DisplayName("BusinessTypeName이 보건소 보건지소 보건진료소인 데이터가 잘 나오는지")
    void findByBusinessTypeNameIn() {
        List<String> inClues = new ArrayList<>();
        inClues.add("보건소");
        inClues.add("보건지소");
        inClues.add("보건진료소");
        List<Hospital> hospitals = hospitalRepository.findByBusinessTypeNameIn(inClues);

        for (var hospital : hospitals) {
            System.out.println(hospital.getHospitalName());
        }

    }

    void printHospitalNameAndAddress(List<Hospital> hospitals) {
        for (var hospital : hospitals) {
            System.out.printf("%s | %s %f\n", hospital.getHospitalName(), hospital.getRoadNameAddress(), hospital.getTotalAreaSize());
        }

        System.out.println(hospitals.size());
    }

    @Test
    void containing() {
        List<Hospital> hospitals = hospitalRepository.findByRoadNameAddressContaining("송파구");
        printHospitalNameAndAddress(hospitals);
    }

    @Test
    void startsWith() {
        List<Hospital> hospitals = hospitalRepository.findByHospitalNameStartsWith("경희");// 가톨릭 서울 연세 경희1
        printHospitalNameAndAddress(hospitals);
    }

    @Test
    void endsWith() {
        List<Hospital> hospitals = hospitalRepository.findByHospitalNameEndsWith("병원");// 가톨릭 서울 연세 경희1
        printHospitalNameAndAddress(hospitals);
    }

    @Test
    void findByPatientRoomCountAndPatientRoomCount() {
        List<Hospital> hospitals = hospitalRepository.findByPatientRoomCountGreaterThanAndPatientRoomCountLessThan(10, 20);// 의원, 병원, 이비인후과, 치과
        printHospitalNameAndAddress(hospitals);
    }
    @Test
    void findByPatientRoomCountBetween() {
        List<Hospital> hospitals = hospitalRepository.findByPatientRoomCountBetween(10, 20);// 의원, 병원, 이비인후과, 치과
        printHospitalNameAndAddress(hospitals);
    }

}