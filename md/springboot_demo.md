## プロジェクト作成
```sh
curl https://start.spring.io/
```
```sh
curl https://start.spring.io/starter.tgz \
-d dependencies=web \
-d applicationName=SpringBootSample \
-d artifactId=spring-boot-sample \
-d baseDir=spring-boot-sample \
-d groupId=example | tar zxvf -
```
```java
@RestController
@SpringBootApplication
public class SpringBootSample {
  
    @RequestMapping("/")
    public String hello() {
        return "Hello, Spring Boot!";
    }
    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootSample.class, args);
    }
}
```
```sh
cd spring-boot-sample; mvn spring-boot:run
```
```sh
curl localhost:8080
```

## 実行可能JARで起動
```sh
mvn package
java -jar target/spring-boot-sample-0.0.1-SNAPSHOT.jar
```

## ポート番号変更
```sh
server.port=8880
```

## 環境変数
```sh
export SERVER_PORT=8888
```

## YAML
```yml
greeting: こんにちは
```
```java
    
    @Value("${greeting}")
    private String greeting;
    
    @RequestMapping("/")
    public String hello(@RequestParam String name) {
        return String.format("%s、%sさん！", greeting, name);
    }
```
```sh
curl localhost:8888\?name\=スプリングブート
```

## actuator
```xml
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-actuator</artifactId>
    </dependency>
```
```sh
curl localhost:8888/health
curl localhost:8888/configprops | jq
curl localhost:8888/metrics | jq 
```

## DEMO2
```xml
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
      <groupId>com.h2database</groupId>
      <artifactId>h2</artifactId>
    </dependency>
    <dependency>
      <groupId>org.flywaydb</groupId>
      <artifactId>flyway-core</artifactId>
    </dependency>
    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>1.16.8</version>
    </dependency>
```
```sql
CREATE TABLE EMPLOYEE (
  id mediumint(8) unsigned NOT NULL auto_increment,
  NAME varchar(255) default NULL,
  PHONE varchar(100) default NULL,
  EMAIL varchar(255) default NULL,
  PRIMARY KEY (id)
) AUTO_INCREMENT=1;

INSERT INTO EMPLOYEE (NAME,PHONE,EMAIL) VALUES ('Cullen Huff','012-412-8434','Integer@necimperdietnec.ca');
INSERT INTO EMPLOYEE (NAME,PHONE,EMAIL) VALUES ('Amir Byers','027-922-6220','tempor.lorem@aenim.net');
```
```
spring.jpa.hibernate.ddl-auto=none
```
```java
@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue
    Long id;
    String name;
    String phone;
    String email;
}
```
```java
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
```
```java
@RestController
public class EmployeeController {
    
    @Autowired
    EmployeeRepository repository;
    
    @RequestMapping("/employee")
    public List<Employee> findAll() {
        return repository.findAll();
    }
}
```
```sh
curl localhost:8888/employee
```
