# Play Framework の<br/>紹介

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
- フルスタック
- ステートレス
- スケーラブル
- ホットリロード
- ライブコンパイル

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
  - ルーティング/リバースルーティング
  - テンプレート引数
- 非同期処理
  - Akka
- アセットパイプライン


---
## Agenda
- 自己紹介 (2min)
- アンケート (3min)
- なぜ Play? (5min)
- Play とは
  - Play (10min)
  - Play1 (5min)
  - Play2 (8min)
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
- Play1

---
## 2012 - 
- Struts1 EOL
- Seasar2 EOL
- Java の復活
  - Java 8, Spring 4, JavaEE 7
- クラウド/モバイルの本格化
- Play2

---
## Play とは

---
## Play Framework
- Web フレームワーク
  - Servlet API 非依存
- ポータブルアプリケーション
  - 組み込み Netty
- フルスタック
- ステートレス
  - Cookie セッション
- スケーラブル
  - キャッシュ API

---
## Play Framework
- ホットリロード
- ライブコンパイル
  - 組み込み Eclipse コンパイラ
- 依存性管理
- スキーマ管理

---
## Play1
- Zengularity (旧 Zenexity)
  - Guillaume Bort (@guillaumebort)
- Java 製 / Java 用
- Groovy テンプレート
- Python スクリプト
- ivy

---
## Play2
- Lightbend (旧 Typesafe)
  - James Roper (@jroper)
- Scala 製 / Scala, Java 用
- Scala テンプレート
- Activator
- sbt

---
## まとめ
- Play Framework
  - Servlet API 非依存
  - フルスタック
  - ステートレス
  - スケーラブル
- Play1
  - Java 製 / Java 用
- Play2
  - Scala 製 / Scala, Java 用
  - 型安全
  - 非同期

---
## 参考
- [Philosophy](https://playframework.com/documentation/ja/2.4.x/Philosophy)
- https://groups.google.com/d/msg/play-framework/jNyoIWv_xGQ/URpYquncn2oJ
- [なぜ Play は Servlet を使っていないのか（Why there is no servlets in Play 翻訳） - ikeike443のブログ](http://ikeike443.hatenablog.com/entry/20120107/p1)
- [Seasar2を新規案件に採用するのはそろそろやめたほうがいい - きしだのはてな](http://d.hatena.ne.jp/nowokay/20131107)
- [クラウド上のサービス開発の新しい動向 --- JavaEE7とPlay2.0 ---](http://www.slideshare.net/maruyama097/javaee7play20)
- [Having Fun with Play](http://www.slideshare.net/crnixon/having-fun-with-play)