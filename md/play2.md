# The High Velocity  
# Web Framework  
# For Java and Scala

2016-06-27<br/>
JJUG ナイトセミナー

---
## 序文  
```
Javaでシステム構築を行う時に、フレームワークは欠かせないものとなっているでしょう。  
技術のトレンドの移り変わりと共に、様々なフレームワークが生まれ、形を変え、あるいは
EoLを迎えています。

今月のJavaナイトセミナーでは、そのようなフレームワークの中から次の3つについて、
特徴や使い方などを紹介いたします。

WildFly Swarm
Play Framework
Spring Boot

新しいシステムを開発する際に利用するフレームワークを悩んでいる方や、いま使っている
フレームワークをより使い込むために機能を知りたい方、また技術のトレンドを把握して
おきたい方などに、ぜひご参加いただきたいです。
```

---
## テーマピックアップ
- Java フレームワーク
- 技術のトレンドの移り変わり
- 様々なフレームワークが生まれ、形を変え、  
  あるいはEoL
- フレームワークの (略) 特徴や使い方などを紹介
- 新しいシステムを開発する際に利用する  
  フレームワークを悩んでいる方
- ~~いま使っているフレームワークをより  
  使い込むために機能を知りたい方~~
- 技術のトレンドを把握しておきたい方


---
## 想定聴衆
- Java エンジニア
  - Scala エンジニアは多くない
- フレームワーク利用率
  1. Seasar2
  2. Struts1/2
  3. Spring
  4. JavaEE
  5. その他
- Seasar2, Struts1/2 からの移行先に  
  悩んでいる


---
## ゴール
- Play Framework の利点/欠点を  
  正しく理解してもらう
- Seasar2, Struts1/2 からの移行先を  
  正しく判断してもらう
  - Play Framework でなくともよい
- Scala に興味を持ってもらう
- 翻訳を手伝ってもらう

---
## 他の登壇内容
- Spring Boot
  - Spring MVC
- Wildfly Swarm
  - JavaEE

```
※ Spring MVC, JavaEE ユーザは移行の必要に迫られていないはず
```

---
## 共通点
- JVM で動作する Web フレームワーク
- 組み込みサーバで動作
  - クラウド/MSA 時代への対応

```
※ 共通点は Play Framework の利点/欠点ではないので説明しない
```

---
## 差異
### Play1/2
- Servlet API 非依存
- ステートレス
- スケーラブル
- ホットリロード
- ライブコンパイル
- フルスタック

```
※ 差異が Play Framework の利点/欠点になるので詳しく説明する
```

---
## 差異
### Play1
- とくになし

---
## 差異
### Play2
- Scala 製
  - Java/Scala API
- 型安全
  - ルーティング
  - ビューテンプレート
- 非同期処理
  - Akka
- アセット管理


---
## Agenda
- 自己紹介 (2min)
- アンケート (3min)
- なぜ Play? (3min)
- Play とは
  - Play Framework (10min)
  - Play1 (5min)
  - Play2 (10min)
- まとめ (2min)

---
## 自己紹介
- 梅澤 雄一郎
- 株式会社 DTS
  - オムニチャネル案件ビッグデータ担当
- 業務外
  - Play Framework ドキュメント翻訳  
    (協力者募集中!)
  - WEB+DB PRESS vol.71 寄稿
  - Developer's Summit 2014 登壇

---
## アンケート
どのフレームワークを使っていますか？
1. Seasar2 (SAStruts)
2. Struts1
3. Struts2
4. Spring Framework (Spring MVC)
5. JavaEE (JSF)
6. Play1
7. Play2
8. その他

---
## なぜ Play?

---
## Play Framework の歴史
|        |2009|2010|2011|2012|2013    |2014|2015   |2016  |
|--------|----|----|----|----|--------|----|-------|------|
|Play1   |1.0 |1.1 |1.2 |    |        |    |1.3/1.4|1.4.2 |
|Play2   |    |    |    |2.0 |2.1/2.2 |2.3 |2.4    |2.5.4 |

