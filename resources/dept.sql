-- DATABASE 생성
CREATE DATABASE test;

-- DEPT 테이블 삭제
-- DROP TABLE test.dept;

-- DEPT 테이블 생성
CREATE TABLE test.dept
(
    deptno SMALLINT,
    dname  varchar(20),
    loc    varchar(300),
    PRIMARY KEY ( deptno )
);

-- INSERT 데이터

INSERT INTO test.dept
VALUES ( 10, '혁신기획팀', '전북 군산시 외항로 522' );

INSERT INTO test.dept
VALUES ( 20, '인재개발팀', '서울 마포구 양화로 45' );

INSERT INTO test.dept
VALUES ( 30, '구매1팀', '서울 마포구 양화로 45' );

INSERT INTO test.dept
VALUES ( 40, '소형압연팀', '전북 군산시 외항로 522' );

INSERT INTO test.dept
VALUES ( 50, '설비기획팀', '전북 군산시 외항로 522' );

INSERT INTO test.dept
VALUES ( 60, '제강설비팀', '전북 군산시 외항로 522' );

INSERT INTO test.dept
VALUES ( 70, '영업기획팀', '서울 마포구 양화로 45' );

INSERT INTO test.dept
VALUES ( 80, '마케팅기획팀', '서울 마포구 양화로 45' );

INSERT INTO test.dept
VALUES ( 90, '원자력사업팀', '서울 마포구 양화로 45' );

INSERT INTO test.dept
VALUES ( 100, '1제강팀', '전북 군산시 외항로 522' );