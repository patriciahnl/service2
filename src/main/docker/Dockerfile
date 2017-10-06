FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD service2-1.0-SNAPSHOT.jar service2.jar
RUN sh -c 'touch /service2.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /service2.jar" ]