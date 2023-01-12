# log4j

대충 로그 찍는 유틸리티라고 생각하면 된다

## 이벤트 레벨

![프로젝트 우클릭 메뉴](/images/level.png)

# Java project 에서 log4j 설정 방법

* log4j-core, log4j-api jar 파일 다운로드 ( [README.md](./README.md) 참조 )
* 다운로드한 두 파일을 프로젝트 루트(/) 경로 바로 아래 resources 폴더를 생성, 복사

![프로젝트 우클릭 메뉴](/images/menu.png)
* 프로젝트명 우클릭, **Build Path** → **Configure Build Path...** 선택

---

![자바 빌드 패스](/images/java_build_path.png)
* **Libraries** 탭, **Classpath** → **Add JARs...** 선택

---

![JAR 추가](/images/jars.png)
* 프로젝트 내부로 옮긴 jar 파일 경로를 찾아 추가하고 **OK** → **Apply and Close**

---

``` xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="INFO" strict="true" name="XMLConfigTest">
    <Filter type="ThresholdFilter" level="trace" />
    <Appenders>
        <Console name="console" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{yyyy-MM-dd HH:mm:ss.SSS} %c %-5p [ %l ] %m%n" disableAnsi="false" />
        </Console>
    </Appenders>
    <Loggers>
        <Logger name="logger" level="DEBUG" additivity="false">
            <AppenderRef ref="console" />
        </Logger>
        <Root level="INFO" additivity="false" />
    </Loggers>
</Configuration>
```
* src 폴더 밑에 log4j2.xml 파일을 생성하고 위 내용 붙여넣기
---

``` java
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GitBranchTest {
    
    // log4j 클래스변수 선언
    private static final Logger logger = LogManager.getLogger( "logger" );
    
    public static void main( String[] args ) {
        // 메서드 내에서 사용
        logger.info( "log4j2 imported" );
    }
}
```

```java
private static final Logger logger = LogManager.getLogger( "logger" );
```

* 클래스변수로 위처럼 선언하고 메서드 내에서 ```logger.info(), logger.debug()``` 등과 같이 사용
