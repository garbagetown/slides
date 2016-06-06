# Spring Boot の紹介

2016-06-10<br/>
DTS Developer's Meetup #11

---
## 自己紹介
- 梅澤 雄一郎
- 法人通信事業本部 第二法人事業部
  - オムニチャネル案件ビッグデータ担当
  - ITA-s
- 業務外
  - Play Framework ドキュメント翻訳  
    (協力者募集中!)
  - WEB+DB PRESS vol.71 寄稿
  - Developer's Summit 2014 登壇

---
## アンケート

1. Spring Boot を知っている
2. Spring Framework を知っている
3. Java エンジニアではない
4. エンジニアではない

良い/悪いではないので恥ずかしがらずに  
 (・ω・)ノ

---
## 今日のゴール
- Java フレームワーク難民の救済
  - Struts 1 EOL
  - Seasar2 EOL
  - Struts 2 脆弱性大杉
- 近い将来への備え
  - クラウド
  - マイクロサービスアーキテクチャ

---
## 宣伝
- JJUG ナイトセミナー

---
## Spring Boot とは
- 既存の Spring Framework 資産を  
  簡単かつモダンに活用する仕組み
- 依存性管理と自動設定を行う基盤
- ~~フレームワーク~~
- ~~ライブラリ~~

---
## _DEMO_
100 スライドは 1 デモに如かず

---
## プロジェクト生成
GUI でプロジェクト生成
![](img/springboot_001.jpg)

---
## プロジェクト生成
cURL でアクセスすると使い方を表示
```sh
$ curl start.spring.io
(snip)
The URI templates take a set of parameters to customize the result of a request
to the linked resource.
+-----------------+------------------------------------------+-----------------+
| Parameter       | Description                              | Default value   |
+-----------------+------------------------------------------+-----------------+
| applicationName | application name                         | DemoApplication |
| artifactId      | project coordinates (infer archive name) | demo            |
| baseDir         | base directory to create in the archive  | no base dir     |
(snip)
To create a web/data-jpa gradle project unpacked:
    $ curl https://start.spring.io/starter.tgz -d dependencies=web,data-jpa \
                 -d type=gradle-project -d baseDir=my-dir | tar -xzvf -
(snip)
```

---
## プロジェクト生成
CUI でプロジェクト生成
```sh
$ curl https://start.spring.io/starter.tgz \
> -d dependencies=web \
> -d applicationName=SpringBootSample \
> -d artifactId=spring-boot-sample \
> -d baseDir=spring-boot-sample \
> -d groupId=example | tar zxvf -
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100 50087  100 49965  100   122  37551     91  0:00:01  0:00:01 --:--:-- 38732
spring-boot-sample/mvnw
(snip)
spring-boot-sample/pom.xml
spring-boot-sample/src/main/java/com/example/SpringBootSample.java
spring-boot-sample/src/main/resources/application.properties
spring-boot-sample/src/test/java/com/example/SpringBootSampleTests.java
```

