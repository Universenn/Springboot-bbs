SELECT * FROM `likelion-db`.nation_wide_hospitals;

-- // nation_wide_hospitals 경기도 수원시 가지고 오기
SELECT * FROM `likelion-db`.nation_wide_hospitals where road_name_address like '경기도 수원%';


-- // 컬럼 business_type_name, hospital_name, road_name_address
-- // 테이블 nation_wide_hospitals
-- // business_type_name 보건소 보건지소만 가지고오기 위 컬럼으로

SELECT business_type_name, hospital_name, road_name_address
FROM `likelion-db`.nation_wide_hospitals
where business_type_name in ('보건소', '보건지소')
;

-- // 컬럼 hospital_name, road_name_address
-- // 테이블 nation_wide_hospitals
-- // hospital_name 피부과 포함한 글자 가지고오기

SELECT hospital_name, road_name_address FROM `likelion-db`.nation_wide_hospitals
where road_name_address like "경기도 수원시%"
  and hospital_name like "%피부과%"
;