---
## 他のフレームワークの歴史
|        |2009  |2010   |2011   |2012 |2013    |2014  |2015    |2016  |
|--------|------|-------|-------|-----|--------|------|--------|------|
|S2(2.4) |.40   |.43    |.45    |.46  |.47     |.48   |        |EOL   |
|Struts1 |1.3.10|       |       |     |EOL     |      |        |      |
|Struts2 |2.1.8 |2.2.1.1|2.3.1.1|2.3.8|2.3.16  |2.3.20|2.3.24.1|2.5   |
|Spring  |3.0   |       |3.1    |3.2  |4.0     |4.1   |4.2     |4.3   |
|JavaEE  |6     |       |       |     |7       |      |        |      |
|Rails   |2.3   |3.0    |3.1    |3.2  |4.0     |4.1   |5.0beta |      |

---
## 周辺の歴史
|        |2009|2010|2011|2012|2013    |2014|2015   |2016  |
|--------|----|----|----|----|--------|----|-------|------|
|Java    |    |    |7   |    |        |8   |       |      |
|Windows |7   |    |    |8   |8.1     |    |10     |      |
|IE      |8   |    |9   |10  |11      |    |       |      |
|iPhone  |3GS |4   |4S  |5   |5s      |6   |6s     |SE    |

---
## 2009 - 2011
- Rails 絶好調
- Java の停滞感
  - S2 機能追加停止
  - Oracle による Sun の買収
- クラウド/モバイルの足音
- Java にも Rails がほしい
  - Play1

---
## 2012 - 
- フレームワークの世代交代
  - Struts1 EOL
  - Seasar2 EOL
- Java の復活
  - Java 8, Spring 4, JavaEE 7
- クラウド/モバイルの本格化
- Java/MVC フレームワークの先へ
  - Play2

---
## Play とは

---
## Play Framework
- Web フレームワーク
  - ~~Java フレームワーク~~
  - Servlet API 非依存
- ポータブルアプリケーション
  - 組み込み Netty
- ステートレス
  - Cookie セッション
- スケーラブル

---
## Play Framework
- ホットリロード
- ライブコンパイル
  - 組み込み Eclipse コンパイラ
- モジュール
- 依存性管理
- スキーマ管理

---
## Play Framework
- フルスタック
  - MVC
  - ORM
  - WebSocket
  - Web サービスクライアント
  - JSON, XML
  - Cache
  - Job
  - Test
  - etc.

---
## Play1
- Zengularity (旧 Zenexity)
  - Guillaume Bort (@guillaumebort)
- Java 製 / Java 用
- Groovy テンプレート
- Python スクリプト
- ivy

---
## Play1 の使い方
- zip をダウンロードする
- 任意の場所に展開する
- PATH を通す

---
## Play1 の使い方
プロジェクトを作る
```sh
C:\sample\play2>play new play1sample
~        _            _
~  _ __ | | __ _ _  _| |
~ | '_ \| |/ _' | || |_|
~ |  __/|_|\____|\__ (_)
~ |_|            |__/
~
~ play! 1.4.2, https://www.playframework.com
~
~ The new application will be created in C:\sample\play2\play1sample
~ What is the application name? [play1sample]
~
~ OK, the application is created.
~ Start it with : play run play1sample
~ Have fun!
~
```

---
## Play1 の使い方
起動する
```
C:\sample\play2\play1sample>play run
~        _            _
~  _ __ | | __ _ _  _| |
~ | '_ \| |/ _' | || |_|
~ |  __/|_|\____|\__ (_)
~ |_|            |__/
~
~ play! 1.4.2, https://www.playframework.com
~
~ Ctrl+C to stop
~
~ using java version "1.8.0_45"
(snip)
13:41:09,527 WARN  ~ You're running Play! in DEV mode
13:41:09,597 INFO  ~ Listening for HTTP on port 9000 (Waiting a first request to start) ...
~ Server is up and running
```
localhost:9000 にアクセスする

---
## Play1 の使い方
- インメモリデータベースを有効にする
- evolutions スクリプトを書く
- モデルを書く
- コントローラを書く
- ビューを書く
- localhost:9000 にアクセスする

---
## Play1 の良いところ
- 簡単
- コンパイル速い

---
## Play1 の悪いところ
- 開発が停滞
- 斬新杉  
  ![](img/play2_001.jpg)

---
## Play2
- Lightbend (旧 Typesafe)
  - James Roper (@jroper)
- Scala 製 / Scala, Java 用
- Scala テンプレート
- Activator
- sbt

