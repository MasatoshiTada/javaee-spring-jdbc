# Payara Micro Maven Pluginのインストール

http://www.coppermine.jp/docs/notepad/2017/06/how-to-use-payara-micro-maven-plugin-ja.html

# ビルド・起動

```bash
$ mvn clean install
$ java -jar target/ROOT-microbundle.jar
```

# テスト

## GET

```bash
$ curl -v -X GET http://localhost:8080/javaee-spring-jdbc-1.0-SNAPSHOT/api/samples
> GET /javaee-spring-jdbc-1.0-SNAPSHOT/api/samples HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.49.0
> Accept: */*
>
< HTTP/1.1 200 OK
< Server: Payara Micro #badassfish
< Content-Type: application/json
< Date: Thu, 22 Jun 2017 11:16:48 GMT
< Content-Length: 121
<
[{"id":1,"name":"name1"},{"id":2,"name":"name2"},{"id":3,"name":"name3"},{"id":4,"name":"name4"},{"id":5,"name":"name5"}]
```

## POST

```bash
$ curl -v -X POST -H "Content-Type: application/json" -d "{\"id\":10,\"name\":\"hello10\"}" http://localhost:8080/javaee-spring-jdbc-1.0-SNAPSHOT/api/samples
> POST /javaee-spring-jdbc-1.0-SNAPSHOT/api/samples HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.49.0
> Accept: */*
> Content-Type: application/json
> Content-Length: 26
>
< HTTP/1.1 201 Created
< Server: Payara Micro #badassfish
< Location: http://localhost:8080/javaee-spring-jdbc-1.0-SNAPSHOT/api/samples/10
< Date: Thu, 22 Jun 2017 11:18:19 GMT
< Content-Length: 0
<
```