---
## Hello, Spring Boot!
`@RestController` でエンドポイントを作る
```java
package com.example;
(snip)
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
---
## Hello, Spring Boot!
組み込み Tomcat を起動
```sh
$ mvn spring-boot:run
(snip)
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.3.5.RELEASE)
(snip)
INFO : Mapped "{[/]}" onto public java.lang.String com.example.SpringBootSample.hello()
(snip)
INFO : Tomcat started on port(s): 8080 (http)
INFO : Started SpringBootSample in 2.205 seconds (JVM running for 4.526)
```
```sh
$ curl localhost:8080
Hello, Spring Boot!
```

---
## Hello, Spring Boot!
実行可能 JAR を作って起動
```sh
$ mvn package
(snip)
[INFO] Building jar: /Users/garbagetown/Desktop/spring-boot-sample/target/spring-boot-sample-0.0.1-SNAPSHOT.jar
(snip)
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 10.909 s
[INFO] Finished at: 2016-06-02T02:31:39+09:00
[INFO] Final Memory: 15M/143M
[INFO] ------------------------------------------------------------------------
```
```sh
$ java -jar target/spring-boot-sample-0.0.1-SNAPSHOT.jar 
(snip)
INFO : Tomcat started on port(s): 8080 (http)
INFO : Started SpringBootSample in 7.46 seconds (JVM running for 8.261)
```
```sh
$ curl localhost:8080
Hello, Spring Boot!
```

---
## application.properties
例えばポート番号を変更する
```sh
$ cat src/main/resources/application.properties
server.port=8880
```
```sh
$ mvn spring-boot:run
(snip)
INFO : Tomcat started on port(s): 8880 (http)
INFO : Started SpringBootSample in 2.031 seconds (JVM running for 4.326)
```
```sh
$ curl localhost:8880
Hello, Spring Boot!
```

その他の設定項目は [ドキュメント](http://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html) 参照

---
## 環境変数
application.properties の設定よりも優先される
```sh
$ export SERVER_PORT=8888
```
```sh
$ mvn spring-boot:run
(snip)
INFO : Tomcat started on port(s): 8888 (http)
INFO : Started SpringBootSample in 1.75 seconds (JVM running for 4.306)
```
```sh
$ curl localhost:8888
Hello, Spring Boot!
```

優先順位は [ドキュメント](http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html) 参照  
環境ごとに JAR を作り直すのは過去の話

---
## application.yml
YAML 形式でも設定できる
```sh
$ cat src/main/resources/application.yml
greeting: こんにちは
```
UTF-8 で読み込むので日本語でおｋ  
`native2ascii` は過去の話

---
## 設定値、パラメータ、レスポンス
アノテーションで読み込んで出力
```java
package com.example;
(snip)
@RestController
@SpringBootApplication
public class SpringBootSample {
    @Value("${greeting}")
    private String greeting;
    @RequestMapping("/")
    public String hello(@RequestParam String name) {
        return String.format("%s、%sさん！", greeting, name);
    }
(snip)
}
```
```sh
$ curl localhost:8888\?name\=スプリングブート
こんにちは、スプリングブートさん！
```
`characterEncodingFilter` は過去の話

---
## Auto Configuration
依存性を追加するだけで自動設定
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-actuator</artifactId>
</dependency>
```
```sh
$ mvn spring-boot:run
(snip)
INFO : Mapped "{[/dump || /dump.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
INFO : Mapped "{[/beans || /beans.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
INFO : Mapped "{[/trace || /trace.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
INFO : Mapped "{[/configprops || /configprops.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
INFO : Mapped "{[/mappings || /mappings.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
INFO : Mapped "{[/health || /health.json],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.HealthMvcEndpoint.invoke(java.security.Principal)
INFO : Mapped "{[/info || /info.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
INFO : Mapped "{[/autoconfig || /autoconfig.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
INFO : Mapped "{[/env/{name:.*}],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EnvironmentMvcEndpoint.value(java.lang.String)
INFO : Mapped "{[/env || /env.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
INFO : Mapped "{[/metrics/{name:.*}],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.MetricsMvcEndpoint.value(java.lang.String)
INFO : Mapped "{[/metrics || /metrics.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
```

---
## actuator
ヘルスチェック
```sh
$ curl localhost:8888/health
{"status":"UP","diskSpace":{"status":"UP","total":988061626368,"free":255034015744,"threshold":10485760}}
```

設定情報
```sh
$ curl localhost:8888/configprops | jq -r '.serverProperties .properties .port'
(snip)
8888
```

メトリクス
```sh
$ curl localhost:8888/metrics | jq -r
(snip)
{
  "mem": 433676,
  "mem.free": 143194,
(snip)
```

---
## _DEMO2_

![](img/springboot_002.jpg)

