package com.mustache.bbs3.repository;

import com.mustache.bbs3.domain.entity.Hospital;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    List<Hospital> findByBusinessTypeNameIn(List<String> businessTypes);
    List<Hospital> findByRoadNameAddressContaining(String keyword);
    Page<Hospital> findByRoadNameAddressContaining(String keyword, Pageable pageable);
    List<Hospital> findByHospitalNameStartsWith(String keyword);
    List<Hospital> findByHospitalNameEndsWith(String keyword);
    List<Hospital> findByPatientRoomCountGreaterThanAndPatientRoomCountLessThan(int var1, int var2);
    List<Hospital> findByPatientRoomCountBetween(int a, int b);
}