---
## Play2 の使い方
- activator をダウンロードする
- 任意の場所に展開する
- PATH を通す

---
## Play2 の使い方
activator でプロジェクトを作る
```bat
C:\sample\play2>activator list-templates
(snip)
Featured Seed Templates:
(snip)
  play-java
  play-scala
Other Seed Templates:
(snip)
  play-java-2.3
  play-java-2.4
(snip)
C:\play2>activator new play2sample play-java-2.4
(snip)
OK, application "play2sample" is being created using the "play-java-2.4" template.

To run "play2sample" from the command line, "cd play2sample" then:
C:\sample\play2\play2sample/activator run
(snip)
```

---
## Play2 の使い方
- activator ui で作る

---
## Play2 の使い方
起動する
```bat
C:\sample\play2\play2sample>activator run
(snip)
[info] --- (Running the application, auto-reloading is enabled) ---
[info]
[info] p.c.s.NettyServer - Listening for HTTP on /0:0:0:0:0:0:0:0:9000
[info]
[info] (Server started, use Ctrl+D to stop and go back to the console...)
[info]
```
localhost:9000 にアクセスする

---
## Play2 の使い方
- 依存性を追加する
- インメモリデータベースを有効にする
- evolutions スクリプトを書く
- モデルを書く
- コントローラを書く
- ビューを書く
- localhost:9000 にアクセスする

---
## Play2 の使い方
- Java/Scala 混在
- 静的検査
  - コード
  - ルート
  - テンプレート
  - アセット
- 非同期処理

---
## Play2 の良いところ
- 簡単
- 静的検査
- 非同期処理

---
## Play2 の悪いところ
- コンパイル遅い
- 下位非互換

---
## まとめ
- Play Framework
  - Web フレームワーク
  - ポータブルアプリケーション
  - ステートレス
  - スケーラブル
  - ホットリロード
  - ライブコンパイル
  - モジュール
  - 依存性管理
  - スキーマ管理

---
## まとめ
- Play1
  - Java 製 / Java 用
- Play2
  - Scala 製 / Scala, Java 用
  - 静的検査
  - 非同期
  - アセット管理

---
## まとめ
- Play1 の良いところ/悪いところ
- Play2 の良いところ/悪いところ

---
## 参考
- [Philosophy](https://playframework.com/documentation/ja/2.4.x/Philosophy)
- https://groups.google.com/d/msg/play-framework/jNyoIWv_xGQ/URpYquncn2oJ
- [なぜ Play は Servlet を使っていないのか（Why there is no servlets in Play 翻訳） - ikeike443のブログ](http://ikeike443.hatenablog.com/entry/20120107/p1)
- [Seasar2を新規案件に採用するのはそろそろやめたほうがいい - きしだのはてな](http://d.hatena.ne.jp/nowokay/20131107)
- [クラウド上のサービス開発の新しい動向 --- JavaEE7とPlay2.0 ---](http://www.slideshare.net/maruyama097/javaee7play20)

---
## 参考
- [Having Fun with Play](http://www.slideshare.net/crnixon/having-fun-with-play)
- [Java ラブなヌーラボにおける Scala + Playframework 体験記 // Speaker Deck](https://speakerdeck.com/nulabinc/java-rabunanuraboniokeru-scala-plus-playframework-ti-yan-ji)
- [java - Play! framework uses a <lot> of statics - Stack Overflow](http://stackoverflow.com/questions/5192904/play-framework-uses-a-lot-of-statics/5193721#5193721)
- [【Play Framework 2.4】Ebeanを使った検索処理 - もふもふした技術メモ](http://mofmof721.hatenablog.com/entry/2015/12/27/214818)
- [Play and Reactive Streams #play_ja // Speaker Deck](https://speakerdeck.com/okapies/play-and-reactive-streams-number-play-ja)

---
## 参考
- [Play, Anatomy of a web framework: The Web Server.](http://jto.github.io/articles/play_anatomy_part1_bootstrap/)
- [Play, Anatomy of a web framework: Hot redeploy.](http://jto.github.io/articles/play_anatomy_part2_sbt/)
- [Play, Anatomy of a web framework: Routing and reverse routing.](http://jto.github.io/articles/play_anatomy_part3_routing/)