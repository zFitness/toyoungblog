# Author: xzf
FROM daocloud.io/library/java:openjdk-8-jre-alpine

#作者
MAINTAINER xzf <2097262306@qq.com>

#系统编码
ENV LANG=C.UTF-8 LC_ALL=C.UTF-8

VOLUME /tmp

ADD target/BlogBB-1.0.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]

EXPOSE 8080
