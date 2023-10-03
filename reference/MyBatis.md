# MyBatis 기초 세팅 방법

## [MyBatis docs](https://mybatis.org/mybatis-3/) : 자세한 설명은 매뉴얼 참조

> MyBatis is a first class persistence framework with support for custom SQL, stored procedures and advanced mappings. MyBatis eliminates almost all of the JDBC code and manual setting of parameters and retrieval of results. MyBatis can use simple XML or Annotations for configuration and map primitives, Map interfaces and Java POJOs (Plain Old Java Objects) to database records.

---

1. gradle 프로젝트 `build.gradle` 파일에 [디펜던시](https://mvnrepository.com/artifact/org.mybatis/mybatis)를 추가한다. 그리고 현재 사용하고 있는 DB에 맞는 커넥터 디펜던시도 같이 추가한다.

```groovy
/* 샘플 */
implementation group: 'org.mybatis', name: 'mybatis', version: '3.5.11'
implementation group: 'mysql', name: 'mysql-connector-java', version: '8.0.31'
```

2. 매뉴얼 페이지 참고하여 config 파일을 작성하여 프로젝트 리소스 경로에 저장한다(명명 예시 `mybatis-config.xml`).

   config 파일은 DB 접속정보와, 매퍼(Object와 매핑될 SQL이 저장된 xml 파일) 경로를 지정해야 한다.

   프로젝트에서 설정한 소스 경로를 기준으로 파일 경로를 입력한다.

   경로가 맞지 않을 경우 파일 로드 과정에서 에러 발생.

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "https://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
  <!-- ${driver}, ${url} 등의 변수에 적용될 프로퍼티가 들어있는 properties 파일 경로 -->
  <properties resource="connection.properties" />
  <settings>
      <!-- log4j2를 사용할 경우 쿼리를 로깅 가능 -->
      <setting name="logImpl" value="LOG4J2" />
  </settings>
  <environments default="development">
    <environment id="development">
      <transactionManager type="JDBC"/>
      <dataSource type="POOLED">
        <property name="driver" value="${driver}"/>
        <property name="url" value="${url}"/>
        <property name="username" value="${username}"/>
        <property name="password" value="${password}"/>
      </dataSource>
    </environment>
  </environments>
  <mappers>
    <!-- 매퍼 파일 경로, 여러 매퍼를 등록할 수 있다. -->
    <mapper resource="org/mybatis/example/BlogMapper.xml"/>
  </mappers>
</configuration>
```

3. 다음으로 실제로 SQL문과, 매핑되는 객체 설정이 들어갈 매퍼 파일을 생성하여 config 파일과 동일하게 리소스 경로에 저장한다.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- log4j와 연동할 경우 logger명과 같아야 한다. -->
<mapper namespace="mybatis.test">
    <!-- 동일한 네임스페이스를 가지는 매퍼끼리는 id값들이 서로 중복될 수 없다. -->
    
    <!-- resultMap은 Java의 VO, DTO같은 오브젝트의 필드와 DB 테이블 컬럼을 매핑하는 설정이다. -->
    <!-- type : 클래스 경로, id : resultMap을 식별할 수 있는 네임스페이스 안에서 유니크한 명칭 -->
    <resultMap type="encryption.Encryption" id="encryption">
        <!-- property : 필드명, column : 테이블 컬럼명 -->
        <result property="salt" column="SALT" />
        <result property="password" column="PASSWORD" />
    </resultMap>

    <!-- INSERT문 -->
    <!-- id : Java 코드에서 해당 쿼리를 사용할 때 id로 호출하며 네임스페이스 안에서 유니크해야 한다. -->
    <!-- parameterType : 파라미터로 들어갈 오브젝트 클래스 경로, DTO의 경우 알아서 필드명이 일치하는 필드값을 매핑한다. -->
    <insert id="insertPassword" parameterType="encryption.Encryption" >
        INSERT INTO schema.table
        VALUES ( #{salt}, #{password} );
    </insert>

    <!-- SELECT문 -->
    <!-- resultMap : 위에서 지정한 resultMap에 쿼리 리턴 결과를 Java 오브젝트로 매핑한다. -->
    <select id="getPassword" resultMap="encryption">
        SELECT column
        FROM schema.table
    </select>
</mapper>
```

4. 위에서 설정한 config, mapper 파일을 Java에서 읽어 DB와 연동한다. 아래는 샘플코드이다.

```java
package mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import encryption.Encryption;

public class MyBatisSample {
    public static void main( String[] args ) {
        
        try {
            // config xml 파일의 경로
            final String      resource          = "mybatis-config.xml";
            final InputStream inputStream       = Resources.getResourceAsStream( resource );
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build( inputStream );
            SqlSession        sqlSession        = sqlSessionFactory.openSession();
            // DTO 안에 있는 필드를 자동으로 id="insertPassword" 인 쿼리에 파라미터로 매핑하여 실행
            int               result            = sqlSession.insert( "insertPassword", new Encryption( "String", "String" ) );
            
            if ( result > 0 ) {
                // INSERT 성공 시
            }
            else {
                // INSERT 실패 시
            }
            // 오토커밋 off일 경우 commit or rollback 명시
            sqlSession.commit();
            // 리소스 반납
            sqlSession.close();
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }
    }
}

```
