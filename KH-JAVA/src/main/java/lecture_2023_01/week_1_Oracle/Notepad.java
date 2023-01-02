package lecture_2023_01.week_1_Oracle;

public class Notepad {
    // 관계형데이터베이스 제품 특징
    // 1. 테이블의 수가 많다.
    // (제1정규화, 제2정규화, 제3정규화, 제4정규화, 제5정규화)
    // 2. join문이 필수이고 복잡도가 증가한다.(인라인뷰, 서브쿼리-)
    // Natural, Self, Outer, 카타시안곱
    // 3. 인덱스 전략을 잘 세워야 한다.
    // 4. 반정규화 하는 경우도 있다. 유지보수나 관리적 측면에서 굳이 반정규화 단행 
    // 5. 옵티마이저 옵션 요구 구매 가능 - 병렬처리
    
    // oracle은 data를 관리하는 구조체로 table을 지원한다.
    // table의 구성요소는 column(세로방향) + row(가로방향)
    // column과 row가 만나면 데이터를 담을 수 있다.
    // table을 만들어주는 언어를 DDL문이라 한다.
    
    // DDL : 구조를 정의하는 언어
    // CREATE TABLE
    // CREATE PROCEDURE
    // CREATE FUNCTION
    
    // DML : 데이터 조작어 DATA MANIPULATION LANGUAGE
    // SELECT - 조회, 검색, 열람 (COMMIT과 ROLLBACK의 대상이 아니다.)
    
    // 실제 TABLE에 변화를 주는 문장 - COMMIT, ROLLBACK의 대상
    // COMMIT - 실제 물리적인 테이블에 반영
    // ROLLBACK - COMMIT 시점 이후에 이전 상태로 돌림 (COMMIT 이전 시점으로는 ROLLBACK 불가)
    // INSERT - 가입, 주문 등록 (삽입 이상 발생주의)
    
    // UPDATE - 수정, 변경 (수정 이상 발생주의)
    
    // DELETE - 삭제 - 회원탈퇴, 주문취소( 삭제하고 INSERT OR UPDATE)
    
    // DCL (DATA CONTROL LANGUAGE) - 데이터베이에 접근하고 객체들을 사용하도록 권한을 주고 회수하는 명령어들을 말한다.
    
    // Table에는 Primary key가 존재한다.
    // Primary key의 제약조건
    // 1. not null - null을 허용하지 않는다. null이란 모르는 값
    // 2. unique - 식별자의 역할을 한다.
    // 3. oracle이 index를 만들어서 제공한다. - Unique한 index
    // 다른 컬럼도 index를 만들 수 있다.( 이 때는 중복이 허용된다. PK가 아니니까)
    
    // null과 0은 다르다.
    
}
