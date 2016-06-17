# Play Framework の<br/>紹介

2016-06-27<br/>
JJUG ナイトセミナー

---
## 想定聴衆
- Java エンジニア
  - Scala エンジニアは多くない
- フレームワーク利用率
  1. Seasar2
  2. Spring
  3. JavaEE
  4. その他
- Struts1/2, Seasar2 からの移行先に悩んでいる？

---
## ゴール
- Play Framework の歴史と利点/欠点を正しく理解してもらう
- Struts1/2, Seasar2 からの移行先を正しく判断してもらう
- Scala に興味を持ってもらう
- 翻訳を手伝ってもらう

---
## 他の登壇内容
- Wildfly Swarm
- Spring Boot

---
## 共通点
- JVM で動作する Web フレームワーク
- 組み込みサーバで動作
  - クラウド/MSA 時代への対応

---
## 差異
### Play1/2
- フルスタック
- サーブレット API 非依存
  - Netty
  - Cookie セッション
  - ライブコンパイル/ホットリロード

### Play1
- とくになし？

### Play2
- Scala 製
  - Java/Scala API
- 型安全
  - ルーティング/リバースルーティング
  - テンプレート引数
- 非同期処理
  - Akka
- アセットパイプライン


---
## Agenda
- Play Framework の歴史
- Play Framework の特徴
- Play Framework 1 の特徴
- Play Framework 2 の特徴
- まとめ

---
## Play Framework の歴史

|2009|2010|2011|2012|2013    |2014|2015    |2016  |
|----|----|----|----|--------|----|--------|------|
|1.0 |1.1 |1.2 |    |        |    |1.3/1.4 |1.4.2 |
|    |    |    |2.0 |2.1/2.2 |2.3 |2.4     |2.5.4 |

---
## Play1
- Zengularity (旧 Zenexity)
- Java 製
- Java 用
- Groovy テンプレート
- Python スクリプト
- ivy

---
## Play2
- Lightbend (旧 Typesafe)
- Scala 製
- Scala/Java 用
- Scala テンプレート
- Activator
- sbt

---
## Play
- Servlet API 非依存
- ステートレスアーキテクチャ
- ホットリロード
- ライブコンパイル
- リバースルーティング
- Evolutions

---
## Play1
- Java の慣習を無視
  - play.mvc.results.Result extends  
    FastRuntimeException
- リフレクション/バイトコード拡張を多用
  - Java.java
  - JPAEnhancer.java
- 関数型機能を独自実装
  - F.java

---
## Play2
- Activator
- 型安全
  - Twirl
- 非同期処理
  - Akka

---
## 参考
- [なぜ Play は Servlet を使っていないのか（Why there is no servlets in Play 翻訳） - ikeike443のブログ](http://ikeike443.hatenablog.com/entry/20120107/p1)
- https://groups.google.com/d/msg/play-framework/jNyoIWv_xGQ/URpYquncn2oJ