<small>Powerd by [Iconset:small-n-flat icons - Download 148 free & premium icons on Iconfinder](https://www.iconfinder.com/iconsets/small-n-flat)</small>

---
## 依存性追加

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

---
## Flyway
マイグレーションファイルを作る
```sql
$ cat src/main/resources/db/migration/V1__create_database.sql
CREATE TABLE EMPLOYEE (
  id mediumint(8) unsigned NOT NULL auto_increment,
  NAME varchar(255) default NULL,
  PHONE varchar(100) default NULL,
  EMAIL varchar(255) default NULL,
  PRIMARY KEY (id)
) AUTO_INCREMENT=1;

INSERT INTO EMPLOYEE (NAME,PHONE,EMAIL) VALUES ('Cullen Huff','012-412-8434','Integer@necimperdietnec.ca');
INSERT INTO EMPLOYEE (NAME,PHONE,EMAIL) VALUES ('Amir Byers','027-922-6220','tempor.lorem@aenim.net');
(snip)
```
JPA のテーブル作成機能を無効にする
```sh
$ grep ddl src/main/resources/application.properties
spring.jpa.hibernate.ddl-auto=none
```

---
## Entity
Lombok を使って Entity クラスを作る
```java
package com.example;

import javax.persistence.*;
import lombok.Data;

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

---
## Repository
Spring Data JPA が提供している  
`JpaRepository` を継承するだけ
```java
package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
```

---
## Controller
Entity を取得して返却する Controller クラスを作る
```java
package com.example;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

---
## REST API
サーバを起動して cURL でアクセスする
```sh
$ mvn spring-boot:run
(snip)
INFO : Tomcat started on port(s): 8888 (http)
INFO : Started SpringBootSample in 4.042 seconds (JVM running for 8.691)
```
```sh
$ curl localhost:8888/employee | jq
(snip)
[
  {
    "id": 1,
    "name": "Cullen Huff",
    "phone": "012-412-8434",
    "email": "Integer@necimperdietnec.ca"
  },
(snip)
```

---
## 仕組み

---
## 依存性解決
親に `spring-boot-starter-parent` を指定
```xml
    <artifactId>spring-boot-sample</artifactId>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
    </parent>
```
さらに `spring-boot-dependencies` を指定
```xml
    <artifactId>spring-boot-starter-parent</artifactId>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-dependencies</artifactId>
    </parent>
```

---
## 依存性解決
依存性のバージョンを一元管理
```xml
    <artifactId>spring-boot-dependencies</artifactId>
    <properties>
        <flyway.version>3.2.1</flyway.version>
        <h2.version>1.4.191</h2.version>
        (snip)
    </properties>
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.flywaydb</groupId>
                <artifactId>flyway-core</artifactId>
                <version>${flyway.version}</version>
            </dependency>
            <dependency>
                <groupId>com.h2database</groupId>
                <artifactId>h2</artifactId>
                <version>${h2.version}</version>
            </dependency>
        </dependencies>
        (snip)
    </dependencyManagement>
```

---
## 自動設定
`@EnableAutoConfiguration` で  
`o.s.b.autoconfigure` 配下を走査
```java
@SpringBootApplication
public class SpringBootSample {
  (snip)
}
```
```java
package org.springframework.boot.autoconfigure;
(snip)
@Configuration
@EnableAutoConfiguration
@ComponentScan
public @interface SpringBootApplication {
  (snip)
}
```

---
## 自動設定
特定のクラスやビーンの存在状況に応じて自動設定
```java
package org.springframework.boot.autoconfigure.web;
(snip)
@Configuration
@ConditionalOnWebApplication
@Import(EmbeddedServletContainerCustomizerBeanPostProcessorRegistrar.class)
public class EmbeddedServletContainerAutoConfiguration {
    (snip)
    @Configuration
    @ConditionalOnClass({ Servlet.class, Tomcat.class })
    @ConditionalOnMissingBean(value = EmbeddedServletContainerFactory.class, search = SearchStrategy.CURRENT)
    public static class EmbeddedTomcat {
        @Bean
        public TomcatEmbeddedServletContainerFactory tomcatEmbeddedServletContainerFactory() {
            return new TomcatEmbeddedServletContainerFactory();
        }
    }
```

---
## Pros/Cons

---
## Pros
- とにかく簡単
- 既存技術をそのまま利用できる
  - Maven/Gradle
  - Spring MVC
  - Spring Data JPA
  - etc.
- [ドキュメント](https://spring.io/docs)、[サンプル](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples) が充実
- クラウド/MSA 時代に対応

---
## Cons
- サーバ再起動が必要かつ重い
  - [Developer tools](http://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-devtools.html) に期待
  - [JRebel](https://zeroturnaround.com/software/jrebel/) を買う
- [JSP 非推奨](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-jsp-limitations)
  - SPA/MSA 時代には無用の長物

---
## おまけ

---
## Fully Executable JAR
リンクを貼るだけで service 起動
```xml
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <configuration>
        <executable>true</executable>
    </configuration>
</plugin>
```
```sh
$ mvn package
```
```sh
$ head -50 target/spring-boot-sample-0.0.1-SNAPSHOT.jar
#!/bin/bash
(snip)
# Initialize variables that cannot be provided by a .conf file
WORKING_DIR="$(pwd)"
# shellcheck disable=SC2153
[[ -n "$JARFILE" ]] && jarfile="$JARFILE"
[[ -n "$APP_NAME" ]] && identity="$APP_NAME"
```

---
## banner.txt
起動時の ascii アートをカスタマイズ
```sh
$ vim src/main/resources/banner.txt 
```
```sh
$ mvn spring-boot:run
(snip)
[INFO] --- spring-boot-maven-plugin:1.3.5.RELEASE:run (default-cli) @ spring-boot-sample ---

███████╗████████╗██████╗ ██╗   ██╗████████╗███████╗
██╔════╝╚══██╔══╝██╔══██╗██║   ██║╚══██╔══╝██╔════╝
███████╗   ██║   ██████╔╝██║   ██║   ██║   ███████╗
╚════██║   ██║   ██╔══██╗██║   ██║   ██║   ╚════██║
███████║   ██║   ██║  ██║╚██████╔╝   ██║   ███████║
╚══════╝   ╚═╝   ╚═╝  ╚═╝ ╚═════╝    ╚═╝   ╚══════╝

(snip)
INFO : Tomcat started on port(s): 8080 (http)
INFO : Started SpringBootSample in 5.525 seconds (JVM running for 11.312)
```
[ascii アートを作るサービス](http://patorjk.com/software/taag/#p=display&f=Graffiti&t=Type%20Something%20) で遊ぶ

---
## まとめ

---
## Spring Boot
- 豊富な Spring Framework 資産を簡単に活用
  - Spring MVC
  - Spring Data JPA
  - etc.
- ポータブルなアプリケーションを簡単に作成
  - クラウド
  - マイクロサービスアーキテクチャ
- これまでとこれからを地続きでつなぐ技術

---
## 参考
- 公式ドキュメント
  - [Getting Started · Building an Application with Spring Boot](https://spring.io/guides/gs/spring-boot/)
  - [Spring Boot Reference Guide](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- 日本語情報
  - [Spring Bootで変わる Javaアプリ開発! #jsug](http://www.slideshare.net/makingx/spring-boot-java-jsug)
  - [Spring Boot 使い方メモ - Qiita](http://qiita.com/opengl-8080/items/05d9490d6f0544e2351a#%E5%A4%96%E9%83%A8%E8%A8%AD%E5%AE%9Aexternalized-configuration%E3%82%92%E5%88%A9%E7%94%A8%E3%81%99%E3%82%8B)
- Spring Boot の背景と仕組み
  - [Why SpringBoot? - SivaLabs](http://sivalabs.in/2016/03/why-springboot/)
  - [How SpringBoot AutoConfiguration magic works? - SivaLabs](http://sivalabs.in/2016/03/how-springboot-autoconfiguration-magic/)

---
## おわり